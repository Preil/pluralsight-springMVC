package com.pluralsight.repository;

import com.pluralsight.model.Goal;
import com.pluralsight.model.GoalReport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
    public List loadAllGoals() {

        Query query = em.createQuery("select g from Goal g");
        query.getResultList();
        return query.getResultList();
    }

    @Override
    public List<GoalReport> findAllGoalReports() {
        Query query = em.createQuery("select new com.pluralsight.model.GoalReport(g.minutes, e.minutes, e.activity)"+
                " from Goal g, Exercise e where g.goalId = e.goal.goalId");

        return query.getResultList();
    }
}
