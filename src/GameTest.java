import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;


public class GameTest {

	@Test
	public void testConstructorAndIsFinished() throws IOException {
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(new Player("p1"));
		players.add(new Player("p2"));
		players.add(new Player("p3"));
		
		Game g = new Game(players);
		// Before launching the game
		assertFalse(g.isFinished());
	}
	
	
	@Test
	public void testNextPlayer() throws IOException {
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(new Player("p1"));
		players.add(new Player("p2"));
		players.add(new Player("p3"));
		
		Game g = new Game(players);
		assertEquals(players.get(0), g.nextPlayer());
	}
	
	@Test
	public void testThrowDie() throws IOException {
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(new Player("p1"));
		players.add(new Player("p2"));
		players.add(new Player("p3"));
		
		Game g = new Game(players);
		
		int diceResult = g.throwDie();
		
		assertTrue(diceResult >= 2 && diceResult <= 12);
	}

}
