package engine.map;


public class Block {
	private int line;
	private int column;

	public Block(int line, int column) {
		this.line = line;
		this.column = column;
	}

	public int getLine() {
		return line;
	}

	public int getColumn() {
		return column;
	}
	
	public boolean equals(Block position2) {
		if ((this.line == position2.getLine()) && (this.column == position2.getColumn())) {
			return true;
		}
		
		return false;
	}

	@Override
	public String toString() {
		return "Block [line=" + line + ", column=" + column + "]";
	}

}
