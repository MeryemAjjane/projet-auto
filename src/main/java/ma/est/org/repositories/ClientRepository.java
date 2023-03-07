package ma.est.org.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.est.org.entities.Client;

public interface ClientRepository extends JpaRepository<Client,Integer>{

}
