package com.pluralsight.model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Ilya 22.06.2017.
 */
@Entity
@Table(name = "goals")
//@NamedQueries({
//        @NamedQuery(name = Goal.FIND_GOAL_REPORTS,
//        query = "select new com.pluralsight.model.GoalReport(g.minutes, e.minutes, e.activity) " +
//                "from Goal g, Exercise e where g.goalId = e.goal.goalId"),
//        @NamedQuery(name = Goal.FIND_ALL_GOALS,
//        query = "select g from Goal g")
//})
public class Goal {

    public static final String FIND_GOAL_REPORTS = "findGoalReports";
    public static final String FIND_ALL_GOALS = "findAllGoals";

    @Id
    @GeneratedValue
    @Column(name="GOAL_ID")
    private Long goalId;

    @Range(min=1, max=120)
    @Column(name = "MINUTES")
    private int minutes;

    @OneToMany(mappedBy = "goal", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Exercise> exercises = new ArrayList<>();

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public Long getGoalId() {
        return goalId;
    }

    public void setGoalId(Long goalId) {
        this.goalId = goalId;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }
}
