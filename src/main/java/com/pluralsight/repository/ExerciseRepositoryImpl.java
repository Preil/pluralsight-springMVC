package com.pluralsight.repository;

import com.pluralsight.model.Exercise;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Ilya 14.07.2017.
 */

@Repository("exerciseRepository")
public class ExerciseRepositoryImpl implements ExerciseRepository{

    @PersistenceContext
    private EntityManager em;

    @Override
    public Exercise save(Exercise exercise) {
        em.persist(exercise);
        em.flush();
        return exercise;
    }
}
