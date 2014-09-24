import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Game {
	private Board usingBoard;
	private int noPlayer;
	private ArrayList<Player> listPlayers;
	
	public Game() throws IOException
	{
		this.usingBoard=new Board();
		this.noPlayer=0;
		this.listPlayers=new ArrayList<Player>();
	
	}
	
	/**
	 * function that plays the game.
	 */
	public void play()
	{
		int score;
		Player playerThisTurn=this.nextPlayer();
		if(playerThisTurn.getCell().canBeLeftNow())
		{
			score=this.throwDie();
			int index=usingBoard.normalize(playerThisTurn.getCell().getIndex()+score);
			Cell targetCell=usingBoard.getCell(index);
			index=usingBoard.normalize(targetCell.handleMove(score));
			targetCell=usingBoard.getCell(index);
			
			if(targetCell.isBusy())
			{
				usingBoard.swapPlayer(playerThisTurn, targetCell.getPlayer());
			}
			else
				targetCell.welcome(playerThisTurn);
				playerThisTurn.setCell(targetCell);
				targetCell.welcome(playerThisTurn);
			
		}
		
	}
	
	/**
	 * @return return if the game is finished or not.
	 */
	public boolean isFinished()
	{
		boolean gameSet;
		if(this.usingBoard.getCell(usingBoard.LAST_CELL).getPlayer()==null)
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
	
	/**
	 * @return the next player who will play.
	 */
	public Player nextPlayer()
	{
		Player nxtPlayer;
		nxtPlayer=listPlayers.get(noPlayer);
		if(noPlayer==listPlayers.size()-1)
		{
			noPlayer=0;
		}
		else
			noPlayer++;
		return nxtPlayer;
	}
	
	
	

}
