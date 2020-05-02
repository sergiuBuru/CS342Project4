import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;


public class GameInfo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public ArrayList<String> countries = new ArrayList<String>();
	public ArrayList<String> princesses = new ArrayList<String>();
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
	
	
	public GameInfo() throws FileNotFoundException {
		this.points = 0;
		this.inGame = true;
		this.word = "";
		this.numGuesses = 0;
		
		//Read the words from the text files and input them in the array lists
		inputWords();
		Collections.shuffle(countries);
		Collections.shuffle(princesses);
		Collections.shuffle(presidents);
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
	
	private void inputWords() throws FileNotFoundException {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("src/main/resources/Categories/AfricanCountries.txt"));
			String word = reader.readLine();
			while(word != null) {
				countries.add(word);
				word = reader.readLine();
			}
			reader = new BufferedReader(new FileReader("src/main/resources/Categories/DisneyPrincesses.txt"));
			word = reader.readLine();
			while(word != null) {
				this.princesses.add(word);
				word = reader.readLine();
			}
			reader = new BufferedReader(new FileReader("src/main/resources/Categories/USPresidents.txt"));
			word = reader.readLine();
			while(word != null) {
				this.presidents.add(word);
				word = reader.readLine();
			}
			reader.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	
	}
	
	
	
	
	
	
	
	
}
