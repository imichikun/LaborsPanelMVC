package com.spring.mvc.controller;

import com.spring.mvc.entity.Labor;
import com.spring.mvc.service.ServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MVC_Controller {
    @Autowired
    private ServiceDao serviceDao;

    @GetMapping("/")
    public String getAllLabors(Model model){
        List<Labor> labors = serviceDao.getAllLabors();
        model.addAttribute("labors", labors);           // передаём полученный список в model(в самую первую View jsp)

        return "1all-labors";
    }

    @RequestMapping("/addLabor")
    public String addLabor(Model model){
        Labor labor = new Labor();
        model.addAttribute("labor", labor);

        return "2add-labor";
    }

    @RequestMapping("/saveLabor")
    public String saveUpdateLabor(@Valid @ModelAttribute("labor") Labor labor, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "2add-labor";

        serviceDao.saveLabor(labor);
        return "redirect:/";
    }

    @RequestMapping("/updateInfo")
    public String updateInfo(@Valid @RequestParam("var4ButtonUpdateParam") int id, Model model){

        Labor labor = serviceDao.getLaborById(id);
        model.addAttribute("labor", labor);

        return "2add-labor";
    }

    @RequestMapping("/deleteLabor")
    public String deleteLabor(@RequestParam("var4ButtonDeleteParam") int id){
        serviceDao.deleteLabor(id);

        return "redirect:/";
    }
}