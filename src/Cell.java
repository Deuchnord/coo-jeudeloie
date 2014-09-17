
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
	
	/**
	 * Returns the cell that the player really reached by a player when he arrives on this cell
	 * @param diceThrow the result of the dice when the player reaches this cell
	 * @return the index of the cell really reached by the player
	 */
	public int handleMove(int diceThrow);
	
	/**
	 * Indicates if a player is already on the cell
	 * @return true if the cell is already occupied
	 */
	public boolean isBusy();
	
	/**
	 * Returns the player currently on the cell (<code>null</code> if there are no players)
	 * @return the player currently on the cell
	 */
	public Player getPlayer();
	 
	/**
	 * Remembers <code>player</code> to be on this cell.
	 * @param player the player who reached the cell.
	 */
	public void welcome(Player player);
	
}
