package ma.est.org.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ma.est.org.entities.Societe;
import ma.est.org.metier.SocieteMetier;
@Controller
public class SocieteController {
	@Autowired
	private SocieteMetier societeme;
	@GetMapping("/")
	public String afficherSociete(Model model) {
		System.out.println("VVVVVVVVVV");
		List<Societe> soct=societeme.AfficherSociete();
		model.addAttribute("societes", soct);
		return "Index";
	}
	@GetMapping("/show/{id}")
	public String DetailsSociete(@PathVariable Integer id,Model model) {
		model.addAttribute("societe",societeme.getSocieteByCode(id));
		return "showSociete";
	}
	@GetMapping("/societe/new/{id}")
	public String editSocieteForm(@PathVariable Integer id,Model model) {
		
		model.addAttribute("societe",societeme.getSocieteByCode(id));
		return "editsociete";
		
	}
	@RequestMapping(value="/societe/{id}",method= RequestMethod.POST)
	public String updateSociete(@PathVariable Integer id,@ModelAttribute("societe") Societe societe, Model model) {
		System.out.println("gggg");
		Societe existings =societeme.getSocieteByCode(id);
		existings.setNomsociete(societe.getNomsociete());
		existings.setEmail(societe.getEmail());
		existings.setMotdepasse(societe.getMotdepasse());
		existings.setDescription(societe.getDescription());
		//existings.setImage(societe.getImage());
		societeme.modifier(existings);
		 return "redirect:/";
	}
	@RequestMapping("/addsoct")
	public String AjouterSociete(Model model) {
		Societe sct=new Societe();
		model.addAttribute("societe",sct);
		
		
		return "addsociete";
		
	}
	@RequestMapping(value = "/PostAddsociete", method = RequestMethod.POST)
	public String postAjouterSociete(@ModelAttribute("societe") Societe sct,Model model) {
		System.out.println("----------- ici 1-------------");
		societeme.AjouterSociete(sct);
		return DetailsSociete( sct.getId(), model);
	}
	@RequestMapping("/societe/delete/{id}")
	public String deleteArticle(@PathVariable Integer id) {
		System.out.println("\n\n\n\n  ="+id+"\n\n\n\n\n");
		societeme.deleteSocieteById(id);
		return "redirect:/";	
	}

		
	}
	


