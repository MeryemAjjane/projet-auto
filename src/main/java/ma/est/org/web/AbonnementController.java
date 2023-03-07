package ma.est.org.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.validation.Valid;
import ma.est.org.entities.Abonnement;
import ma.est.org.metier.AbonnementMetier;
@Controller
public class AbonnementController {
    @Autowired
    private AbonnementMetier abonnementme;
    @GetMapping("/home")
	 public String getHome() {
		 System.out.println("------------ Ici Home ----------------------- ");
		 return "HomePage";
	 }
    @GetMapping("/abonnement")
    public String afficherAbonnement(Model model) {
        System.out.println("VVVVVVVVVV");
        List<Abonnement> abon=abonnementme.afficherAbonnement();
        model.addAttribute("abonnements", abon);
        return "ShowAbonnement";
    }
    @GetMapping("/abonnement/new/{id}")
    public String editAbonnementForm(@PathVariable Integer id,Model model) {

        model.addAttribute("abonnement",abonnementme.getAbonnementByCode(id));
        return "EditAbonnement";

    }
    @RequestMapping(value="/abonnement/{id}",method= RequestMethod.POST)
    public String updateAbonnement(@PathVariable Integer id,@ModelAttribute("abonnement") Abonnement abonnement, Model model) {
        System.out.println("gggg");
        Abonnement existings =abonnementme.getAbonnementByCode(id);
        existings.setCapacite(abonnement.getCapacite());
        existings.setPrix(abonnement.getPrix());
        existings.setMinabonnement(abonnement.getMinabonnement());
        existings.setHeuredepart(abonnement.getHeuredepart());
        existings.setHeurearrivee(abonnement.getHeurearrivee());
        existings.setVilledepart(abonnement.getVilledepart());
        existings.setVillearrivee(abonnement.getVillearrivee());
        existings.setTypetransport(abonnement.getTypetransport());
        existings.setDatedebut(abonnement.getDatedebut());
        existings.setDatefin(abonnement.getDatefin());
        abonnementme.modifier(existings);
        return "redirect:/abonnement";
    }
    @RequestMapping("/addabon")
    public String AjouterAbonnement(Model model) {
        Abonnement abon=new Abonnement();
        model.addAttribute("abonnement",abon);
        return "addAbonnement";

    }
    @RequestMapping(value = "/PostAddAbon", method = RequestMethod.POST)
    public String postAjouterAbonnement(@ModelAttribute("abonnement") Abonnement abonnement,Model model) {
    	try {
        System.out.println("----------- ici 1-------------");
       
        abonnementme.ajouterAbonnement(abonnement);
        System.out.println("----------- ici 2-------------");
    	}catch (Exception e) {
			model.addAttribute("exception",e);
			return "redirect:/addabon";
		}
        return "redirect:/abonnement";
    }
    @RequestMapping("/abonnement/delete/{id}")
    public String deleteAbonnement(@PathVariable Integer id) {
        System.out.println("\n\n\n\n abnnn ="+id+"\n\n\n\n\n");
        abonnementme.deleteAbonnementById(id);
        return "redirect:/abonnement";
    }




}