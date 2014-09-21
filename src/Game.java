import java.util.Random;

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
	
	/**
	 * 
	 * @return the sum of 2D6 (two dices of six faces) with two numbers generated randomly.
	 */
	public int throwDie()
	{
		Random randomGenerator1=new Random();
		Random randomGenerator2 = new Random();
		int firstDie =randomGenerator1.nextInt(6)+1;
		int secondDie=randomGenerator2.nextInt(6)+1;
		return firstDie+secondDie;
		
		
	}
	

}
