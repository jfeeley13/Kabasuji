package entity;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.Border;

import views.Level;

public class BullPen extends JPanel{

	protected List<Hexomino> HexsInPen = new ArrayList<Hexomino>();
	protected Hexomino selectedHex;
	public Level level;
	
	public BullPen(Level level,List<Hexomino> HexsInPen){
		this.level=level;
		this.HexsInPen = HexsInPen;
		HexTile[] shape1 = {new HexTile(1,this, 0,0),new HexTile(1,this,0,1),new HexTile(1,this,0,2),new HexTile(1,this,0,3),new HexTile(1,this,0,4),new HexTile(1,this,0,5)};
		HexTile[] shape2 = {new HexTile(2,this, 0,0),new HexTile(2,this,1,1),new HexTile(2,this,0,2),new HexTile(2,this,0,3),new HexTile(2,this,0,4),new HexTile(2,this,0,1)};

		Hexomino h1 = new Hexomino(1, shape1);		
		Hexomino h2 = new Hexomino(2, shape2);
		HexsInPen.add(h1);
		HexsInPen.add(h2);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1, true);
		for(int h=0; h<HexsInPen.size();h++){
			HexTile tileList[][]=new HexTile[6][6];
			JPanel panel=new JPanel(new GridLayout(6,6));
			panel.setPreferredSize(new Dimension(99,99));
			panel.setMaximumSize(new Dimension(99,99));
			panel.setMinimumSize(new Dimension(99,99));
			for(int i=0; i<6;i++){
				for(int j=0; j<6;j++){
					HexTile tile=new HexTile(h,this,i,j);
					tile.valid=0;
					
					//tile.setBorder(border);
					//tile.setBackground(Color.blue);
					tileList[i][j]=tile;
					panel.add(tile);
				}
			}
			int coords[][]=this.HexsInPen.get(h).getCoordShape();
			for(int i=0; i<6;i++){
				int x=coords[i][1];
				int y=coords[i][0];

				HexTile tile=tileList[x][y];
				tile.valid=1;
				tile.setBackground(Color.blue);
				tile.setBorder(border);
			}
			this.add(panel);
		}
	}
	
	public Level getLevel(){
		return level;
	}
	
	public void rotateHex(boolean direction){
		
	}
	
	public void flipHex(boolean direction){
		
	}
	
	public Hexomino getPiece(int x){
		return this.HexsInPen.get(x);
	}
	
	public void addHex(Hexomino piece){
		HexsInPen.add(piece);
	}
	
	public void removeHex(Hexomino piece){
		
	}
	
}
