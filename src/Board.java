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
	
	/**
	 * Default constructor. This creates a classic board.
	 * Corresponds to calling Board("boards/default").
	 * @throws IOException appends if the file could not be opened.
	 */
	public Board() throws IOException
	{		
		this("boards/default");
	}
	/**
	 * Constructs a board with custom cells placement.
	 * Read the documentation about the board configuration files for more details.
	 * TODO write documentation about board configuration file
	 * @param configFile the path to the board configuration file
	 * @throws IOException appends if the file could not be opened or if the file contains mistakes
	 */
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
			
			else if(command.equals("goose")) {
				for(int i = 1; i < words.length;i++) {
					int index = Integer.parseInt(words[i]);
					cells[index] = new GooseCell(index);
				}
			}
			
			else if(command.equals("trap")) {
				for(int i = 1; i < words.length;i++) {
					int index = Integer.parseInt(words[i]);
					cells[index] = new TrapCell(index);
				}
			}
			
			else if(command.equals("wait")) {
				for(int i = 1; i < words.length;i++) {
					String[] data = words[i].split(":");
					int index = Integer.parseInt(data[0]),
							time = Integer.parseInt(data[1]);
					cells[index] = new WaitCell(index, time);
				}
			}
			
			else if(command.equals("teleport")) {
				for(int i = 1; i < words.length;i++) {
					String[] data = words[i].split(":");
					int index = Integer.parseInt(data[0]),
							dest = Integer.parseInt(data[1]);
					cells[index] = new TeleportCell(index, dest);
				}
			}
			else
				throw new IOException("Parse error: unknown key word "+words[0]+" on line "+line);
			
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
