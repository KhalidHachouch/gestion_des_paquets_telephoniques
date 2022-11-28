package ma.cnss.projetStage.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class numeroTelephone {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idNumeroTelephone;
	private String numero;
	@OneToMany(fetch = FetchType.EAGER,mappedBy ="numeroTelephoneAffecter")
	private List<AffectationNumero> afNumero;
	public Long getIdNumeroTelephone() {
		return idNumeroTelephone;
	}
	public void setIdNumeroTelephone(Long idNumeroTelephone) {
		this.idNumeroTelephone = idNumeroTelephone;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public List<AffectationNumero> getAfNumero() {
		return afNumero;
	}
	public void setAfNumero(List<AffectationNumero> afNumero) {
		this.afNumero = afNumero;
	}
	public numeroTelephone(String numero) {
		super();
		this.numero = numero;
	}
	public numeroTelephone() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
