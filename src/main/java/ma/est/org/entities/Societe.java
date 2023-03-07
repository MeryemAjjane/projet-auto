package ma.est.org.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
public class Societe {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nomsociete;
	//private String image;
	private String description;
	private String email;
	private String motdepasse;
	
	public Societe(){
	}
	public Societe(String nomsociete, String description,String email,String motdepasse) {//,String image
		super();
		this.nomsociete = nomsociete;
		this.description = description;
		this.email=email;
		this.motdepasse=motdepasse;
		//this.image=image;
		
	}
	
	
	@OneToMany(mappedBy = "societe",fetch = FetchType.LAZY)
	private List<Abonnement> abonnement;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomsociete() {
		return nomsociete;
	}
	public void setNomsociete(String nomsociete) {
		this.nomsociete = nomsociete;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Abonnement> getAbonnement() {
		return abonnement;
	}
	public void setAbonnement(List<Abonnement> abonnement) {
		this.abonnement = abonnement;
	}
	/*public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}*/
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMotdepasse() {
		return motdepasse;
	}
	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}
}
