import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Player> playersList=new ArrayList<Player>();
		int nbplayer=0;
		Scanner  sc=new Scanner(System.in);
		System.out.println("Please, enter the number of players");
		nbplayer=sc.nextInt();
		
		for(int i=1; i<=nbplayer; i++)
		{
			System.out.println("Please, entrer the name for Player "+i);
			String playerName=sc.next();
			playersList.add(new Player(playerName));
		}
		
		try {
			Game newGame=new Game(playersList);
			newGame.play();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		

	}

}
