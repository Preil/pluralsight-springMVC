package com.pluralsight.controller;

import com.pluralsight.model.Activity;
import com.pluralsight.model.Exercise;
import com.pluralsight.model.Goal;
import com.pluralsight.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Ilya 20.06.2017.
 */

@Controller
public class AddMinutesController {

    @Autowired
    private ExerciseService exerciseService;

    @RequestMapping(value = "/addMinutes",  method = RequestMethod.GET)
    public String getMinutes(@ModelAttribute ("exercise") Exercise exercise) {

        return "addMinutes";
    }

    @RequestMapping(value = "/addMinutes", method = RequestMethod.POST)
    public String addMinutes(@Valid @ModelAttribute("exercise") Exercise exercise, HttpSession session, BindingResult result) {
        System.out.println("Exercise: " + exercise.getMinutes()+" exercise type: "+exercise.getActivity());
        if (result.hasErrors()){
            return "addMinutes";
        } else {
            Goal goal = (Goal) session.getAttribute("goal");
            exercise.setGoal(goal);
            exerciseService.save(exercise);
        }

        return "addMinutes";
    }

    @RequestMapping (value = "/activities", method = RequestMethod.GET)
    public @ResponseBody List<Activity> findAllActivities(){
        List<Activity> activities = new ArrayList<>();
        Activity run = new Activity();
        run.setDesc("Run");
        activities.add(run);

        Activity bike = new Activity();
        bike.setDesc("Bike");
        activities.add(bike);

        Activity swim = new Activity();
        swim.setDesc("Swim");
        activities.add(swim);

        return activities;
    }

//    @RequestMapping(value="/addMoreMinutes")
//    public String addMoreMinutes(@ModelAttribute("exercise")Exercise exercise){
//        System.out.println("Exercising: "+exercise.getMinutes());
//        return "addMinutes";
//    }

}
