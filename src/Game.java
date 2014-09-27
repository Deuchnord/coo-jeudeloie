import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Game {
	private Board usingBoard;
	private int noPlayer;
	private ArrayList<Player> listPlayers;
	
	public Game(ArrayList<Player> playersList) throws IOException
	{
		this.usingBoard=new Board();
		this.noPlayer=0;
		this.listPlayers=playersList;
	}
	
	/**
	 * function that plays the game.
	 */
	public void play()
	{
		int score;
		Player playerThisTurn=null;
		
		for(Player p:this.listPlayers)
		{
			p.setCell(usingBoard.getCell(1));
		}
		
		while(this.isFinished())
		{
			playerThisTurn=this.nextPlayer();
			System.out.println("It's "+playerThisTurn.getName()+"'s turn now !");
			
			if(playerThisTurn.getCell().canBeLeftNow())
			{
				score=this.throwDie();
				System.out.println(playerThisTurn.getName() +" got a "+score);
				
				int index=usingBoard.normalize(playerThisTurn.getCell().getIndex()+score);
				Cell targetCell=usingBoard.getCell(index);
				System.out.println(playerThisTurn.getName()+" should go to the cell "+index);
				
				index=usingBoard.normalize(targetCell.handleMove(score));
				targetCell=usingBoard.getCell(index);
				
				System.out.println("Well, "+playerThisTurn.getName()+" goes to the cell" +index);
				
				if(targetCell.isBusy())
				{
					System.out.println("Oh, this cell is busy"+playerThisTurn.getName()+" and "+ targetCell.getPlayer().getName()+" will swap.");
					usingBoard.swapPlayer(playerThisTurn, targetCell.getPlayer());
				}
				else
				{
					targetCell.welcome(playerThisTurn);
					playerThisTurn.setCell(targetCell);
				}
			}
			else
			{
				System.out.println("Oh! " + playerThisTurn.getName()+"is blocked. Next turn.");
			}
			
		}
		System.out.println("Congratulations! won!");
		
	}
	
	/**
	 * @return return if the game is finished or not.
	 */
	public boolean isFinished()
	{
		boolean gameSet;
		if(this.usingBoard.getCell(usingBoard.LAST_CELL).getPlayer()!=null)
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
