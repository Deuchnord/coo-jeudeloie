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
		
		while((line = file.readLine()) != null) {
			
			String[] words = line.split(" ");
			for(int i = 0; i < words.length; i++) {
				
				String word = words[i].toLowerCase();
				
				if(word.equals("number_cells")) {
					i = 1;
					word = words[i];
					LAST_CELL = Integer.parseInt(word);
				}
				
			}
			
		}
		
		
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
