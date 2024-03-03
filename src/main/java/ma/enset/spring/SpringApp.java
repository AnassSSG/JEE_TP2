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
import java.util.stream.Stream;

@SpringBootApplication
public class SpringApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringApp.class, args);
    }
    @Bean
    CommandLineRunner start(PatientService patService , MedecinService medService){
        return args -> {
            Stream.of("Ahmed","Omar","Oussama","Anas").forEach(name->{
                Patient pat = new Patient();
                pat.setNom(name);
                pat.setMalade(name.equals("Ahmed"));
                pat.setDateNaissance(new Date());
                patService.ajouterPatient(pat);
            });
            Stream.of("Adil","Abdellah","Ali").forEach(name->{
                Medecin med = new Medecin();
                med.setNom(name);
                med.setEmail(name+"@gmail.com");
                med.setSpecialite(Math.random() > 0.5 ? "Dentiste" : "Cardiologue");
                medService.ajouterMedecin(med);
            });
        };
    }

}
