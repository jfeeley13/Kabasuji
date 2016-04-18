package views;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class RectangleShape extends JPanel {
	 int x;
	 int y;
	 int width;
	 int height;
	
    public RectangleShape(int x, int y, int width, int height) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
    }

    public RectangleShape() {
        super();
    }

    public void draw(Graphics g) {
    	//square
        g.drawRect(x, y, width, height);
        g.fillRect(x, y, width, height);
        g.setColor(Color.GRAY);  
        
        //border is just a larger square behind
        g.drawRect(x+2, y+2, width-3, height-3);
        g.fillRect(x+2, y+2, width-3, height-3);
        g.setColor(Color.BLACK);  
    }
    
}
