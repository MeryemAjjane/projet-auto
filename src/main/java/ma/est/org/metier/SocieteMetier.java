package ma.est.org.metier;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import ma.est.org.entities.Societe;
import ma.est.org.repositories.SocieteRepository;
@Service
public class SocieteMetier {
	
	@Autowired
	private SocieteRepository societerepo;
	public List<Societe> AfficherSociete() {
		return societerepo.findAll();
	}
	public void AjouterSociete(Societe s) {
			societerepo.save(s);
	}
	public void modifier(Societe sctnouveau) {
		//trouver l'article
		Optional<Societe> sctAncien=societerepo.findById(sctnouveau.getId());
		Societe sct=sctAncien.get();
		sct.setNomsociete(sctnouveau.getNomsociete());
		sct.setEmail(sctnouveau.getEmail());
		sct.setMotdepasse(sctnouveau.getMotdepasse());
		sct.setDescription(sctnouveau.getDescription());
		//sct.setImage(sctnouveau.getImage());
		societerepo.save(sct);
		
	}
	public Societe getSocieteByCode(Integer id) {
		return societerepo.getById(id);
	}
	public void supprimer(int id) {
		//artRepo.delete(art);
	}
    public void deleteSocieteById(Integer id) {
		societerepo.deleteById(id);
		
	}
	
	

}
