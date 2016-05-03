package gameControllers;

import java.awt.Color;
import java.awt.event.MouseEvent;

import entity.BoardBoss;
import entity.Tile;

public class BuilderMListener extends MListener{

	public BuilderMListener(Tile tile, BoardBoss board) {
		super(tile, board);
	}

/*	public void mouseClicked(MouseEvent e) {
		if(e.getButton() == 3){
			this.tile.toggleTile();
			if(this.tile.checkValid()){
				this.tile.setBackground(Color.ORANGE);
			}else this.tile.setBackground(Color.MAGENTA);
		}
	}*/
}