
	package ma.est.org.web;

	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.data.repository.query.Param;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.ModelAttribute;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.ResponseBody;
	import org.springframework.web.bind.annotation.RestController;


	import ma.est.org.entities.Abonnement;
import ma.est.org.entities.Client;
import ma.est.org.entities.Demande;
	import ma.est.org.entities.Societe;
	import ma.est.org.metier.DemandeMetier;
	import ma.est.org.metier.AbonnementMetier;
	import ma.est.org.metier.SocieteMetier;

	@Controller
	public class DemandeController {
		@Autowired
		private DemandeMetier demandeme;
		@GetMapping("/adddem")
		public String AjouterDemande(Model model) {
			Demande demande = new Demande();
			model.addAttribute("demande",demande);
		    return "adddem";
			
		}
		
		@PostMapping(value = "/PostAdddemande")
		public String PostAdddemande(@ModelAttribute("demande")Demande demande){
			demandeme.ajouterDemande(demande);
			System.out.println(demande);
			return "/afficherDemande";
		}
		@RequestMapping("/afficherDemande")
		public String afficherDemande(Model model) {
			List<Demande> dem=demandeme.AfficherDemande();
			model.addAttribute("Demandes",dem);
			return "listDemand";
			
		}
		

		
		

	
}
