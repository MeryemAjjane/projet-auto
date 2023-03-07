package ma.est.org.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ma.est.org.entities.Client;
import ma.est.org.repositories.ClientRepository;

@Service
public class ClientMetier {
	@Autowired
	private ClientRepository clientrepo;
	
	public List<Client> listClient(){
		return clientrepo.findAll();
	}
	
	public void ajouterClient(Client c) {
		clientrepo.save(c);
	}

}
