package ma.cnss.projetStage.service;



import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import ma.cnss.projetStage.entities.AffectationFile;


public interface IFileMetier {
	Page<AffectationFile> listfiles(int pageNumber);
	public boolean saveDataFromUploadfile(MultipartFile file);
	

}
