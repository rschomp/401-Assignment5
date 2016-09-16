package a5jedi;

import java.util.Iterator;

public class Zigzag implements Iterator<Pixel>  {
	private int x = 0;
	private int y = 0;
	Picture source;
	private int height;
	private int width;
	private int numVisited = 0;
	
	public Zigzag (Picture source) {
		this.source = source; 
		this.width = source.getWidth();
		this.height = source.getHeight();
	}
	
	@Override
	public boolean hasNext() {	
		return (numVisited < width*height);
	}
	
	@Override
	public Pixel next() {
		if (!hasNext()) {
			throw new RuntimeException("no next pixel");
		}
		
		numVisited++;
		Pixel p = source.getPixel(x,y);
		
		if (x == 0 && y == 0) { //check top left corner
			x++;
		}
		else if (width%2 == 0 && x == width-1 && y == 0) { //check top right corner
			x--;
			y++;
		}
		else if (width%2 == 1 && x == width-1 && y == 0) {//check top right corner
			y++;
		}
		else if (height%2 == 0 && x == 0 && y == height-1) { //check bottom left corner
			x++;
		}
		else if (height%2 == 1 && x == 0 && y == height-1) { //check bottom left corner
			x++;
			y--;
		}
		else if (x%2 == 0 && y == 0) { //check top
			x++;
		}
		else if (x%2==1 && y == 0) { //check top
			x--;
			y++;
		}
		else if ((x+y)%2 == 1 && y == height-1) { //check bottom
			x++;
		}
		else if ((x+y)%2 == 0 && y == height-1) { // check bottom
			x++;
			y--;
		}
		else if (y%2 == 1 && x == 0) { //check left
			y++;
		}
		else if (y%2 == 0 && x == 0) { //check left
			x++;
			y--;
		}
		else if ((x+y)%2 == 0 && x == width-1) { //check right
			y++;
		}
		else if ((x+y)%2 == 1 && x == width-1) { //check right 
			x--;
			y++;
		}
		else if ((x+y)%2 == 0) {
			if (x != width-1 && y != height-1) {
				x++;
				y--;
			}
			else if (x != width) {
				x++;
			}	
			else {
				y++;	
			}
		}
		else if ((x+y)%2 != 0) {
			if (x != width && y != height) {
				x--;
				y++;
			}
			else if (x != width) {
				x--;
			}
			else {
				y--;
			}
		}
		return p;
	}
}
