package assignment9;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class BodySegment {

	private double x, y, size;
	private Color color;
	
	public BodySegment(double x, double y, double size) {
		//FIXME
		this.x = x;
		this.y = y;
		this.size = size;
		color = ColorUtils.solidColor();
		//See ColorUtils for some color options (or choose your own)
	}
	
	public void setPosition(double X, double Y) {
		x = X;
		y = Y;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	/**
	 * Draws the segment
	 */
	public void draw() {
		//FIXME
		StdDraw.setPenColor(color);
		StdDraw.filledSquare(x, y, size);
	}
	
}
