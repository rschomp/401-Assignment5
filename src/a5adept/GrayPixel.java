package a5adept;

public class GrayPixel implements Pixel {

	private double intensity;
	
	public GrayPixel(double intensity) {
		if (intensity < 0.0 || intensity > 1.0 ) {throw new RuntimeException("Explanation string");}
		this.intensity = intensity;
	}

	public double getRed() {
		return intensity;
	}

	public double getGreen() {
		return intensity;
	}

	public double getBlue() {
		return intensity;
	}


	public double getIntensity() {
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
		} else {
			return ' ';
		}
		
	
	}
	
	
	public Pixel blend(Pixel p, double weight) {
		double blendIntensity = this.intensity * (weight) + p.getIntensity()*(1-weight);
		ColorPixel cp = new ColorPixel(blendIntensity, blendIntensity, blendIntensity);
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
