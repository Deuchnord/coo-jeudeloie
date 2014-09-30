
public class TrapCell extends AbstractCell {

	public TrapCell(int index) {
		
		super();
		
		this.index = index;
		
	}
	
	@Override
	public boolean canBeLeftNow() {
		
		return false;
		
	}
	
	@Override
	public boolean isRetaining() {
		
		return true;
		
	}
	
}
