package condorcet.be.demo1.model.harry;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "MAISON")
public class Maison {

    @Id
    @GeneratedValue
    private Long id;

    private String nom;

    @OneToMany(mappedBy = "maison", cascade = CascadeType.ALL)
    private List<Sorcier> sorciers = new ArrayList<>();

    public Maison() {}

    public Maison(String nom){
        this.nom = nom;
    }

    public void addSorcier(Sorcier sorcier) {
        this.sorciers.add(sorcier);
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public List getSorciers() {
        return sorciers;
    }

    public void afficherSorciers() {
        System.out.println("--- Sorciers de la maison " + this.nom + " ---");
        if (this.sorciers.isEmpty()) {
            System.out.println("Aucun sorcier dans cette maison.");
        } else {
            for (Sorcier sorcier : this.sorciers) {
                System.out.println("- " + sorcier.getNom() + " (ID: " + sorcier.getId() + ")");
            }
        }
        System.out.println("------------------------------------");
    }
}
