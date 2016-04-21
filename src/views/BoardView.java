package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;
import javax.swing.JPanel;
import views.RectangleShape;
import entity.Tile;

public class BoardView extends JPanel {
    public ArrayList<RectangleShape> shapeList = new ArrayList<RectangleShape>();

	/** Core model. 
	Model model;*/

	int tileSize = 32;
	int row, col;

	/** Off-screen image for drawing (and Graphics object). */
	Image offScreenImage = null;
	Graphics offScreenGraphics = null;

	/** Color mapping. Could also be used within TangramPiecesView but for now keep here. */
	Hashtable<Tile,Color> colorMapping = new Hashtable<Tile,Color>();

	/** Only here so we can safely open within WindowBuilder. 
	PuzzleView() {
		model = new Model();
	}*/

	/** Draw the board them in this panel. */
	public BoardView(int rows, int cols) {
		row = rows;
		col = cols;
		
        this.initComponents();

	}
	
	private void initComponents() {
		//create a arraylist of row/col squares
		for (int i=0; i<=row;i++){
			for (int j=0; j<=col;j++){
				shapeList.add(new RectangleShape((33*i),(j*33),33,33,true));
			}
		}
    }
	

	 @Override
	    public void paint(Graphics g) {
	        for (RectangleShape s : shapeList) {
	            s.draw(g);
	        }
	    }


	/** 
	 * Swing thing. We must be large enough to draw all tangram pieces. 
	 */
	@Override
	public Dimension getMinimumSize() { //6x6 board
		int width = 192;
		int height = 192;

		return new Dimension (width, height);
	}
	
	@Override
	public Dimension getMaximumSize() {	//12x12 board
		int width = 384;
		int height = 384;

		return new Dimension (width, height);
	}


	/** 
	 * Swing thing. We must be large enough to draw all Tangram pieces. 
	 */
	@Override
	public Dimension getPreferredSize() {
		int width = row*tileSize;
		int height = col*tileSize;

		return new Dimension (width, height);
	}


	/**
	 * Draw background puzzle and all active pieces.
	
	public void paintComponent(Graphics g) {
		

		super.paintComponent(g);

		if (offScreenImage == null) {
			// create on demand
			Dimension s = getPreferredSize();
			offScreenImage = this.createImage(s.width, s.height);
			offScreenGraphics = offScreenImage.getGraphics();

			//redraw();
		}

		// if no offscreenImage, then Swing hasn't fully initialized; leave now
		if (offScreenImage == null) {
			System.err.println("Swing not ready for drawing.");
			return;
		}

		// copy image into place.
		//g.drawImage(offScreenImage, 0, 0, this);
			//DRAWS A BOX
			g.drawRect(30,30,33,33); 
	        g.setColor(Color.BLACK);  
	        g.fillRect(30,30,33,33);
	        g.drawRect(32,32,30,30); 
	        g.setColor(Color.RED);  
	        g.fillRect(32,32,30,30);
	        
		
		}

		// double check if no model (for WindowBuilder)
		//if (model == null) { return; }

		/ draw active polygon.
		PlacedPiece active = model.getActive();
		if (active != null) {
			g.setColor(colorMapping.get(active.getPiece()));
			g.fillPolygon(active.getPolygon());
		}
		
	}
	*/

	/** Helper method to return polygon for piece anchored at (x,y). 
	public Polygon computePolygon(int x, int y, Puzzle p) {
		int[] xpoints = new int[p.size()];
		int[] ypoints = new int[p.size()];

		// convert coordinate sequence into (x,y) points.
		int idx = 0;
		for (Coordinate c : p) {
			xpoints[idx] = (int) (x + N*c.x);
			ypoints[idx] = (int) (y + N*c.y);
			idx++;
		}

		return new Polygon(xpoints, ypoints, p.size());
	}
	*/

	/** 
	 * Helper method to return polygon for tangram piece anchored at (x,y). 
	 *
	 * Appropriate that this method be in View since it is responsible for
	 * mapping abstract pieces into pixel locations.
	 
	public Polygon computePolygon(int x, int y, TangramPiece tp) {
		int[] xpoints = new int[tp.size()];
		int[] ypoints = new int[tp.size()];

		// convert coordinate sequence into (x,y) points.
		int idx = 0;
		for (Coordinate c : tp) {
			xpoints[idx] = (int) (x + N*c.x);
			ypoints[idx] = (int) (y + N*c.y);
			idx++;
		}

		return new Polygon(xpoints, ypoints, tp.size());
	}
	*/

	/** Draw background and then all pieces on top of it. 
	public void redraw() {
		// Once created, draw each, with buffer.
		int x = offset;
		int y = offset;

		Dimension dim = getPreferredSize();
		offScreenGraphics.clearRect(0, 0, dim.width, dim.height);

		Puzzle p = model.getPuzzle();
		Polygon polyshape = computePolygon (x, y, p);
		offScreenGraphics.setColor(Color.black);
		offScreenGraphics.fillPolygon(polyshape);

		// placed pieces.
		if (model.getPlacedPieces() != null) {
			for (PlacedPiece pp : model.getPlacedPieces()) {
				if (pp != model.getDraggingPiece()) {
					offScreenGraphics.setColor(colorMapping.get(pp.getPiece()));
					offScreenGraphics.fillPolygon(pp.getPolygon());
				}
			}
		}		
	}
	*/

}

