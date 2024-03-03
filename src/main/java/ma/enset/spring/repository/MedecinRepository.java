package ma.enset.spring.repository;

import ma.enset.spring.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedecinRepository  extends JpaRepository<Medecin, Long>{
    List<Medecin> findByNom(String nom);
}
