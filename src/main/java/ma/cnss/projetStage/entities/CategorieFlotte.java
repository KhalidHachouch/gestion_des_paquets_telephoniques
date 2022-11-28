package ma.cnss.projetStage.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class CategorieFlotte {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCategorie;
	private String categorieFlotte;
	private int flotteNumero;
	@OneToMany(fetch = FetchType.EAGER,mappedBy ="categorieFlotteAffecter")
	private List<AffectationNumero> affNum;
	public Long getIdCategorie() {
		return idCategorie;
	}
	public void setIdCategorie(Long idCategorie) {
		this.idCategorie = idCategorie;
	}
	public String getCategorieFlotte() {
		return categorieFlotte;
	}
	public void setCategorieFlotte(String categorieFlotte) {
		this.categorieFlotte = categorieFlotte;
	}
	public int getFlotteNumero() {
		return flotteNumero;
	}
	public void setFlotteNumero(int flotteNumero) {
		this.flotteNumero = flotteNumero;
	}
	public List<AffectationNumero> getAffNum() {
		return affNum;
	}
	public void setAffNum(List<AffectationNumero> affNum) {
		this.affNum = affNum;
	}
	public CategorieFlotte(String categorieFlotte, int flotteNumero) {
		super();
		this.categorieFlotte = categorieFlotte;
		this.flotteNumero = flotteNumero;
	}
	public CategorieFlotte() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
