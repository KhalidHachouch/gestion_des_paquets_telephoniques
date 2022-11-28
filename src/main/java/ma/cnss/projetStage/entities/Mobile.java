package ma.cnss.projetStage.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Mobile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMobile;
	private String nomMobile;
	@OneToMany(fetch = FetchType.EAGER,mappedBy ="mobileAffecter")
	private List<AffectationNumero> affectaionNum;
	public Long getIdMobile() {
		return idMobile;
	}
	public void setIdMobile(Long idMobile) {
		this.idMobile = idMobile;
	}
	public String getNomMobile() {
		return nomMobile;
	}
	public void setNomMobile(String nomMobile) {
		this.nomMobile = nomMobile;
	}
	public List<AffectationNumero> getAffectaionNum() {
		return affectaionNum;
	}
	public void setAffectaionNum(List<AffectationNumero> affectaionNum) {
		this.affectaionNum = affectaionNum;
	}
	public Mobile(String nomMobile) {
		super();
		this.nomMobile = nomMobile;
	}
	public Mobile() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

}
