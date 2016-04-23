package views;

import java.awt.*;
import java.util.*;

import javax.swing.JPanel;

import entity.AllHex;
import entity.RowColumn;

/**
 * Here is where the pieces are to be played (in 512x512 size). 
 */
public class PieceView extends JPanel {

	/** Core model. */
	//Model model;
	
	/** Off-screen image for drawing (and Graphics object). */
	Image offScreenImage = null;
	Graphics offScreenGraphics = null;
	int[] pieces = new int[35];
	int row=0, col=0;
	AllHex hexList; 
	
	Hashtable<AllHex,Color> colorMapping = new Hashtable<AllHex,Color>();
    public ArrayList<RectangleShape> shapeList = new ArrayList<RectangleShape>();

	// Given a set of pieces, draw them in this panel. 
		public PieceView(int num) {

			/* initially allocate random color with each piece
			Random rand = new Random();
			for (AllHex p : model.getPieces()) {
				Color randomColor = new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
				colorMapping.put(p, randomColor);
			}
			*/
			initComponents();
		}
		
	//  Square Tile 1:1, 32x32 pixels. 
		@Override
		public Dimension size() {
			int width = 33;
			int height = 33;

			return new Dimension (width, height);
		}
	

		/*
	// Only here so we can safely open within WindowBuilder. 
	PieceView() {
		model = new Model();
	}
	*/
		
		private void initComponents() {		
			RowColumn coords[] = new RowColumn[6];
			int row=0,col=0;
			
			coords = hexList.getHex(1).getCoordShape();
	
			for (int i=0; i<coords.length;i++){
				row = coords[i].getRow();
				col = coords[i].getColumn()*-1;
				shapeList.add(new RectangleShape((33*row),(col*33),33,33,false));	
			}
			
			coords = hexList.getHex(2).getCoordShape();
			
			for (int i=0; i<coords.length;i++){
				row = coords[i].getRow();
				col = coords[i].getColumn()*-1;
				shapeList.add(new RectangleShape((33*row),(col*33),33,33, false));			
			}

	    }

	// Draw background puzzle and all active pieces.
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
		for (RectangleShape s : shapeList) {
            s.draw(g);
        }
		
		/* double check if no model (for WindowBuilder)
		if (model == null) { return; }
		
		// draw active polygon.
		PlacedPiece active = model.getActive();
		if (active != null) {
			g.setColor(colorMapping.get(active.getPiece()));
			g.fillPolygon(active.getPolygon());
		}
		*/
	}
	
	/*Helper method to return polygon for tangram piece anchored at (x,y). 
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
	
	/** 
	 * Helper method to return polygon for tangram piece anchored at (x,y). 
	 *
	 * Appropriate that this method be in View since it is responsible for
	 * mapping abstract pieces into pixel locations.
	 
	public Polygon computePolygon(int x, int y, Tile tp) {
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

	// Draw background and then all pieces on top of it. 
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
