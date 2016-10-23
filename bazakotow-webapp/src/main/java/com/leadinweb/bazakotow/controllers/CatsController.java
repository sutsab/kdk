package com.leadinweb.bazakotow.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    
    @RequestMapping("/cat/{name}")
    public String catDetails(@PathVariable("name") String name) {
        return "main";
    } 
    
    @RequestMapping("/method")
    public String view(@RequestParam("a") String aData, @RequestParam(value = "b", required = false, defaultValue = "0") Integer bData) {
     return "main";
    }    
	
}