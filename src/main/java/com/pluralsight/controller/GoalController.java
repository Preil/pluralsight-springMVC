package com.pluralsight.controller;

import com.pluralsight.model.Goal;
import com.pluralsight.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;

/**
 * Ilya 22.06.2017.
 */

@Controller
@SessionAttributes("goal")
public class GoalController {

    @Autowired
    private GoalService goalService;

    @RequestMapping(value = "addGoal", method = RequestMethod.GET)
    public String addGoal(Model model){
        Goal goal = new Goal();
        goal.setMinutes(10);
        model.addAttribute("goal", goal);
        return "addGoal";
    }

    @RequestMapping(value = "addGoal", method = RequestMethod.POST)
    public String updateGoal(@Valid @ModelAttribute("goal") Goal goal, BindingResult result){
        System.out.println("result has errors: "+result.hasErrors());
        if (result.hasErrors()){
            return "addGoal";
        }else {
            goalService.save(goal);
        }
        System.out.println("Goal set: "+goal.getMinutes());
        return "redirect:index.jsp";
    }
}
