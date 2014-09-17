
public class Game {
	private Board usingBoard;
	
	public Game()
	{
		this.usingBoard=new Board();
	}
	
	public void play()
	{
		
	}
	
	public boolean isFinished()
	{
		boolean gameSet;
		if(this.usingBoard.getCell(63).getPlayer()==null)
		{
			gameSet=false;
		}
		else
		{
			gameSet=true;
		}
		return gameSet;
	}
	

}
