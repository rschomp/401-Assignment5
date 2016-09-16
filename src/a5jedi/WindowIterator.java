package a5jedi;

import java.util.Iterator;

public class WindowIterator implements Iterator<SubPicture>{
	Picture source;
	private int window_width;
	private int window_height;
	private int x;
	private int y;
	
	public WindowIterator(Picture source, int window_width, int window_height) {
		this.source = source;
		this.window_width = window_width;
		this.window_height = window_height;
	}

	@Override
	public boolean hasNext() {
		if (y+window_height > source.getHeight()) {
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
		
		SubPicture pic = source.extract(x, y,window_width, window_height);
		
		if(pic.getWidth() + x < source.getWidth()){
			x++;
		}
		
		else {
			y++;
			x = 0;
			
		}
		return pic;
	
	}
	

}
