package com.pluralsight.repository;

import com.pluralsight.model.Goal;
import com.pluralsight.model.GoalReport;

import java.util.List;

/**
 * Ilya 13.07.2017.
 */
public interface GoalRepository {

    Goal save(Goal goal);

    List loadAllGoals();

    List<GoalReport> findAllGoalReports();
}
