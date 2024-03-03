package ma.enset.spring.service;

import ma.enset.spring.entities.Medecin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedecinServiceImpl implements MedecinService {
    @Autowired
    ma.enset.spring.repository.MedecinRepository MedecinRepository;
    @Override
    public Medecin ajouterMedecin(Medecin Medecin) {
        return MedecinRepository.save(Medecin);
    }

    @Override
    public List<Medecin> ConsulterTousMedecins() {
        return MedecinRepository.findAll();
    }

    @Override
    public Medecin ConsulterMedecin(Long id) {
        return MedecinRepository.findById(id).get();
    }

    @Override
    public List<Medecin> rechercherMedecins(String nom) {
        return MedecinRepository.findByNom(nom);
    }

    @Override
    public void supprimerMedecin(Long id) {
        MedecinRepository.deleteById(id);
    }

    @Override
    public void modifierMedecin(long id, Medecin newMedecinData) {
        Optional<Medecin> medecin = MedecinRepository.findById(id);
        if (medecin.isPresent()) {
            Medecin modifiedMedecin = medecin.get();
            modifiedMedecin.setNom(newMedecinData.getNom());
            modifiedMedecin.setEmail(newMedecinData.getEmail());
            modifiedMedecin.setSpecialite(newMedecinData.getSpecialite());
            modifiedMedecin.setRendezVous(newMedecinData.getRendezVous());
            MedecinRepository.save(modifiedMedecin);
        } else {
            throw new RuntimeException("Medecin introuvable avec id " + id);
        }
    }
}
