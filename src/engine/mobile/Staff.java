package engine.mobile;

import engine.map.Block;

public abstract class Staff extends MobileElement {
	private int salaire;
	
	public Staff(int salaire, Block position) {
		super(position);
		this.salaire = salaire;
	}
}
