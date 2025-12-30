package condorcet.be.demo1.dao.impl;


import condorcet.be.demo1.dao.FilmDAO;
import condorcet.be.demo1.model.cinecondorcet.Film;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;

@ApplicationScoped
public class FilmDAOImpl extends GenericDAOImpl<Film, Long> implements FilmDAO {

    @PersistenceContext(unitName = "cine-pu")
    private EntityManager em;

    // Constructeur sans arguments pour CDI
    public FilmDAOImpl() {
        super();
    }

    // Constructeur avec arguments pour les appels manuels
    public FilmDAOImpl(EntityManager em, Class<Film> entityClass) {
        super(em, entityClass);
        this.em = em;
    }

    @PostConstruct
    public void init() {
        this.em = em;
        this.entityClass = Film.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public List<Film> findByRealisatorId(Long id) {
        String jpql = "SELECT f FROM Film f WHERE f.realisator.id = :id";
        TypedQuery<Film> query = em.createQuery(jpql, Film.class);
        query.setParameter("id", id);
        return query.getResultList();
    }

    @Override
    public List<Film> searchByTitle(String filmTitle) {
        String jpql = "SELECT f FROM Film f WHERE LOWER(f.title) LIKE LOWER(:title)";
        TypedQuery<Film> query = em.createQuery(jpql, Film.class);
        query.setParameter("title", "%" + filmTitle + "%"); // filmTitle est envoyé en paramètre :title de ma query

        return query.getResultList();
    }
}
