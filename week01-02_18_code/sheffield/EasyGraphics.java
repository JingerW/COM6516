// Author: Steve Maddock
// 10 Nov 2008
// Plot method added by Guy Brown 27/7/09
// modified so that moveTo and lineTo have camelcase names
// shortened fill method names
// getRed, getBlue, getGreen methods added by Phil McMinn 1/9/11

package sheffield;

import java.awt.*;
import java.awt.image.*;
import java.awt.geom.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class EasyGraphics extends JFrame {
	
	private EasyJPanel myDrawing;
	
	/**
	* Create a new EasyGraphics with window size 200x200
	*/
	public EasyGraphics() {
		this(200,200);
	}
	
	/**
	* Create a new EasyGraphics with a specified window size
	* @param w width of the window in pixels
	* @param h height of the window in pixels
	*/
	public EasyGraphics(int w, int h) {
		setTitle("Graphics Window");
		Insets insets=getInsets();
		int wextra = w+insets.left+insets.right;
		int hextra = h+insets.top+insets.bottom;
		setSize(wextra, hextra);  
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container contentPane = this.getContentPane();
		myDrawing = new EasyJPanel(w,h);
		contentPane.add(myDrawing, "Center");
		setResizable(false);
		setVisible(true);
		pack();
	}
	
	/**
	* Clear the EasyGraphics window 
	*/
	public void clear() {
		myDrawing.clear();
	}
	
	/**
	* Set the current drawing colour
	* @param r red component 
	* @param g green component 
	* @param b blue component 
	*/	
	public void setColor(int r, int g, int b) {
		myDrawing.setColor(r,g,b);
	}
	
	/**
	 * Draw a string in the current foreground colour
	 * @param s the string to draw
	 * @param x the x coordinate of the string
	 * @param y the y coordingate of the string
	 * @param fontSize the font size
	 */
	public void drawString(String s, int x, int y, int fontSize) {
		myDrawing.drawString(s,x,y,fontSize);
	}
	
	/**
	* Move the graphics cursor to the given x,y coordinate
	* @param x the x coordinate
	* @param y the y coordinate 
	*/
	public void moveTo(int x, int y) {
		myDrawing.moveto(x,y);
	}
	
	/**
	* Draw a line from the current position to the given x,y coordinate
	* @param x the x coordinate
	* @param y the y coordinate 
	*/
	public void lineTo(int x, int y) {
		myDrawing.lineto(x,y);
	}
	
	/**
	* Plot a point at the given x,y coordinate
	* @param x the x coordinate
	* @param y the y coordinate 
	*/
	public void plot(int x, int y) {
		myDrawing.drawRectangle(x,y-1,1,1,true);
	}
	
	/**
	* Draw a line from (x0,y0) to (x1,y1)
	* @param x0 the x coordinate of the first point
	* @param y0 the y coordinate of the first point
	* @param x1 the x coordinate of the second point
	* @param y1 the y coordinate of the second point
	*/
	public void drawLine(int x0, int y0, int x1, int y1) {
		myDrawing.drawLine(x0,y0,x1,y1);
	}
	
	/**
	* Draw an empty rectangle
	* @param x the x coordinate of the bottom left corner
	* @param y the y coordinate of the bottom left corner
	* @param w the width of the rectangle
	* @param h the height of the rectangle
	*/
	public void drawRectangle(int x, int y, int w, int h) {
		myDrawing.drawRectangle(x,y,w,h, false);
	}		
	
	/**
	* Draw a filled rectangle
	* @param x the x coordinate of the bottom left corner
	* @param y the y coordinate of the bottom left corner
	* @param w the width of the rectangle
	* @param h the height of the rectangle
	*/
	public void fillRectangle(int x, int y, int w, int h) {
		myDrawing.drawRectangle(x,y,w,h, true);
	}			
	
	/**
	* Draw an empty ellipse
	* @param x the x coordinate of the bottom left corner of the bounding box
	* @param y the y coordinate of the bottom left corner of the bounding box
	* @param w the width of the ellipse
	* @param h the height of the ellipse
	*/	
	public void drawEllipse(int x, int y, int w, int h) {
		myDrawing.drawEllipse(x,y,w,h, false);
	}	
	
	/**
	* Draw a filled ellipse
	* @param x the x coordinate of the bottom left corner of the bounding box
	* @param y the y coordinate of the bottom left corner of the bounding box
	* @param w the width of the ellipse
	* @param h the height of the ellipse
	*/	
	public void fillEllipse(int x, int y, int w, int h) {
		myDrawing.drawEllipse(x,y,w,h, true);
	}	
	
	/**
    * Get the red RGB component of a given x,y coordinate
	* @param x the x coordinate
	* @param y the y coordinate 
	*/
	public int getRed(int x, int y) {
		return new Color(myDrawing.getRGB(x,y)).getRed();
	}
	
	/**
    * Get the blue RGB component of a given x,y coordinate
	* @param x the x coordinate
	* @param y the y coordinate 
	*/
	public int getBlue(int x, int y) {
		return new Color(myDrawing.getRGB(x,y)).getBlue();
	}
	
	/**
    * Get the green RGB component of a given x,y coordinate
	* @param x the x coordinate
	* @param y the y coordinate 
	*/
	public int getGreen(int x, int y) {
		return new Color(myDrawing.getRGB(x,y)).getGreen();
	}		
}

@SuppressWarnings("serial")
class EasyJPanel extends JPanel {
	
	private int width;
	private int height;
	private int currentX = 0;
	private int currentY = 0;
	private Color currentColor = new Color(0,0,0);
	
	private BufferedImage image = null;
	@SuppressWarnings("unused")
	private ColorModel colorModel;
	private Graphics2D g2image;
  		
	public EasyJPanel(int w, int h) {
		width=w;
		height=h;
		setPreferredSize(new Dimension(w,h));
		image = new BufferedImage(w,h, BufferedImage.TYPE_INT_ARGB);
		colorModel = image.getColorModel();
		setBackground(Color.white);
		g2image = image.createGraphics();
	}
				
	public void paintComponent(Graphics g) { 
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.drawImage(image,0,0,null);
	}
	
	public void clear() {
		Shape s = new Rectangle2D.Double(0,0,width,height);
		g2image.setColor(Color.white);
		g2image.fill(s);
		repaint();
	}
	
	public void drawString(String s, int x, int y, int fontSize) {
		g2image.setColor(currentColor);
		Font font = new Font("SansSerif", Font.PLAIN, fontSize);
		g2image.setFont(font);
		g2image.drawString(s,x,convert(y));
		repaint();
	}
	
	public void setColor(int r, int g, int b) {
		currentColor = new Color(r,g,b);
	}
	
	public void moveto(int x, int y) {
		currentX = x; currentY = convert(y);
	}
	
	public void lineto(int x, int y) {
		drawLine(currentX, unconvert(currentY), x, y);
		moveto(x,y);
	}
	
	public void drawLine(int x0, int y0, int x1, int y1) {
		moveto(x1,y1);
		Shape s = new Line2D.Double(x0,convert(y0),x1,convert(y1));
		g2image.setColor(currentColor);
		g2image.draw(s);
		repaint();
	}
	
	public void drawRectangle(int x, int y, int w, int h, boolean filled) {
		moveto(x+w,y+h);
		Shape s = new Rectangle2D.Double(x,convert(y)-h,w,h);
		g2image.setColor(currentColor);
		if (filled) g2image.fill(s);
		else g2image.draw(s);
		repaint();		
	}
	
	public void drawEllipse(int x, int y, int w, int h, boolean filled) {
		moveto(x+w/2,y+h/2);
		Shape s = new Ellipse2D.Double(x,convert(y)-h,w,h);
		g2image.setColor(currentColor);
		if (filled) g2image.fill(s);
		else g2image.draw(s);
		repaint();
	}
	
	public int getRGB(int x, int y) {
		return image.getRGB(x, convert(y));
	}
	
	private int convert(int i) {
		return (height-1) - i;
	}
	
	private int unconvert(int i) {
		return convert(i);  // This is the same as convert 
							// but a separate method makes things clearer
	}
}
