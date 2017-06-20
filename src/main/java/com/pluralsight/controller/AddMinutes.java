package com.pluralsight.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Ilya 20.06.2017.
 */

@Controller
public class AddMinutes {
    @RequestMapping(value="/addMinutes")
    public String addMinutes (){
        return "addMinutes";
    }
}
