package condorcet.be.demo1.model.cinecondorcet;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "FILM")
public class Film {

    @Id
    @SequenceGenerator(
            name = "film_seq_gen",
            sequenceName = "FILM_SEQ",
            allocationSize = 1  // <--- C'est le secret pour compter 1, 2, 3...
    )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private int duration;
    private LocalDate datefilm;

    @ManyToOne
    @JoinColumn(name = "REALISATOR_ID")
    private Realisator realisator;

    public Film(String title, int duration, LocalDate date) {
        this.title = title;
        this.duration = duration;
        this.datefilm = date;
    }

    public Film() {}

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public Realisator getRealisator() {
        return realisator;
    }


    public void setRealisator(Realisator nolan) {
        this.realisator = nolan;
    }

}
