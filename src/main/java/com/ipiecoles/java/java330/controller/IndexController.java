package com.ipiecoles.java.java330.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class IndexController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String index() {
//        return "index";
//    }


}
