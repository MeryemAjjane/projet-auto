package ma.est.org.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import ma.est.org.entities.Abonnement;
import ma.est.org.entities.Demande;
import ma.est.org.entities.Societe;
import ma.est.org.repositories.DemandeRepository;
@Service
public class DemandeMetier {
	@Autowired
	private  DemandeRepository demanderepo;
	
	

	public Demande ajouterDemande(Demande d) {
	   return demanderepo.save(d);
	}
	public List<Demande> AfficherDemande() {
		return demanderepo.findAll();
	}



	
 
}

