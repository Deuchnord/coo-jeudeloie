
public class WaitCell extends AbstractCell {

	private int	waitingTime,
				waitingCounter;
	
	public WaitCell(int index, int time) {
		
		super();
		
		this.index = index;
		this.waitingTime = time;
		this.waitingCounter = 0;
		
	}
	
	@Override
	public int handleMove(int d) {
		
		return this.index;
		
	}
	
	@Override
	public boolean canBeLeftNow() {
		
		boolean canLeave = false;
		
		if(waitingCounter == waitingTime)
			canLeave = true;
		
		waitingCounter++;
		
		return canLeave;
		
	}
	
	@Override
	public void welcome(Player p) {
		
		super.welcome(p);
		
		waitingCounter = 0;
		
	}
	
}
