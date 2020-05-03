import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GuessTest {

	GameInfo game;
	
	@BeforeEach
	void init() {
		game = new GameInfo();
	}
	
	@Test
	void testOneGuess() {
		game.setWord("Nigeria");
		game.checkGuess("i");
		assertEquals(6, game.getNumGuesses(), "Should have 6 since the guess was correct");
	}
	
	@Test
	void testGuessWholeWord() {
		game.setWord("Thor");
		game.checkGuess("T");
		game.checkGuess("h");
		game.checkGuess("o");
		game.checkGuess("r");

		assertEquals(1, game.getPoints(), "Guessed whole word, increment points");
	}
	
	@Test
	void multipleWrongGuesses() {
		game.setWord("Thor");
		
		game.checkGuess("p");
		game.checkGuess("p");
		game.checkGuess("p");
		
		assertEquals(3, game.getNumGuesses(), "Since there are 3 inccorrect guessed, number of guesses remaining should be 3");

	}
	
	@Test
	void testNumLoss() {
		game.setWord("Thor");
		game.checkGuess("p");
		game.checkGuess("p");
		game.checkGuess("p");
		game.checkGuess("p");
		game.checkGuess("p");
		game.checkGuess("p");
		
		assertEquals(2, game.getNumLosses(), "6 incorrect guesses should lead to a loss");
	}
	
	@Test
	void testMultipleInputs() {
		game.setWord("Thor");
		game.checkGuess("p");
		game.checkGuess("T");
		assertEquals(5, game.getNumGuesses(), "1 incorrect guess will decrement the number of guesses left");

	}
	
	@Test
	void testMultipleInputs2() {
		game.setWord("Hulk");
		game.checkGuess("p");
		game.checkGuess("p");
		game.checkGuess("p");

		game.checkGuess("H");
		game.checkGuess("u");
		game.checkGuess("l");
		game.checkGuess("k");

		assertEquals(3, game.getNumGuesses(), "3 incorrect guesses will decrement the number of guesses left");

	}
	
	@Test
	void guessTwoWordsCorrect() {
		game.setWord("H");
		game.checkGuess("H");
		game.setWord("T");
		game.checkGuess("T");
		
		assertEquals(2, game.getPoints(), "2 words were guessed correctly");
	}
	
	@Test
	void testWords() {
		game.setWord("Obama");
		game.checkGuess("O");
		game.checkGuess("b");
		game.checkGuess("a");
		game.checkGuess("m");
		game.checkGuess("a");

		assertEquals(6, game.getNumGuesses(), "All correct guesses");

	}
	
	@Test
	void testSetWord() {
		game.setWord("IronMan");
		assertEquals("IronMan", game.getWord(), "Word should be IronMan");
	}
	
	@Test
	void testWordTest() {
		game.setWord("Thor");
		game.checkGuess("h");
		char[] expectedOutput = {'_','h','_','_'};
		assertArrayEquals(expectedOutput, game.getWordTest(), "Only the character 'h' should be shown");
	
	}

}
