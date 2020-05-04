import java.io.BufferedReader;
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
	public int numGuesses; // per category
	public int numLosses; // if 3 losses of a category
	public String guessLetter;
	public String category;
	public boolean inGame;
	public boolean foundWord;
	public boolean foundLetter;
	public String word; // word that is attempting to be guessed
	public char wordTest[]; // word that should be displayed if guessed 1 by 1
							// i.e if word is cat, guess is c should show -> c _ _
	
	
	public GameInfo() throws FileNotFoundException {
		this.points = 0;
		this.inGame = true;
		this.word = new String();
		this.guessLetter = new String();
		this.category = new String();
		this.numGuesses = 6; // Will be incrementing to 6
		this.numLosses = 3;
		//Get the words
		inputWords();
		//Shuffle the arrays
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
	
	public void setCategory(String category) {
		this.category = category;
		selectWord();
	}
	
	public String getCategory() {
		return this.category;
	}

	public void selectWord() { 
		
		if(this.getCategory().equals("countries")) {
			this.setWord(countries.get(0));
			countries.remove(0);
		}
		else if(this.getCategory().equals("princesses")) {
			this.setWord(princesses.get(0));
			princesses.remove(0);
		}
		else if(this.getCategory().equals("presidents")){
			this.setWord(presidents.get(0));
			presidents.remove(0);
		}
	}
	
	public void setNumGuess(int num) {
		this.points = num;
	}
	
	public int getNumGuesses() {
		return this.numGuesses;
	}
	
	public void setNumLosses(int num) {
		this.numLosses = num;
	}
	
	public int getNumLosses() {
		return this.numLosses;
	}
	
	public void setWord(String word) { 
		this.word = word;
		
		wordTest = new char[word.length()];
		
		for(int i = 0; i < word.length(); i++) {
			wordTest[i] = '_';
		} 
	}
	
	public String getWord() {
		return this.word;
	}
	
	public void setGuess(String letter) {
		this.guessLetter = letter;
		System.out.println("in set guess: guess is" + letter);
	}
	
	public String getGuess() {
		return this.guessLetter;
		
	}
	
	public char[] getWordTest() {
		return this.wordTest;
	}
	
	public void checkGuess() {
		
		this.foundLetter = false;
		System.out.println("word is " + word);
		System.out.println("guessletter " + guessLetter);
		for(int i = 0; i < word.length(); i++) {
				
			if(guessLetter.charAt(0) == word.charAt(i)) { // correctly guessed a letter
					
					wordTest[i] = word.charAt(i);
					this.foundLetter = true;
			}
					
		}
		// Letter was not in the word
		if(!foundLetter) {
			this.setNumGuess(--numGuesses);
		}
			
		// Checking to see if the word is fully guessed
		for(int i = 0; i < word.length(); i++) {
			if(wordTest[i] != '_') 
				this.foundWord = true;
			
			else {
				this.foundWord = false;
				break;
			}
		}
		
		// Increment points once whole word is found
		if(foundWord) {
			this.setPoints(++points);
		}
		
		if(numGuesses == 0) { // If incorrectly guessed 6 times, increment a loss for that category
			this.setNumLosses(--numLosses);		}
			
	}
	
	
	//Input the words from text files
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
