import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Player> playersList=new ArrayList<Player>();
		int nbplayer=0;
		Scanner sc = new Scanner(System.in);
		System.out.print("Please, enter the number of players: ");
		
		try{
			nbplayer=sc.nextInt();
		} catch(InputMismatchException e) {
			System.out.println("What do you mean? That's not a number!");
			return;
		}
		
		if(nbplayer < 2) {
			System.out.println("Sorry, there should be at least 2 players!");
			return;
		}
		
		for(int i=1; i<=nbplayer; i++)
		{
			System.out.print("Please, enter the Player "+i+"'s name: ");
			String playerName=sc.next();
			playersList.add(new Player(playerName));
		}
		
		try {
			Game newGame = new Game(playersList);
			newGame.play();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		

	}

}
