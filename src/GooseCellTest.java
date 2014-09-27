import static org.junit.Assert.*;

import org.junit.Test;


public class GooseCellTest {

	@Test
	public void test() {
		GooseCell gc = new GooseCell(9);
		int dice = 6;
		assertEquals(dice+9, gc.handleMove(dice));
	}

}
