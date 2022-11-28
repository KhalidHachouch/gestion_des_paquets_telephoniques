package ma.cnss.projetStage.service;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import ma.cnss.projetStage.entities.AffectationFile;
import ma.cnss.projetStage.repository.fileRepository;

@Service
public class IFileMetierImp implements IFileMetier {
	@Autowired
	private fileRepository fileRep;
	@Override
	public Page<AffectationFile> listfiles(int pageNumber) {
		// TODO Auto-generated method stub
		Pageable pageable =PageRequest.of(pageNumber -1 , 8);
		return fileRep.findAll(pageable);
	}
	
	
	
		@Override
		public boolean saveDataFromUploadfile(MultipartFile file) {
		// TODO Auto-generated method stub
		boolean isFlag = false;
		String extension =FilenameUtils.getExtension(file.getOriginalFilename());
		if(extension.equalsIgnoreCase("json")) {
			isFlag=readDataFromJson(file);
		}else if(extension.equalsIgnoreCase("csv")) {
			isFlag=readDataFromCsv(file);
		}else if(extension.equalsIgnoreCase("xlsx") || extension.equalsIgnoreCase("xls")) {
			isFlag=readDataFromExel(file);
		}
		return isFlag;
	}

	

	private boolean readDataFromExel(MultipartFile file) {
		// TODO Auto-generated method stub
		Workbook workbook =getWorkBook(file);
		Sheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rows=sheet.iterator();
		rows.next();
		 int maxNumOfCells = sheet.getRow(0).getLastCellNum(); // The the maximum number of column
		while(rows.hasNext()) {
			try {
				Row row=rows.next();
				Iterator cells = row.cellIterator();
				AffectationFile affectationFile = new AffectationFile();
				List data = new ArrayList();
                for( int cellCounter = 0
                        ; cellCounter < maxNumOfCells
                        ; cellCounter ++){ // Loop through cells

                    Cell cell;

                    if( row.getCell(cellCounter ) == null ){
                        cell = row.createCell(cellCounter);
                    } else {
                        cell = row.getCell(cellCounter);
                    }

                    data.add(cell);

                }
				sheet.getRow(0).getCell(0).setCellValue("Matricule");
				if(row.getCell(0).getCellType() == Cell.CELL_TYPE_STRING) {
					affectationFile.setMatricule(row.getCell(0).getStringCellValue());
				}
				if(row.getCell(1).getCellType() == Cell.CELL_TYPE_STRING) {
					affectationFile.setNomPrenom(row.getCell(1).getStringCellValue());
				}
				if(row.getCell(2).getCellType() == Cell.CELL_TYPE_STRING) {
					affectationFile.setFeuil1_Poste(row.getCell(2).getStringCellValue());
				}
				if(row.getCell(3).getCellType() == Cell.CELL_TYPE_STRING) {
					affectationFile.setUO_principaleLib(row.getCell(3).getStringCellValue());
				}
				if(row.getCell(4).getCellType() == Cell.CELL_TYPE_STRING) {
					affectationFile.setPoste_categorie_Poste(row.getCell(4).getStringCellValue());
				}
				if(row.getCell(5).getCellType() == Cell.CELL_TYPE_STRING) {
					affectationFile.setCategorie_Poste(row.getCell(5).getStringCellValue());
				}
				if(row.getCell(6).getCellType() == Cell.CELL_TYPE_NUMERIC) {
					String CategorieFlotte=NumberToTextConverter.toText(row.getCell(6).getNumericCellValue());
					affectationFile.setCategorie_Flotte(CategorieFlotte);
				}
				else if(row.getCell(6).getCellType() == Cell.CELL_TYPE_STRING) {
					affectationFile.setCategorie_Flotte(row.getCell(6).getStringCellValue());
				}
				if(row.getCell(7).getCellType() == Cell.CELL_TYPE_STRING) {
					affectationFile.setMobile(row.getCell(7).getStringCellValue());
				}
				if(row.getCell(8).getCellType() == Cell.CELL_TYPE_NUMERIC) {
					String NumeroApple=NumberToTextConverter.toText(row.getCell(8).getNumericCellValue());
					affectationFile.setNumero_Appel(NumeroApple);
				}
				else if(row.getCell(8).getCellType() == Cell.CELL_TYPE_STRING) {
					affectationFile.setNumero_Appel(String.valueOf(row.getCell(8).getStringCellValue()));
				}
				if(row.getCell(9).getCellType() == Cell.CELL_TYPE_STRING) {
					affectationFile.setObservation(row.getCell(9).getStringCellValue());
				}
				if(row.getCell(10).getCellType() == Cell.CELL_TYPE_NUMERIC) {
					DataFormatter dataFormatter = new DataFormatter();
					String DateSortie=dataFormatter.formatCellValue(row.getCell(10));
					affectationFile.setDate_Sortie(DateSortie);
				}
				else if(row.getCell(10).getCellType() == Cell.CELL_TYPE_STRING) {
					affectationFile.setDate_Sortie(row.getCell(10).getStringCellValue());
				}
				if(row.getCell(11).getCellType() == Cell.CELL_TYPE_STRING) {
					affectationFile.setNomination(row.getCell(11).getStringCellValue());
				}
				if(row.getCell(12).getCellType() == Cell.CELL_TYPE_NUMERIC) {
					DataFormatter dataFormatter = new DataFormatter();
					String DateNomination=dataFormatter.formatCellValue(row.getCell(12));
					affectationFile.setDate_Nomination(DateNomination);
				}
				else if(row.getCell(12).getCellType() == Cell.CELL_TYPE_STRING) {
					affectationFile.setDate_Nomination(row.getCell(12).getStringCellValue());
				}
				
				affectationFile.setFileType(FilenameUtils.getExtension(file.getOriginalFilename()));
				fileRep.save(affectationFile);
				
			} catch (Exception e) {
				// TODO: handle exception
				sheet.getRow(0).createCell(0).setCellValue("matricule");
			}
			
			
		}
		return true;
	}

	private Workbook getWorkBook(MultipartFile file) {
		// TODO Auto-generated method stub
		Workbook workbook=null;
		String extension =FilenameUtils.getExtension(file.getOriginalFilename());
		try {
			if(extension.equalsIgnoreCase("xlsx")) {
				workbook=new XSSFWorkbook(file.getInputStream());
				
			}else if(extension.equalsIgnoreCase("xls")) {
				workbook = new HSSFWorkbook(file.getInputStream());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return workbook;
	}

	private boolean readDataFromCsv(MultipartFile file) {
		// TODO Auto-generated method stub
		try {
			InputStreamReader reader=new InputStreamReader(file.getInputStream());
			CSVReader csvReader= new CSVReaderBuilder(reader).withSkipLines(1).build();
			List<String []> rows = csvReader.readAll();
			for (String [] row : rows) {
				AffectationFile afile=new AffectationFile(row[0], row[1], row[2], row[3], row[4], row[5], row[6], row[7], row[8], row[9], row[10], row[11], row[12], (FilenameUtils.getExtension(file.getOriginalFilename())));
				fileRep.save(afile);
			}
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}

	private boolean readDataFromJson(MultipartFile file) {
		// TODO Auto-generated method stub
		
		try {
			InputStream inputStream = file.getInputStream();
			ObjectMapper mapper= new ObjectMapper();
			List<AffectationFile>listfiles=Arrays.asList(mapper.readValue(inputStream, AffectationFile[].class));
			if(listfiles!=null && listfiles.size()>0) {
				for(AffectationFile aFile:listfiles) {
					aFile.setFileType(FilenameUtils.getExtension(file.getOriginalFilename()));
					fileRep.save(aFile);
				}
			}
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}


	
	
	



	
}
