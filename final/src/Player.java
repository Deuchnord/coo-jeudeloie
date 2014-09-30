
public class Player {
	private String name;
	private Cell playerSCell;
	
	/**
	 * Player class' Constructor.
	 * @param playerName
	 */
	public Player(String playerName)
	{
		this.name=playerName;
		this.playerSCell=new NormalCell(0);
	}
	
	/**
	 * Return the cell that the player occupates.
	 * @return
	 */
	public Cell getCell()
	{
		return this.playerSCell;
	}
	
	/**
	 * Change the cell that the player occupates.
	 * @param newCell
	 */
	public void setCell(Cell newCell)
	{
		this.playerSCell = newCell;
	}
	
	/**
	 * 
	 * @return the player's name
	 */
	public String getName() {
		
		return this.name;
		
	}

}
