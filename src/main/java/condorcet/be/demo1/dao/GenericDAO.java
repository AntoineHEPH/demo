package condorcet.be.demo1.dao;

import java.util.List;

public interface GenericDAO<T, ID> {
    // T Représente l'entit" -ex : Film-
    // ID -> représente le type de clé primaire -ex: Long-
    void create(T entity);
    void update(T entity);
    void delete(T entity);

    T findById(ID id);
    List<T> findAll();
}
