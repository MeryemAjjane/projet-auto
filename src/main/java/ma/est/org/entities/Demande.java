package ma.est.org.entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity

public class Demande {
	
	@Id @GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id;
	private String villedepart;
	private String villearrivee;
	@Temporal(TemporalType.TIME) 
	@DateTimeFormat(pattern = "HH:mm")
	private Date heuredepart;
	@DateTimeFormat(pattern = "HH:mm")
	@Temporal(TemporalType.TIME) 
	private Date heurearrivee;
	public Demande() {
		super();
	}
	public Demande( String villedepart, String villearrivee, Date heuredepart, Date heurearrivee) {
		super();
		this.villedepart = villedepart;
		this.villearrivee = villearrivee;
		this.heuredepart = heuredepart;
		this.heurearrivee = heurearrivee;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	

}

