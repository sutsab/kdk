package com.leadinweb.bazakotow.application;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.leadinweb.bazakotow.domain.Cat;

@Repository
public class CatDAO {
	List<Cat> cats = new ArrayList<Cat>();
	
	public void addCat(Cat cat){
		cats.add(cat);
		System.out.println("Dodano kota do kolekcji");
	}
	
	public Cat getCat(Integer id){
		return cats.get(id);
	}
	
	public List<Cat> getCats(){
		return cats;
	}
}
