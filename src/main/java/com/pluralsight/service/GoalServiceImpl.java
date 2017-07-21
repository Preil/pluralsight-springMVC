package com.pluralsight.service;

import com.pluralsight.model.Goal;
import com.pluralsight.model.GoalReport;
import com.pluralsight.repository.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Ilya 13.07.2017.
 */
@Service("goalService")
public class GoalServiceImpl implements GoalService {

    @Qualifier("goalRepository")
    @Autowired
    private GoalRepository goalRepository;

    @Override
    @Transactional
    public Goal save(Goal goal) {
        return goalRepository.save(goal);
    }

    @Override
    public List<Goal> findAllGoals() {
        return goalRepository.findAll();
    }

    @Override
    public List<GoalReport> findAllGoalReports() {
        return goalRepository.findAllGoalReports();
    }
}
