package a5novice;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PixelIterator implements Iterator<Pixel>{
	private Picture source; 
	private int index; //current location
	
	public PixelIterator (Picture source) {
		this.source = source; 
	}
	
	
	@Override
	public boolean hasNext() {
		if (index >= source.getWidth() * source.getHeight()) {
			return false;
		}
		
		return true;
	}

	@Override
	public Pixel next() {
		if (hasNext() == false){
			throw new NoSuchElementException();
		}
		Pixel p = source.getPixel(index%source.getWidth(), index/source.getWidth());
		index++;
		return p; 
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}

	//Iterator it = this.iterator();
	//while(it.hasNext()){
		//Pixel pix = it.next();
		//System.out.println(pix.getChar());
	//}
	
}
