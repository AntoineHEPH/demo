package condorcet.be.demo1.service;

import condorcet.be.demo1.dao.FilmDAO;
import condorcet.be.demo1.dao.RealisatorDAO;
import condorcet.be.demo1.model.cinecondorcet.Film;
import condorcet.be.demo1.model.cinecondorcet.Realisator;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class RealisatorService {

    @Inject
    private RealisatorDAO realisatorDAO;

    @Inject
    private FilmDAO filmDAO;

    public List<Realisator> findAll() {
        return realisatorDAO.findAll();
    }

    public Realisator findById(Long id) {
        return realisatorDAO.findById(id);
    }

    @Transactional
    public void create(Realisator realisator) {
        realisatorDAO.create(realisator);
    }

    @Transactional
    public void update(Realisator realisator) {
        realisatorDAO.update(realisator);
    }

    @Transactional
    public void delete(Realisator realisator) {
        List<Film> films = filmDAO.findByRealisatorId(realisator.getId());
        if (films != null && !films.isEmpty()) {
            throw new BusinessException(
                "Impossible de supprimer ce réalisateur car il possède " + films.size() + " film(s)"
            );
        }
        
        realisatorDAO.delete(realisator);
    }
}
