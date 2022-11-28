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
import ma.cnss.projetStage.entities.personnelFile;
import ma.cnss.projetStage.repository.fileRepository;
import ma.cnss.projetStage.repository.personnelFileRepository;

@Service
public class IFilePersonnelMetierImp implements IFilePersonnelMetier {
	@Autowired
	private personnelFileRepository filePersonnelRep;
	
	@Override
	public List<personnelFile> listfiles() {
		// TODO Auto-generated method stub
		return filePersonnelRep.findAll();
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
				personnelFile personnelfile = new personnelFile();
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
				sheet.getRow(10).getCell(10).setCellValue("poste");
				if(row.getCell(0).getCellType() == Cell.CELL_TYPE_STRING) {
					personnelfile.setPoleDirecttionAgence(row.getCell(0).getStringCellValue());
				}
				if(row.getCell(1).getCellType() == Cell.CELL_TYPE_STRING) {
					personnelfile.setAgneceDirectionGenrale(row.getCell(1).getStringCellValue());
				}
				if(row.getCell(2).getCellType() == Cell.CELL_TYPE_STRING) {
					personnelfile.setDirectionAgence(row.getCell(2).getStringCellValue());
				}
				if(row.getCell(3).getCellType() == Cell.CELL_TYPE_STRING) {
					personnelfile.setAffectation(row.getCell(3).getStringCellValue());
				}
				if(row.getCell(4).getCellType() == Cell.CELL_TYPE_STRING) {
					personnelfile.setMatricule(row.getCell(4).getStringCellValue());
				}
				if(row.getCell(5).getCellType() == Cell.CELL_TYPE_STRING) {
					personnelfile.setNom(row.getCell(5).getStringCellValue());
				}
				if(row.getCell(6).getCellType() == Cell.CELL_TYPE_STRING) {
					personnelfile.setPrenom(row.getCell(6).getStringCellValue());
				}
				if(row.getCell(7).getCellType() == Cell.CELL_TYPE_NUMERIC) {
					DataFormatter dataFormatter = new DataFormatter();
					String dateNaissance=dataFormatter.formatCellValue(row.getCell(7));
					personnelfile.setDateNaissance(dateNaissance);
				}
				else if(row.getCell(7).getCellType() == Cell.CELL_TYPE_STRING) {
					personnelfile.setDateNaissance(row.getCell(7).getStringCellValue());
				}
				if(row.getCell(8).getCellType() == Cell.CELL_TYPE_NUMERIC) {
					String Enc1=NumberToTextConverter.toText(row.getCell(8).getNumericCellValue());
					personnelfile.setEnc1(Enc1);
				}
				else if(row.getCell(8).getCellType() == Cell.CELL_TYPE_STRING) {
					personnelfile.setEnc1(row.getCell(8).getStringCellValue());
				}
				if(row.getCell(9).getCellType() == Cell.CELL_TYPE_STRING) {
					personnelfile.setRang(row.getCell(9).getStringCellValue());
				}
				if(row.getCell(10).getCellType() == Cell.CELL_TYPE_STRING) {
					personnelfile.setPoste(row.getCell(10).getStringCellValue());
				}
				
				
				personnelfile.setFileType(FilenameUtils.getExtension(file.getOriginalFilename()));
				filePersonnelRep.save(personnelfile);
				
			} catch (Exception e) {
				// TODO: handle exception
				sheet.getRow(10).createCell(10).setCellValue("poste");
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
				personnelFile afile=new personnelFile(row[0], row[1], row[2], row[3], row[4], row[5], row[6], row[7], row[8], row[9], row[10], (FilenameUtils.getExtension(file.getOriginalFilename())));
				filePersonnelRep.save(afile);
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
			List<personnelFile>listfiles=Arrays.asList(mapper.readValue(inputStream, personnelFile[].class));
			if(listfiles!=null && listfiles.size()>0) {
				for(personnelFile aFile:listfiles) {
					aFile.setFileType(FilenameUtils.getExtension(file.getOriginalFilename()));
					filePersonnelRep.save(aFile);
				}
			}
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}



	


	
	
	



	
}
