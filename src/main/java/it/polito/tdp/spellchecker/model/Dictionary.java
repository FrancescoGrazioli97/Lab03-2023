package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dictionary {
	
	List<String> listWord = new ArrayList<String>();
	
	
	
	
	public void loadDictionary(String language) {
		
		
		if(language.equals("English")) {
			
		
		try { 
			 FileReader fr = new FileReader("src/main/resources/English.txt"); 
			BufferedReader br = new BufferedReader(fr); 
			 String word; 
			 while ((word = br.readLine()) != null) { 
			// Aggiungere parola alla struttura dati 
				 listWord.add(word);
				 
			 } 
			br.close(); 
			 
			 } catch (IOException e){ 
			 System.out.println("Errore nella lettura del file"); 
			} 
		
		}
		
		
		
		if(language.equals("Italian")) {
			
		try { 
			 FileReader fr = new FileReader("src/main/resources/Italian.txt"); 
			BufferedReader br = new BufferedReader(fr); 
			 String word; 
			 while ((word = br.readLine()) != null) { 
			// Aggiungere parola alla struttura dati 
				 listWord.add(word);
				 
			 } 
			br.close(); 
			 
			 } catch (IOException e){ 
			 System.out.println("Errore nella lettura del file"); 
			} 
		
		}
		
		
		
	}
	
	public List<RichWord> spellCheckText(List<String> inputTextList) {
		
		
		List<RichWord> listRichWord = new ArrayList<RichWord>();
		
		for (String s : inputTextList) {
			
			
			RichWord rich = new RichWord(s,false);
			
			if(listWord.contains(s.toLowerCase())) {
				
				
				rich.setCorrect(true);
				
			} else {
				
				
				rich.setCorrect(false);
				
			}
			
			listRichWord.add(rich);
			
			
			
		}
		
		return listRichWord;
		

		
		
	}
	

}
