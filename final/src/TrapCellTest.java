import static org.junit.Assert.*;

import org.junit.Test;


public class TrapCellTest {

	@Test
	public void testCanBeLeftNow() {
		TrapCell tc = new TrapCell(31);
		assertFalse(tc.canBeLeftNow());
	}
	
	public void testIsRetaining() {
		TrapCell tc = new TrapCell(31);
		assertTrue(tc.isRetaining());
	}

}
