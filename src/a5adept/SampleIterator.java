package a5adept;

import java.util.Iterator;

public class SampleIterator implements Iterator<Pixel>{
	private Picture source;
	private int x;
	private int y;
	private int dx;
	private int dy;
	private int noChangeX;
	
	
	public SampleIterator(Picture source, int init_x, int init_y, int dx, int dy) {
		this.source = source;
		this.dx  = dx;
		this.dy = dy;
		this.x = init_x-dx;
		this.y = init_y;
		this.noChangeX = init_x;
		
	}
	

	@Override
	public boolean hasNext() {
		return y+dy < source.getHeight() || x+dx < source.getWidth();
	}
		

	@Override
	public Pixel next() {
		if (!hasNext()) {
			throw new RuntimeException();
		}
		
		if(x+dx < source.getWidth()){
			x = x+dx;
			return source.getPixel(x,y);
		}
		
		else {
			y = y+dy;
			x = noChangeX;
			return source.getPixel(x,y);
		}
	
	}

}

