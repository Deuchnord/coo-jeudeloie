import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Game {
	private Board usingBoard;
	private int noPlayer;
	private ArrayList<Player> listPlayers;
	private boolean allPlayersBlockedForever;
	
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
			p.setCell(usingBoard.getCell(0));
		}
		
		while(!this.isFinished())
		{
			playerThisTurn=this.nextPlayer();
			System.out.println("\nIt's "+playerThisTurn.getName()+"'s turn now!");
			
			if(playerThisTurn.getCell().canBeLeftNow())
			{
				score=this.throwDie();
				System.out.println(playerThisTurn.getName() +" launches the dice and gets a "+score+".");
				
				int index=usingBoard.normalize(playerThisTurn.getCell().getIndex()+score);
				Cell targetCell=usingBoard.getCell(index);
				System.out.println(playerThisTurn.getName()+" should go to the cell "+index+".");
				
				if(usingBoard.getCell(index) instanceof GooseCell)
					System.out.println("That's a Goose cell! "+playerThisTurn.getName()+"'s score is doubled!");
				else if(usingBoard.getCell(index) instanceof TrapCell)
					System.out.println("Gosh, that's a Trap cell... Sorry, "+playerThisTurn.getName()+", you'll be blocked here for a moment!");
				else if(usingBoard.getCell(index) instanceof WaitCell)
					System.out.println("Oh, my, that's a Wait cell, "+playerThisTurn.getName()+" will have to wait a little.");
				else if(usingBoard.getCell(index) instanceof TeleportCell)
					System.out.println("What's happening? "+playerThisTurn.getName()+" feels strange: he just reached a Teleport Cell!");
				
				index=usingBoard.normalize(targetCell.handleMove(score));
				targetCell=usingBoard.getCell(index);
				
				System.out.println("Well, "+playerThisTurn.getName()+" goes to the cell " +index+".");
				
				if(targetCell.isBusy() && !targetCell.getPlayer().equals(playerThisTurn))
				{
					// Another player is already on this cell, swapping.
					System.out.println("Oh, this cell is already busy, "+playerThisTurn.getName()+" and "+ targetCell.getPlayer().getName()+" swap.");
					usingBoard.swapPlayer(playerThisTurn, targetCell.getPlayer());
				}
				else if(targetCell.isBusy() && targetCell.getPlayer().equals(playerThisTurn))
				{
					// The current player was already on this cell.
					System.out.println(playerThisTurn.getName()+" stucks!");
				}
				else
				{
					targetCell.welcome(playerThisTurn);
					playerThisTurn.setCell(targetCell);
				}
			}
			else
			{
				System.out.println("Oh! " + playerThisTurn.getName()+" is blocked. Next turn.");
			}
			
		}
		
		if(!allPlayersBlockedForever)
			System.out.println("Congratulations, you won!");
		else
			System.out.println("\nEverybody is blocked, end of the game.");
		
	}
	
	/**
	 * @return return if the game is finished or not.
	 */
	public boolean isFinished()
	{
		boolean gameSet;
		
		allPlayersBlockedForever = true;
		
		for(Player p : listPlayers) {
			// Loop verifying that at least one player is not blocked in a Trap cell
			if(!p.getCell().isRetaining())
				allPlayersBlockedForever = false;
		}
		if(this.usingBoard.getCell(usingBoard.LAST_CELL).getPlayer() == null && !allPlayersBlockedForever)
		{
			gameSet = false;
		}
		else
		{
			gameSet = true;
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
