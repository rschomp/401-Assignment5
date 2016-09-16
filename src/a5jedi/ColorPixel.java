package a5jedi;

public class ColorPixel implements Pixel {

	private double red;
	private double blue;
	private double green;
	
	public ColorPixel(double red, double green, double blue) {
		if (red < 0.0 || red > 1.0 ) {throw new RuntimeException("Explanation string");}
		if (blue < 0.0 || blue > 1.0 ) {throw new RuntimeException("Explanation string");}
		if (green < 0.0 || green > 1.0 ) {throw new RuntimeException("Explanation string");}
		this.red = red;
		this.blue = blue;
		this.green = green;
	}

	public double getRed() {
		return this.red;
	}


	public double getGreen() {
		return green;
	}


	public double getBlue() {
		return blue;
	}
	
	public double getIntensity() {
		double intensity = 0.299 * red + 0.587 * green + 0.114 * blue;
		return intensity;	
	}

	
	public char getChar() {
		double intensity = getIntensity();
		if (intensity >= 0.0 && intensity <.10) { 
			return '#';
		} else if (intensity<.20) { 
			return 'M';
		} else if (intensity<.30) {
			return 'X';
		} else if (intensity<.40) {
			return 'D';
		} else if (intensity<.50) {
			return '<';
		} else if (intensity<.60) {
			return '>';
		} else if (intensity<.70) {
			return 's';
		} else if (intensity<.80) {
			return ':';
		} else if (intensity<.90) {
			return '-';
		} else  {
			return ' ';
		}
		
		
	}
	
	public Pixel blend(Pixel p, double weight) {
		double blendRed = this.red * (weight) + p.getRed()*(1-weight);
		double blendBlue = this.blue * (weight) + p.getBlue()*(1-weight);
		double blendGreen = this.green * (weight) + p.getGreen()*(1-weight);

		ColorPixel cp = new ColorPixel(blendRed, blendGreen , blendBlue);
		return cp;
	}
	
	public Pixel lighten(double factor) {
		
		ColorPixel white = new ColorPixel (1.0, 1.0, 1.0);
		Pixel lightenPixel = blend(white, 1-factor);
		return lightenPixel;
		
		
	}
	public Pixel darken(double factor) {
		
		ColorPixel black = new ColorPixel (0.0, 0.0, 0.0);
		Pixel darkenPixel = blend(black, 1-factor);
		return darkenPixel;
	}
	
	
}






