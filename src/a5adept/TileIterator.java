package a5adept;

import java.util.Iterator;

public class TileIterator implements Iterator<SubPicture> {
	
	private Picture source;
	private int x;
	private int y;
	private int tile_width;
	private int tile_height;
	
	public TileIterator(Picture source, int tile_width, int tile_height){
		this.source = source;
		this.tile_width = tile_width;
		this.tile_height = tile_height;
	}
	
	
	@Override
	public boolean hasNext() {
		if( y+tile_height > source.getHeight()) {
			return false;
		}
		else {
			return true;
		}
	
		
	}

	@Override
	public SubPicture next() {
		if (hasNext() == false) {
			throw new RuntimeException();
		}
		SubPicture pic = source.extract(x,y,tile_width,tile_height);
		if (x+tile_width <= source.getWidth()-tile_width){
			x = x+tile_width;
		}
		else{
			x=0;
			y = y+tile_height;
		}
		return pic;
		
	}


}
