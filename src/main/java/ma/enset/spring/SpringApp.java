package ma.enset.spring;

import ma.enset.spring.entities.Medecin;
import ma.enset.spring.entities.Patient;
import ma.enset.spring.repository.MedecinRepository;
import ma.enset.spring.service.MedecinService;
import ma.enset.spring.service.PatientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringApp.class, args);
    }
    @Bean
    CommandLineRunner start(PatientService patService , MedecinService medService){
        return args -> {
            // Ajouter quelques patients
            Patient patient1 = new Patient();
            patient1.setNom("Youssef");
            patient1.setDateNaissance(new Date(1990, 5, 15));
            patient1.setMalade(true);
            patient1.setScore(8);
            patService.ajouterPatient(patient1);

            Patient patient2 = new Patient();
            patient2.setNom("Fatima");
            patient2.setDateNaissance(new Date(1985, 9, 23));
            patient2.setMalade(false);
            patient2.setScore(5);
            patService.ajouterPatient(patient2);

            // Ajouter quelques médecins
            Medecin medecin1 = new Medecin();
            medecin1.setNom("Dr. Ahmed");
            medecin1.setEmail("ahmed@example.com");
            medecin1.setSpecialite("Cardiologie");
            medService.ajouterMedecin(medecin1);

            Medecin medecin2 = new Medecin();
            medecin2.setNom("Dr. Salma");
            medecin2.setEmail("salma@example.com");
            medecin2.setSpecialite("Pédiatrie");
            medService.ajouterMedecin(medecin2);


            // Supprimer un patient
            patService.supprimerPatient(patient2.getId());
            System.out.println("Patient supprimé avec succès.");

            // Supprimer un médecin
            medService.supprimerMedecin(medecin1.getId());
            System.out.println("Médecin supprimé avec succès.");

        };
    }

}
