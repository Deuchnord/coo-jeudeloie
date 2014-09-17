
public interface Cell {
	
	/**
	 * Indicates if the player occupying this cell, can leave the cell or not
	 * @return true if the player can leave the cell, false if not
	 */	
	public boolean canBeLeftNow();
	
	/**
	 * Indicates if a cell holds a player until another player reaches the same cell
	 * @return true if the only way for a player to get out of this cell is for another player to replace him
	 */
	public boolean isRetaining();
	
	/**
	 * Indicates the position of this cell on the board
	 * @return the position of the cell
	 */
	public int getIndex();
	
	public int handleMove(int diceThrow);
	
}
