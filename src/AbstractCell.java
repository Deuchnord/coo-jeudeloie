
public abstract class AbstractCell implements Cell {

	private int index;
	private Player p;
	
	public AbstractCell(int index) {
		
		this.index = index;
		
	}
	
	public int getIndex() {
		
		return this.index;
		
	}
	
	public boolean canBeLeftNow() {
		
		
		
	}
	
}
