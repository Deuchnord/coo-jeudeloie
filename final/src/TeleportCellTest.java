import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;


public class TeleportCellTest {

	@Test
	public void testHandleMove() throws IOException {
		Board b =new Board();
		assertEquals(12, b.getCell(6).handleMove(2));
		assertEquals(30, b.getCell(42).handleMove(2));
		assertEquals(1, b.getCell(58).handleMove(2));
		
	}

}
