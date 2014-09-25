import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class Board {
	private Cell[] cells;
	public final int LAST_CELL;
	
	/**
	 * Default constructor. This creates a classic board.
	 * Corresponds to calling Board("boards/default").
	 * @throws IOException happens if the file could not be opened.
	 */
	public Board() throws IOException
	{
		// TODO see for the path 
		this("/home/l3/tanghe/Documents/COO/jeudeloie/boards/default");
	}
	
	/**
	 * Constructs a board with custom cells placement.
	 * Read the documentation about the board configuration files for more details.
	 * TODO write documentation about board configuration file
	 * @param configFile the path to the board configuration file
	 * @throws IOException happens if the file could not be opened or if the file contains mistakes
	 */
	public Board(String configFile) throws IOException {
		
		//FileInputStream input = new FileInputStream(configFile);
		//BufferedReader file = new BufferedReader(new InputStreamReader(input));
		File input = new File(configFile);
		BufferedReader file = new BufferedReader(new FileReader(input));

		
		String line = "";
		int lastCell = 0;
		
		while((line = file.readLine()) != null) {
			line = line.toLowerCase();
			String[] words = line.split(" ");
				
			String command = words[0].toLowerCase();
			
			if(command.equals("number_cells")) {
				command = words[1];
				lastCell = Integer.parseInt(command);
				cells = new Cell[lastCell+1];
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
			else {
				file.close();
				throw new IOException("Parse error: unknown key word "+words[0]+" on line "+line);
			}
		}
		
		for(int i = 1; i < cells.length; i++) {
			
			if(cells[i] == null)
				cells[i] = new NormalCell(i);
			
		}
		
		file.close();
		
		LAST_CELL = lastCell;
		
	}
	
	/**
	 * Swap the location of two players
	 * @param p1 
	 * @param p2
	 */
	public void swapPlayer(Player p1, Player p2)
	{
		Cell temporaryCell = p1.getCell();
		p1.setCell(p2.getCell());
		p2.setCell(temporaryCell);
		
		p1.getCell().welcome(p1);
		p2.getCell().welcome(p2);
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
		int normalizedIndex = 0;
		
		if(supposedIndexCell > LAST_CELL) {
			normalizedIndex = supposedIndexCell - LAST_CELL;
			return LAST_CELL - normalizedIndex;
		}
		else
			return supposedIndexCell;
			
	}
}
