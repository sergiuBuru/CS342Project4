import java.io.Serializable;
import java.util.ArrayList;


public class GameInfo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public ArrayList<String> countries = new ArrayList<String>();
	public ArrayList<String> superheroes = new ArrayList<String>();
	public ArrayList<String> presidents = new ArrayList<String>();
	
	public int id;
	public int points;
	public int numGuesses;
	public String guessLetter;
	public boolean inGame;
	public boolean foundWord;
	public String word; // word that is attempting to be guessed
	public char wordTest[]; // word that should be displayed if guessed 1 by 1
							// i.e if word is cat, guess is c should show -> c _ _
	
	
	public GameInfo() {
		this.points = 0;
		this.inGame = true;
		this.word = "";
		this.numGuesses = 0;
		
		countries.add("Egypt");
		countries.add("Nigeria");
		countries.add("Ethiopia");
		countries.add("Gambia");
		countries.add("Liberia");
	}
	
	public void setPoints(int points) {
		this.points = points;
	}
	
	public int getPoints() {
		return this.points;
	}
	
	public void setNumGuess(int num) {
		this.points = num;
	}
	
	public int getNumGuesses() {
		return this.numGuesses;
	}
	
	public void setWord(String word) { // in server code, should have the randomizer
		this.word = word;
		
		wordTest = new char[word.length()];
		
		for(int i = 0; i < word.length(); i++) {
			wordTest[i] = '_';
		} 
	}
	
	public void setGuess(String letter) {
		this.guessLetter = letter;
	}
	
	public String getGuess() {
		return this.guessLetter;
	}
	
	public char[] getWordTest() {
		return this.wordTest;
	}
	
	public void checkGuess(String guessLetter) {
		
		if(guessLetter.length() == 1) { // Guessing 1 character of the word
			for(int i = 0; i < word.length(); i++) {
				if(guessLetter.charAt(0) == word.charAt(i)) { // correctly guessed a letter
					
					wordTest[i] = word.charAt(i);
				}
			}
		}
		
		else if(guessLetter == word) { // guessed whole word
			this.setGuess(word);
			this.setPoints(++points);
			this.foundWord = true;
			
		}
		
		else { // guessed incorrectly
			this.setNumGuess(++numGuesses);
		}
		
		
	}
}
