package com.ipiecoles.java.java330.controller;

import com.ipiecoles.java.java330.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.Map;

@Controller
public class IndexController {

    @Autowired
    private EmployeService employeService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Map<String,Object> model) {
        //Nb employé
        Long nbEmployes = employeService.countAllEmploye();
        model.put("nbEmployes",nbEmployes);

        return "index";
    }

}
