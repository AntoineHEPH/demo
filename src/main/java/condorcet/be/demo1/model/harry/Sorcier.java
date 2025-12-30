package condorcet.be.demo1.model.harry;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "SORCIER")
public class Sorcier {

    @Id @GeneratedValue
    private Long id;

    private String nom;
    private String prenom;

    @ManyToOne
    @JoinColumn(name = "MAISON_ID")
    private Maison maison;

    public Sorcier(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public Sorcier() {}

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Maison getMaison() {
        return maison;
    }
}
