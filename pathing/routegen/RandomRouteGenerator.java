package pathing.routegen;

import java.util.List;

import math.Vector;
import pathing.Route;
import pathing.RouteGenerator;

public class RandomRouteGenerator implements RouteGenerator {

	public RandomRouteGenerator() {
	}
	
	public void generate(Route route, List<Vector> nails) {
		for(Vector nail : nails)
			route.add(nail);
	}
	
}
