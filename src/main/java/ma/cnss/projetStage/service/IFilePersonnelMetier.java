package ma.cnss.projetStage.service;

import java.util.List;


import org.springframework.web.multipart.MultipartFile;
import ma.cnss.projetStage.entities.personnelFile;

public interface IFilePersonnelMetier {
	public List<personnelFile>listfiles();
	public boolean saveDataFromUploadfile(MultipartFile file);
	

}
