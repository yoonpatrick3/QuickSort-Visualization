import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.*;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MakeRectangle extends JPanel {
	public Rectangle[] r;
	public int scale;
	public int i, j, p;
	
	public MakeRectangle(Rectangle[] r, int scale, int i, int j, int pivotI) {
		this.r = r;
		this.scale = scale;
		this.i = i;
		this.j = j;
		p = pivotI;

		
		setLayout(null);
		setPreferredSize(new Dimension(800,550));
		
	}
	
	
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        for(int k = 0; k<r.length; k++) {
     
        	Rectangle rect = r[k];
        
        	
        	if(k==p) {
        		g.setColor(Color.RED);
        	}
        	else if(k%2==0) {
        		g.setColor(Color.GREEN);
        	}
        	else {
        		g.setColor(Color.YELLOW);
        	}
        	
        	g.fillRect((int)rect.getX(), (int)rect.getY(), (int)rect.getWidth(), (int)rect.getHeight());
        	g.setColor(Color.BLACK);
        	
        	g.drawRect((int)rect.getX(), (int)rect.getY(), (int)rect.getWidth(), (int)rect.getHeight());
        	
        	String textHeight = Integer.toString((int)rect.getHeight()/scale);
        	g.setFont(new Font("TimesRoman", Font.PLAIN, 25));
        	int xCenterAlignment = 10;
        	
        	g.drawString(textHeight, (int)rect.getCenterX()-xCenterAlignment, (int)rect.getCenterY());
        	int indexHeight = (int)rect.getCenterY()+(((int)rect.getHeight()/2)+30);
        	
        	g.setColor(Color.RED);
        	g.drawString(Integer.toString(k), (int)rect.getCenterX()-xCenterAlignment, indexHeight);
        	
        }
        
        g.setColor(Color.MAGENTA);
    	g.setFont(new Font("TimesRoman", Font.PLAIN, 40));
        int iHeight = (int)r[i].getCenterY() - (((int)r[i].getHeight()/2)+30);
		g.drawString("i", (int)r[i].getCenterX()-10, iHeight);
		
	    g.setColor(Color.BLUE);
		int jHeight = (int)r[j].getCenterY() - (((int)r[j].getHeight()/2)+80);
		g.drawString("j", (int)r[j].getCenterX()-10, jHeight);
    }

}
