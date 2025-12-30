package condorcet.be.demo1.dao;
import condorcet.be.demo1.model.cinecondorcet.Film;

import java.util.List;

public interface FilmDAO extends GenericDAO<Film, Long> {
    List<Film> findByRealisatorId(Long id);
    List<Film> searchByTitle(String title);


}
