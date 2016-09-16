package a5novice;

import java.util.Iterator;

public class SubPictureImpl extends AnyPicture implements SubPicture {
	
	private int yOffset;
	private int xOffset;
	private Picture source;
	

	public SubPictureImpl (Picture source, int xOffset, int yOffset, int width, int height) {
		if (source == null) {throw new IllegalArgumentException ("cannot be null");}
		if (source.getHeight() < height + yOffset) {throw new IllegalArgumentException ("height not valid");}
		if (source.getWidth() < width + xOffset) {throw new IllegalArgumentException ("width not valid");}
		if (xOffset < 0) {throw new IllegalArgumentException ("x cannot be negative");}
		if (yOffset < 0) {throw new IllegalArgumentException ("y cannot be negative");}
		if (height < 0) {throw new IllegalArgumentException ("height cannot be negative");}
		if (width < 0) {throw new IllegalArgumentException ("width cannot be negative");}
		
		this.source = source;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
		this.width = width;
		this.height = height;
	}

	public Pixel getPixel(int x,int y) {
		return source.getPixel(xOffset+x, yOffset+y);
	}
	
	public void setPixel(int x, int y, Pixel p) {
		source.setPixel(xOffset+x, yOffset+y, p);
		
	}

	public int getWidth() {
		return width;
	}

	
	public int getHeight() {
		return height;
	}

	
	public Picture getSource() {
		return source;
	}


	public int getXOffset() {
		return xOffset;
	}

	
	public int getYOffset() {
		return yOffset;
	
	}

	@Override
	public Iterator<Pixel> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
