package condorcet.be.demo1.dao.impl;

import condorcet.be.demo1.dao.RealisatorDAO;
import condorcet.be.demo1.model.cinecondorcet.Realisator;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@ApplicationScoped
public class RealisatorDAOImpl extends GenericDAOImpl<Realisator, Long> implements RealisatorDAO {

    @PersistenceContext(unitName = "cine-pu")
    private EntityManager em;

    // Constructeur sans arguments pour CDI
    public RealisatorDAOImpl() {
        super();
    }

    // Constructeur avec arguments pour les appels manuels
    public RealisatorDAOImpl(EntityManager em, Class<Realisator> entityClass) {
        super(em, entityClass);
        this.em = em;
    }

    @PostConstruct
    public void init() {
        this.em = em;
        this.entityClass = Realisator.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
