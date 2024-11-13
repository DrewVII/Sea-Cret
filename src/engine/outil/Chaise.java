package engine.outil;

import engine.map.Block;

public class Chaise extends Emplacement{
	private boolean state;
	
	public Chaise(boolean state, Block position) {
		super(position);
		this.state = state;
	}
	
	public boolean getState() {
		return state;
	}
	
	public void setState(boolean state) {
		this.state = state;
	}
}
