package ma.enset.spring.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Data
@Getter @Setter @NoArgsConstructor
@AllArgsConstructor
@ToString
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    private boolean malade;
    private int score;
    @OneToMany(mappedBy = "patient")
    private Collection<RendezVous> rendezVous;
}
