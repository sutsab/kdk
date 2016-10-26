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
    private CatDAO catDAO;
	
	@RequestMapping("/")
	public String index(){
		return "index";
	}
	
    @RequestMapping("/list")
    public String listCats(Model model) {
        model.addAttribute("cats", catDAO.getCats());
        return "listCats";
    }
    
    @RequestMapping("/cat/{id}")
    public String catDetails(@PathVariable("id") Integer id, Model model) {
    	model.addAttribute("cat", catDAO.getCat(id));
        return "catDetails";
    } 
    
    @RequestMapping("/add")
    public String addCat() {
     return "addCat";
    }    
	
}