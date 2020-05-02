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
		//assertEquals(, game.getWordTest(), "only should show two i characters");
	}
	
	@Test
	void testGuessWholeWord() {
		game.setWord("Thor");
		game.checkGuess("Thor");
		assertEquals(1, game.getPoints(), "Guessed whole word, increment points");
	}

}
