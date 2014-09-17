
public class Board {
	private Cell[] cells;
	
	
	public Board()
	{
		
	}
	
	public Board(int[] trapCells, int[] gooseCell, int[] teleportCell, int[] WaitCell)
	{
		
	}
	
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
	
	

}
