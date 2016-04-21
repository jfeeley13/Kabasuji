package entity;

import java.util.HashMap;

public class TileIterator implements java.util.Iterator<Tile>{
	HashMap<RowColumn, Tile> tileBoard;
	RowColumn currentTile;
	int maxRow, maxCol;
	
	public TileIterator(HashMap<RowColumn, Tile> tileBoard, int maxRow, int maxColumn){
		this.tileBoard = tileBoard;
		this.maxCol = maxCol;
		this.maxRow = maxRow;
		this.currentTile = new RowColumn(0, 0);
	}
	@Override
	public boolean hasNext() {
		return (currentTile.row <= maxRow) && (currentTile.column <= maxCol);
	}

	@Override
	public Tile next() {
		Tile item = tileBoard.get(currentTile);
		if(currentTile.getRow() <= maxRow)
			currentTile.setRow(currentTile.getRow() + 1);
		else
			currentTile.setColumn(currentTile.getColumn()+ 1);
		return item;
	}

}
