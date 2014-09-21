
public class GooseCell extends AbstractCell {

	public GooseCell(int index) {
		
		super();
		
		this.index = index;
		
	}
	
	@Override
	public int handleMove(int d) {
		// TODO: remove this comment
		 return this.index + diceThrow;
		
	}
	
}
