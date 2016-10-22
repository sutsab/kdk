package com.leadinweb.bazakotow.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.leadinweb.bazakotow.domain.Cat;

public class Interface {

	static Scanner sc = new Scanner(System.in);
	static CatDAO catDAO = new CatDAO();
	
	public static void main(String[] args){
		String userChooice;
    	do {
    		promptUser("");
    		promptUser("Wybierz, co chcesz zrobić, a następnie zatwierdź enterem:");
    		promptUser("[1] Dodaj nowego kota");
    		promptUser("[2] Pokaż wszystkie koty");
    		promptUser("[x] Zakończ");
    		userChooice = getUserInput();
	    	if (userChooice.equals("1")) {
	    		addCat();
	    	} else if (userChooice.equals("2")) {
	    		showCats();
	    	}
    	} while (!userChooice.equalsIgnoreCase("x"));		
	}
	
	public static void addCat(){
		promptUser("");
		promptUser("#########################################################");
		promptUser("######                 DODAJ  KOTA                 ######");
		promptUser("#########################################################");
		promptUser("");
		
		Cat cat = new Cat();
		
		promptUser("Podaj imię kota");
		cat.setName(getUserInput());

        Pattern datePattern = Pattern.compile("[0-3]?[0-9]-[0-1]?[0-9]-[0-9]{4}");
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String givenDate;
		do{
			promptUser("Podaj datę urodzenia kota w formacie DD-MM-RRRR");
			givenDate = getUserInput();
			if(datePattern.matcher(givenDate).matches()){
				try{
					cat.setBirthDate(sdf.parse(givenDate));
				} catch(ParseException pe){
					promptUser("Coś jest nie tak z formatem daty! Przykładowa data: 01-01-2001");
				}				
			}
		} while (cat.getBirthDate() == null);	
		
		
		do {
            promptUser("Podaj wagę kota: ");
            try {
                cat.setWeight(Float.valueOf(getUserInput()));
            } catch (NumberFormatException nfe) {
            	promptUser("Coś jest nie tak z formatem wagi! Przykładowa waga: 10.0");
            }
        } while (cat.getWeight() == null);

        promptUser("Podaj kto jest opiekunem kota: ");
        cat.setOwnersName(getUserInput());
        
        catDAO.addCat(cat);

        promptUser("Dziękuję, teraz wiem o kocie naprawdę wszystko!");			
	}
	
	public static void showCats(){
		promptUser("");
		promptUser("#########################################################");
		promptUser("######                 DODAJ  KOTA                 ######");
		promptUser("#########################################################");
		promptUser("");
		
		Cat cat;
		
		for(int i = 0; i < catDAO.getCats().size(); i++){
			cat = catDAO.getCats().get(i);
			promptUser(i + ": " + cat.getName());
		}
		
		Pattern numberPattern = Pattern.compile("[0-9]+");
		String givenNumber;
		
		do{
			promptUser("Którego kota chcesz poznać bliżej?");
			givenNumber = getUserInput();
		} while (!numberPattern.matcher(givenNumber).matches());
		
		Integer catNumber = Integer.parseInt(givenNumber);
		if(catDAO.getCats().size()>catNumber){
			Cat choosenCat = catDAO.getCats().get(catNumber);
			promptUser(choosenCat.toString());
		} else {
			promptUser("Niestety nie znanazłem kota o podanym numerze, spróbuj ponownie");
		}
		
		
	}
	
	public static String getUserInput(){
		return sc.nextLine().trim();
	}
	
	public static void promptUser(String message){
		System.out.println(message);
	}
	
}
