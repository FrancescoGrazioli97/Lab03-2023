package it.polito.tdp.spellchecker.model;

import java.util.Objects;

public class RichWord {
	
	String parola;
	boolean isCorrect;
	
	
	
	public RichWord(String parola, boolean isCorrect) {
		super();
		this.parola = parola;
		this.isCorrect = isCorrect;
	}
	
	
	
	public String getParola() {
		return parola;
	}
	public void setParola(String parola) {
		this.parola = parola;
	}
	public boolean isCorrect() {
		return isCorrect;
	}
	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}



	@Override
	public int hashCode() {
		return Objects.hash(parola);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RichWord other = (RichWord) obj;
		return Objects.equals(parola, other.parola);
	}



	@Override
	public String toString() {
		return "RichWord [parola=" + parola + ", isCorrect=" + isCorrect + "]";
	}
	
	
	
	
	

}
