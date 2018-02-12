package com.ipiecoles.java.java330.controller;

import com.ipiecoles.java.java330.model.Commercial;
import com.ipiecoles.java.java330.model.Employe;
import com.ipiecoles.java.java330.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;

@Controller
@RequestMapping(value = "/employes")
public class EmployesController {

    @Autowired
    private EmployeService employeService;

    @RequestMapping(value = "/new/commercial", method = RequestMethod.GET)
    public String createCommercial(Map<String, Object> model){
        model.put("employe", new Commercial());
        return "employes/detail";
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.GET)
    public String detail(@PathVariable(value = "id") Long pId, Map<String, Employe> model) {
        Employe employe = employeService.findById(pId);
        model.put("employe", employe);
        return "employes/detail";
    }

    @GetMapping(value = "", params = "matricule")
    public RedirectView findByMatricule(@RequestParam(name = "matricule") String matricule) {
        Employe employe = this.employeService.findMyMatricule(matricule);
        return new RedirectView("/employes/" + employe.getId());
    }

    @RequestMapping(value="/{id}/delete", method = RequestMethod.GET)
    public RedirectView deleteEmploye (@PathVariable(value="id") Long id, RedirectAttributes attributes){
        employeService.deleteEmploye(id);
        attributes.addAttribute("page",0);
        attributes.addAttribute("size",10);
        attributes.addAttribute("sortProperty","matricule");
        attributes.addAttribute("sortDirection", "ASC");
        attributes.addAttribute("success", "Suppression effectuées !");
        return new RedirectView("/employes");
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String findAll(@RequestParam("page") Integer page,
                          @RequestParam("size") Integer size,
                          @RequestParam("sortDirection") String sortDirection,
                          @RequestParam("sortProperty") String sortProperty,
                          Map<String, Object> model){
        Page<Employe> pageEmploye = employeService.findAllEmployes(page, size, sortProperty, sortDirection);
        model.put("model",pageEmploye);
        model.put("size", size);
        model.put("sortDirection", sortDirection);
        model.put("sortProperty", sortProperty);
        model.put("page", page);
        model.put("pageAffichage", page + 1);
        model.put("nextPage", page + 1);
        model.put("previousPage", page - 1);
        model.put("start", (page) * size + 1);
        int end = (page + 1) * size;
        model.put("end", end > pageEmploye.getTotalElements() ? pageEmploye.getTotalElements() : end);
        return "employes/liste";
    }

}
