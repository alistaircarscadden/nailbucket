package math;

public class Vector {
	public float x, y;
	
	public Vector(float x, float y) {
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
}
