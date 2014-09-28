
public class TeleportCell extends AbstractCell {

	private int dest;
	
	public TeleportCell(int index, int dest) {
		
		super();
		
		this.index = index;
		this.dest = dest;
		
	}
	
	@Override
	public int handleMove(int d) {
		
		return this.dest;
		
	}
	
}
