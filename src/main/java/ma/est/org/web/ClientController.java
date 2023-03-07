package ma.est.org.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ma.est.org.entities.Client;
import ma.est.org.metier.ClientMetier;

public class ClientController {
	@Autowired
	private ClientMetier clientme;
	
	@RequestMapping("/clt")
	public String afficherClient(Model model) {
		List<Client> clts=clientme.listClient();
		model.addAttribute("clients",clts);
		return "client";
		
	}

}
