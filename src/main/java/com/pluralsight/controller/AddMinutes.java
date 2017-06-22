package com.pluralsight.controller;

import com.pluralsight.model.Exercise;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Ilya 20.06.2017.
 */

@Controller
public class AddMinutes {
    @RequestMapping(value = "/addMinutes")
    public String addMinutes(@ModelAttribute("exercise") Exercise exercise) {
        System.out.println("Exercise: " + exercise.getMinutes());
        return "forward:addMoreMinutes.html";
    }

    @RequestMapping(value="/addMoreMinutes")
    public String addMoreMinutes(@ModelAttribute("exercise")Exercise exercise){
        System.out.println("Exercising: "+exercise.getMinutes());
        return "addMinutes";
    }
}
