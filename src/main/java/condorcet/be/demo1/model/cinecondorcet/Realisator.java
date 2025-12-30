package condorcet.be.demo1.model.cinecondorcet;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "REALISATOR")
public class Realisator {

    @Id
    @SequenceGenerator(
            name = "real_seq_gen",
            sequenceName = "REALISATOR_SEQ",
            allocationSize = 1  // <--- C'est le secret pour compter 1, 2, 3...
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "real_seq_gen")
    private Long id;

    private String name;
    private String surname;

    @OneToMany(mappedBy = "realisator", cascade = CascadeType.ALL)
    private List<Film> films = new ArrayList<>();

    public Realisator(String christopher, String nolan, LocalDate localDate) {}

    public Realisator() {}

    public Realisator(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public void addFilm(Film film) {
        this.films.add(film);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }
    public void setSurname(String surname) { this.surname = surname; }
    public void setId(Long id) { this.id = id; }

    public String getSurname() {
        return surname;
    }

    @JsonbTransient
    public List getFilms() {
        return films;
    }



}
