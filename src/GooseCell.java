
public class GooseCell extends AbstractCell {

	public GooseCell(int index) {
		
		super();
		
		this.index = index;
		
	}
	
	@Override
	public int handleMove(int d) {

		 return this.index + d;
		
	}
	
}
