package com.leadinweb.bazakotow.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.leadinweb.bazakotow.application.CatDAO;
import com.leadinweb.bazakotow.domain.Cat;
import com.leadinweb.bazakotow.dto.CatDTO;

@Controller
public class CatsController {
	
	@Autowired
    private CatDAO catDAO;
	
	@RequestMapping("/")
	public String index(){
		return "index";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String buildAddCatForm(@ModelAttribute("catDTO") @Valid CatDTO catDTO, BindingResult result){
		return "addCat";
	}
    
    @RequestMapping(value="/add", method=RequestMethod.POST)
    public String addCat(@ModelAttribute("catDTO") @Valid CatDTO catDTO, BindingResult result) {
    	if(!result.hasErrors()){
    		Cat cat = new Cat();
    		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
    		try{
    			cat.setBirthDate(sdf.parse(catDTO.getBirthDate()));
    		} catch (ParseException pe){
    			pe.printStackTrace();
    		}
    		cat.setName(catDTO.getName());
    		cat.setOwnersName(catDTO.getOwnersName());
    		cat.setWeight(catDTO.getWeight());
    		catDAO.addCat(cat);
   	     	return "redirect:/list";
    	} else {
    		return "addCat";
    	}
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
	
}