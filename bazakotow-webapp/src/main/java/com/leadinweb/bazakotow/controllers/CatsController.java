package com.leadinweb.bazakotow.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.leadinweb.bazakotow.application.CatDAO;

@Controller
public class CatsController {
	
	@Autowired
    private CatDAO kotDao;
	
	@RequestMapping("/")
	public String main(){
		return "main";
	}
	
    @RequestMapping("/model")
    public String modelExample(Model model) {
        model.addAttribute("message", "To jest jakaś super informacja");
        return "main";
    }	
	
}