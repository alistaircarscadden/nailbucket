package math;

import static java.lang.Math.*;

public class Vector {
	
	public double x, y;
	
	public Vector(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Vector() {
		this(0.0f, 0.0f);
	}

	public void add(Vector v) {
		this.x += v.x;
		this.y += v.y;
	}
	
	public void subtract(Vector v) {
		this.x -= v.x;
		this.y -= v.y;
	}
	
	public double distance(Vector v) {
		return sqrt( pow(x - v.x, 2) + pow(y - v.y, 2) );
	}
	
}
