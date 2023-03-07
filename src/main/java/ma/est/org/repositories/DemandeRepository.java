package ma.est.org.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ma.est.org.entities.Demande;
@Repository

public interface DemandeRepository extends JpaRepository<Demande,Integer> {

	

}