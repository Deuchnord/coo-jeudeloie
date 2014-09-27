import static org.junit.Assert.*;

import org.junit.Test;


public class PlayerTest {

	@Test
	public void testGetName() {
		Player p = new Player("Michel Polnareff");
		assertEquals("Michel Polnareff", p.getName());
	}

}
