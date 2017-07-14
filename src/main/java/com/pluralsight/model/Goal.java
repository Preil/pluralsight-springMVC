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
public class Goal {

    @Id
    @GeneratedValue
    @Column(name="GOAL_ID")
    private Long goalId;

    @Range(min=1, max=120)
    @Column(name = "MINUTES")
    private int minutes;

    @OneToMany(mappedBy = "goal", cascade = CascadeType.ALL)
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
}
