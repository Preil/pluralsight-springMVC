package com.pluralsight.service;

import com.pluralsight.model.Goal;

import java.util.List;

/**
 * Ilya 13.07.2017.
 */
public interface GoalService {

    Goal save(Goal goal);

    List<Goal> findAllGoals();
}
