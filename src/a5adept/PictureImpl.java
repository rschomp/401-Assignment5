package a5adept;

import java.util.Iterator;

public class PictureImpl extends AnyPicture{

	private int width;
	private int height;

	private Pixel[][] array;
	
	public PictureImpl(int width, int height){
		this.width = width;
		this.height = height;
		array = new Pixel[height][width];
		
		for (int i = 0; i<height; i++) {
			
			for (int k = 0; k<width; k++) {
				setPixel(k, i, new ColorPixel (1.0, 1.0, 1.0));	
			}	
		}
	}

	public int getWidth() {
		return width;
	}

	
	public int getHeight() {
		return height;
	}


	public void setPixel(int x, int y, Pixel p) {
		array[y][x] = p;
		
	}
	
	public Pixel getPixel(int x, int y) {
		return array[y][x];
		
	}

	public int countRange(double low, double high) {
		int count = 0;
		for (int i = 0; i<height; i++) {
			
			for (int k = 0; k<width; k++) {
				if (array[i][k].getIntensity() >= low && array[i][k].getIntensity() <= high) {
					count++;
				}
			}	
		
		}
		
		return count;
		
	}
	
	public void print() {
		for (int i = 0; i<height; i++) {
			
			for (int k = 0; k<width; k++) {
				System.out.print(getPixel(k, i).getChar());	
			}	
		System.out.println();
		}
		
	}


	public SubPicture extract(int xOffset, int yOffset, int width, int height) {
		return new SubPictureImpl(this, xOffset, yOffset, width, height);
	}

	public void setPixel(Coordinate c, Pixel p) {
		int x = c.getX();
		int y = c.getY();
		setPixel(x,y,p);
		
	}

	
	public Pixel getPixel(Coordinate c) {
		int x = c.getX();
		int y = c.getY();
		return getPixel(x,y);
	}

	
	public SubPicture extract(Coordinate corner_a, Coordinate corner_b) {
		int ax = corner_a.getX();
		int ay = corner_a.getY();
		int bx = corner_b.getX();
		int by = corner_b.getY();
		int width = Math.abs(ax-bx);
		int height = Math.abs(ay-by);
		
		int xOffset = Math.min(ax, bx);
		int yOffset = Math.min(ay, by);
		
		return extract(xOffset,yOffset, width,height);
		
	}
	
	public Iterator<Pixel> iterator() {
		return new PixelIterator(this);
	}







}
