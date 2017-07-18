package com.pluralsight.repository;

import com.pluralsight.model.Goal;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Ilya 13.07.2017.
 */
@Repository("goalRepository")
public class GoalRepositoryImpl implements GoalRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Goal save(Goal goal) {
        em.persist(goal);
        em.flush();
        return goal;
    }

    @Override
    public List<Goal> loadAllGoals() {
        List<Goal> goals = new ArrayList<>();
        Query query = em.createQuery("select g from Goal g");
        goals = query.getResultList();
        return goals;
    }
}
