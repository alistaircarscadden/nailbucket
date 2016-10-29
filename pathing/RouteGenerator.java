package pathing;

import java.util.List;

import math.Vector;

public interface RouteGenerator {
	
	public void generate(Route route, List<Vector> points);
	
}
