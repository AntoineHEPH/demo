package condorcet.be.demo1.dao;

import condorcet.be.demo1.model.cinecondorcet.Realisator;

import java.util.List;

public interface RealisatorDAO extends GenericDAO<Realisator, Long> {
    //Rien de spécifique -> mais hérite des méthodes CRUD complètes !
}
