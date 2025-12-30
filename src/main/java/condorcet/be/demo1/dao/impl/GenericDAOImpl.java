package condorcet.be.demo1.dao.impl;

import condorcet.be.demo1.dao.GenericDAO;
import condorcet.be.demo1.model.cinecondorcet.Film;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

import java.util.List;

public class GenericDAOImpl<T, ID> implements GenericDAO<T, ID> {
    protected EntityManager em;
    protected Class<T> entityClass;

    // Constructeur sans arguments pour CDI
    public GenericDAOImpl() {
    }

    // Constructeur pour injecter l'EntityManager (pour les appels manuels)
    public GenericDAOImpl(EntityManager em, Class<T> entityClass) {
        this.em = em;
        this.entityClass = entityClass;
    }

    // Méthode pour accéder à l'EntityManager de manière polymorphe
    protected EntityManager getEntityManager() {
        return em;
    }

    @Transactional
    @Override
    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    @Transactional
    @Override
    public void update(T entity) {
        getEntityManager().merge(entity);
    }

    @Transactional
    @Override
    public void delete(T entity) {
        getEntityManager().remove(entity);
    }

    @Override
    public T findById(ID id) {
        String jpql = "SELECT e FROM " + entityClass.getSimpleName() + " e WHERE e.id = :id";
        TypedQuery<T> query = getEntityManager().createQuery(jpql, entityClass);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public List<T> findAll() {
        String jpql = "SELECT x FROM "+entityClass.getSimpleName()+" x";
        TypedQuery<T> query = getEntityManager().createQuery(jpql, entityClass);
        return query.getResultList();
    }
}
