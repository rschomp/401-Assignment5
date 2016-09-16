package a5jedi;

import java.util.Iterator;

public abstract class AnyPicture implements Picture {
	
		int width;
		int height;
		
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	abstract public void setPixel(int x, int y, Pixel p);
	
	abstract public Pixel getPixel(int x, int y);
	
	
	public int countRange(double low, double high) {
		int count = 0;
		for (int i = 0; i<height; i++) {
			
			for (int k = 0; k<width; k++) {
				if (getPixel(i,k).getIntensity() >= low && getPixel(i,k).getIntensity() <= high) {
					count++;
				}
			}	
		
		}
		
		return count;
	}

	
	public void print() {
	
		for (int i = 0; i<height; i++) {
			
			for (int k = 0; k<width; k++) {
				System.out.print(getPixel(k,i).getChar());	
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
	
	
	
	@Override
	public Iterator<Pixel> sample(int init_x, int init_y, int dx, int dy) {
		return new SampleIterator(this, init_x, init_y, dx, dy);
	}

	@Override
	public Iterator<SubPicture> window(int window_width, int window_height) {
		return new WindowIterator(this, window_width, window_height);
	}

	@Override
	public Iterator<SubPicture> tile(int tile_width, int tile_height) {
		return new TileIterator(this, tile_width, tile_height);
	}
	
	@Override
	public Iterator<Pixel> zigzag() {
		return new Zigzag(this);
	}
}
