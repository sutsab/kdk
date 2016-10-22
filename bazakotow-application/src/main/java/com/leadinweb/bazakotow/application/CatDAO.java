package com.leadinweb.bazakotow.application;

import java.util.ArrayList;
import java.util.List;

import com.leadinweb.bazakotow.domain.Cat;

public class CatDAO {
	List<Cat> cats = new ArrayList<Cat>();
	
	public void addCat(Cat cat){
		cats.add(cat);
		System.out.println("Dodano kota do kolekcji");
	}
	
	public List<Cat> getCats(){
		return cats;
	}
}
