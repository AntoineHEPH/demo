package condorcet.be.demo1;

import condorcet.be.demo1.dao.FilmDAO;
import condorcet.be.demo1.dao.RealisatorDAO;
import condorcet.be.demo1.dao.impl.FilmDAOImpl;
import condorcet.be.demo1.dao.impl.RealisatorDAOImpl;
import condorcet.be.demo1.model.cinecondorcet.Film;
import condorcet.be.demo1.model.cinecondorcet.Realisator;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //Init (à faire une seule fois)
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cine-pu");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        //Init les DAO avec le constructeur avec arguments
        RealisatorDAOImpl realisatorDAO = new RealisatorDAOImpl(em, Realisator.class);
        FilmDAOImpl filmDAO = new FilmDAOImpl(em, Film.class);
        try {

            System.out.println("Creating film...");

            Film inception = new Film("Inception", 148, LocalDate.of(2010, 7, 21));
            Film interstellar = new Film("Interstellar", 169, LocalDate.of(2014, 11, 7));

            Realisator nolan = new Realisator("Nolan", "Christopher");

            //Lier le tout :
            nolan.addFilm(inception);
            nolan.addFilm(interstellar);
            System.out.println("HERE");
            System.out.println(realisatorDAO.findAll());
            System.out.println("HERE");

            //Demander à JPA de save tout ça en SQL
            realisatorDAO.create(nolan);

            //grâce a commit, le SQL part vers Oracle
            System.out.println("Data added in Oracle...");

            //Verif : test unitaire :
            System.out.println("Contexte vidé.. relecture depuis la DB");
            //On va chercher le realisateur en DB
            //Realisateur christopher = em.find(Realisateur.class, nolan.getId());
            //System.out.println("Realisateur trouvé : " +  christopher.getNom());
            //System.out.println("Films associés : ");
            //récupérer tous les films correspondants
            List<Film> filmsBytitle = filmDAO.searchByTitle("Interstellar");
            for(Film film : filmsBytitle) {
                System.out.println("film : "+ film.getTitle());
            }
            List<Film> filmsbyrealisator = filmDAO.findByRealisatorId(nolan.getId());
            System.out.println("Films associés à "+ nolan.getName()+ " :");
            for(Film film : filmsbyrealisator) {
                System.out.println("film : "+ film.getTitle());
            }
        } catch (Exception e) {
            if(tx.isActive())
            {
                tx.rollback();
            }
            e.printStackTrace();
        }
        finally {
            em.close();
            emf.close();
        }

    }
}