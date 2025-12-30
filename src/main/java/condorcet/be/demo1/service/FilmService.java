package condorcet.be.demo1.service;

import condorcet.be.demo1.dao.FilmDAO;
import condorcet.be.demo1.model.cinecondorcet.Film;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class FilmService {

    @Inject
    private FilmDAO filmDAO;

    public List<Film> findAll() {
        return filmDAO.findAll();
    }

    public Film findById(Long id) {
        return filmDAO.findById(id);
    }

    public List<Film> findByRealisatorId(Long realisatorId) {
        return filmDAO.findByRealisatorId(realisatorId);
    }

    public List<Film> searchByTitle(String title) {
        return filmDAO.searchByTitle(title);
    }

    @Transactional
    public void create(Film film) {
        validateFilmDuration(film);
        
        filmDAO.create(film);
    }

    @Transactional
    public void update(Film film) {
        validateFilmDuration(film);
        
        filmDAO.update(film);
    }


    @Transactional
    public void delete(Film film) {
        filmDAO.delete(film);
    }

    private void validateFilmDuration(Film film) {
        if (film.getDuration() <= 0) {
            throw new BusinessException("La durée d'un film doit être positive");
        }
    }
}
