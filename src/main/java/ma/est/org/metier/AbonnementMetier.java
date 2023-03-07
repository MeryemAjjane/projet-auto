package ma.est.org.metier;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import ma.est.org.entities.Abonnement;
import ma.est.org.repositories.AbonnementRepository;
@Service
public class AbonnementMetier {
@Autowired
private AbonnementRepository abonnementrepo;
 	 
	public void ajouterAbonnement(Abonnement a) {
		if(a.getCapacite()<a.getMinabonnement()) throw new RuntimeException("impossible!!la capacité doit etre supérieur");
		    abonnementrepo.save(a);
	}
	
	public List<Abonnement> afficherAbonnement() {
		return abonnementrepo.findAll();
	}
	public Abonnement getAbonnementByCode(Integer id) {
		return abonnementrepo.getById(id);
	}
	
    public void deleteAbonnementById(Integer id) {
		abonnementrepo.deleteById(id);
		
	}
    public void modifier(Abonnement abnnouveau) {
		//trouver l'article
		Optional<Abonnement> abnancien=abonnementrepo.findById(abnnouveau.getId());
		Abonnement abn=abnancien.get();
		abn.setCapacite(abnnouveau.getCapacite());
		abn.setPrix(abnnouveau.getPrix());
		abn.setMinabonnement(abnnouveau.getMinabonnement());
		abn.setHeuredepart(abnnouveau.getHeuredepart());
		abn.setHeurearrivee(abnnouveau.getHeurearrivee());
		abn.setVilledepart(abnnouveau.getVilledepart());
		abn.setVillearrivee(abnnouveau.getVillearrivee());
		abn.setTypetransport(abnnouveau.getTypetransport());
		abn.setDatedebut(abnnouveau.getDatedebut());
		abn.setDatefin(abnnouveau.getDatefin());
		abonnementrepo.save(abn);
		
    }   
}
