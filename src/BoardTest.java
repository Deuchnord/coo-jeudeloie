import static org.junit.Assert.*;

import java.io.IOException;
import org.junit.Test;


public class BoardTest {

	@Test
	public void testBoard() {
		
		try {
			Board b = new Board();
		} catch (IOException e) {
			fail("IOException on creating b object: "+e.getMessage());
		}
	}
	
	@Test(expected=IOException.class)
	public void testBoardWithANotExistingFile() throws IOException {
		
		Board b = new Board("boards/file_that_doesnt_exist");
		
	}
	
	@Test(expected=IOException.class)
	public void testBoardWithAFileContainingASyntaxError() throws IOException {
		
		Board b = new Board("boards/file_with_an_error");
		
	}

	@Test
	public void testSwapPlayer() throws IOException {
		Board b = new Board();
		Player p1 = new Player("player1");
		Player p2 = new Player("player2");
		
		b.getCell(10).welcome(p1);
		p1.setCell(b.getCell(10));
		b.getCell(42).welcome(p2);
		p2.setCell(b.getCell(42));
		
		b.swapPlayer(p1, p2);
		assertEquals(p1, b.getCell(42).getPlayer());
		assertEquals(p2, b.getCell(10).getPlayer());
	}

	@Test
	public void testNormalize() throws IOException {
		Board b = new Board();
		assertEquals(61, b.normalize(65));
		assertEquals(54, b.normalize(54));
	}

}
