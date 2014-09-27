import static org.junit.Assert.*;

import org.junit.Test;


public class WaitCellTest {

	@Test
	public void testCanBeLeftNow() {
		WaitCell wc1=new WaitCell(3,3);
		assertFalse(wc1.canBeLeftNow());
		WaitCell wc2=new WaitCell(1,0);
		assertTrue(wc2.canBeLeftNow());
	}
	
	@Test
	public void testHandleMove()
	{
		WaitCell wCHM=new WaitCell(1,1);
		assertEquals(1,wCHM.handleMove(1));
	}
	
	@Test
	public void testWelcomePlayer()
	{
		WaitCell wTW=new WaitCell(1,3);
		Player playerTw=new Player("CrashTest");
		wTW.welcome(playerTw);
		assertEquals(playerTw,wTW.getPlayer());
		assertEquals(0,wTW.getWaitingCounter());
		wTW.canBeLeftNow();
		assertEquals(1,wTW.getWaitingCounter());
		wTW.welcome(playerTw);
		assertEquals(0,wTW.getWaitingCounter());
		
		
	}

}
