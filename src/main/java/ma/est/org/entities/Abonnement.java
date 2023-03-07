
package ma.est.org.entities;
import java.util.Date;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
@Entity
public class Abonnement {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message="la capacite est obligatoire !!!")
	private int capacite;
	@NotNull
	private double prix;
	@NotNull
	private int minabonnement;
	@Temporal(TemporalType.TIME) 
	@DateTimeFormat(pattern ="HH:mm")
	@NotNull
	private Date heuredepart;
	@Temporal(TemporalType.TIME) 
	@DateTimeFormat(pattern ="HH:mm")
	@NotNull
	private Date heurearrivee;
	@NotNull
	private String villedepart;
	@NotNull
	private String villearrivee;
	@NotNull
	private String typetransport;
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	@NotNull
	private Date datedebut;
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	@NotNull
	private Date datefin;
	
	@ManyToMany
	private List<Client> clients;
	@ManyToOne
	private Societe societe;
	
	
	public Abonnement() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCapacite() {
		return capacite;
	}
	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getMinabonnement() {
		return minabonnement;
	}
	public void setMinabonnement(int minabonnement) {
		this.minabonnement = minabonnement;
	}
	
	
	public Date getHeuredepart() {
		return heuredepart;
	}
	public void setHeuredepart(Date heuredepart) {
		this.heuredepart = heuredepart;
	}
	public Date getHeurearrivee() {
		return heurearrivee;
	}
	public void setHeurearrivee(Date heurearrivee) {
		this.heurearrivee = heurearrivee;
	}
	public String getVilledepart() {
		return villedepart;
	}
	public void setVilledepart(String villedepart) {
		this.villedepart = villedepart;
	}
	public String getVillearrivee() {
		return villearrivee;
	}
	public void setVillearrivee(String villearrivee) {
		this.villearrivee = villearrivee;
	}
	public List<Client> getClients() {
		return clients;
	}
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	public Societe getSociete() {
		return societe;
	}
	public void setSociete(Societe societe) {
		this.societe = societe;
	}
	
	
	public Abonnement(int capacite, double prix, int minabonnement, Date heuredepart, Date heurearrivee,
			String villedepart, String villearrivee, String typetransport, Date datedebut, Date datefin,
			 Societe societe) {
		super();
		this.capacite = capacite;
		this.prix = prix;
		this.minabonnement = minabonnement;
		this.heuredepart = heuredepart;
		this.heurearrivee = heurearrivee;
		this.villedepart = villedepart;
		this.villearrivee = villearrivee;
		this.typetransport = typetransport;
		this.datedebut = datedebut;
		this.datefin = datefin;
		this.societe = societe;
	}
	public String getTypetransport() {
		return typetransport;
	}
	public void setTypetransport(String typetransport) {
		this.typetransport = typetransport;
	}
	public Date getDatedebut() {
		return datedebut;
	}
	public void setDatedebut(Date datedebut) {
		this.datedebut = datedebut;
	}
	public Date getDatefin() {
		return datefin;
	}
	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}
	
	
		
	
	

}
