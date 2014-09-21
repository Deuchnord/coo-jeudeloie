
public abstract class AbstractCell implements Cell {

	int index;
	Player player;
	
	@Override
	public boolean canBeLeftNow() {
		return true;
	}

	@Override
	public boolean isRetaining() {
		return false;
	}

	@Override
	public int getIndex() {
		return this.index;
	}

	@Override
	public int handleMove(int diceThrow) {
		return this.index + diceThrow;
	}

	@Override
	public boolean isBusy() {
		if(player == null)
			return false;
		else
			return true;
	}

	@Override
	public Player getPlayer() {
		return player;
	}

	@Override
	public void welcome(Player player) {
		this.player = player;
	}

}
