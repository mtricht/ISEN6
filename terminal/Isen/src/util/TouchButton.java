package util;

import java.awt.Point;

public class TouchButton {

	public Point location;
	public int xSize = 40;
	public int ySize = 40;
	public String name;
	
	public TouchButton(Point location,String name)
	{
		this.location = location;
		this.name = name;
	}
}
