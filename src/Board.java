
public class Board {
	private Cell[] cells;
	public final int LAST_CELL;
	
	
	public Board()
	{
		LAST_CELL = 63;
	}
	
	/**
	 * Swap the location of two players
	 * @param p1
	 * @param p2
	 */
	public void swapPlayer(Player p1,Player p2)
	{
		Cell temporaryCell;
		temporaryCell = p1.getCell();
		p1.setCell(p2.getCell());
		p2.setCell(temporaryCell);
	}
	
	public Cell getCell(int indexCell)
	{
		return cells[indexCell];
	}
	
	public normalize()
	{
		
	}
	
	

}
