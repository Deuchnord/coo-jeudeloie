import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Board {
	private Cell[] cells;
	public final int LAST_CELL;
	
	
	public Board()
	{
		LAST_CELL = 63;
	}
	
	public Board(String configFile) throws IOException {
		
		FileInputStream input = new FileInputStream(configFile);
		BufferedReader file = new BufferedReader(new InputStreamReader(input));
		
		String line = "";
		int lastCell = 0;
		
		while((line = file.readLine().toLowerCase()) != null) {
			
			String[] words = line.split(" ");
				
			String command = words[0].toLowerCase();
			
			if(command.equals("number_cells")) {
				command = words[1];
				lastCell = Integer.parseInt(command);
			}
			
			if(command.equals("goose")) {
				for(int i = 1; i < words.length;i++) {
					
				}
			}
			
		}
		
		file.close();
		
		LAST_CELL = lastCell;
		
	}
	
	/**
	 * Swap the location of two players
	 * @param p1 
	 * @param p2
	 */
	public void swapPlayer(Player p1,Player p2)
	{
		Cell temporaryCell;
		temporaryCell = p1.getCell();
		p1.setCell(p2.getCell());
		p2.setCell(temporaryCell);
	}
	
	public Cell getCell(int indexCell)
	{
		return cells[indexCell];
	}
	
	/**
	 * @param supposedIndexCell The cell to check.
	 * @return the cell's index normalised.
	 */
	public int normalize(int supposedIndexCell)
	{
		if(supposedIndexCell>LAST_CELL)
			supposedIndexCell+=LAST_CELL-supposedIndexCell;
		return supposedIndexCell;
			
	}
	
	
	
	

}
