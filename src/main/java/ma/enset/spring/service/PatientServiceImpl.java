package ma.enset.spring.service;

import ma.enset.spring.entities.Patient;
import ma.enset.spring.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    PatientRepository patientRepository;
    @Override
    public Patient ajouterPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> ConsulterTousPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient ConsulterPatient(Long id) {
        return patientRepository.findById(id).get();
    }

    @Override
    public List<Patient> rechercherPatients(String nom) {
        return patientRepository.findByNom(nom);
    }

    @Override
    public void supprimerPatient(Long id) {
        patientRepository.deleteById(id);
    }

    @Override
    public void modifierPatient(long id, Patient newPatientData) {
        Optional<Patient> patient = patientRepository.findById(id);
        if (patient.isPresent()) {
            Patient modifiedPatient = patient.get();
            modifiedPatient.setNom(newPatientData.getNom());
            modifiedPatient.setDateNaissance(newPatientData.getDateNaissance());
            modifiedPatient.setMalade(newPatientData.isMalade());
            modifiedPatient.setScore(newPatientData.getScore());
            patientRepository.save(modifiedPatient);
        } else {
            throw new RuntimeException("Patient introuvable avec id " + id);
        }
    }
}
