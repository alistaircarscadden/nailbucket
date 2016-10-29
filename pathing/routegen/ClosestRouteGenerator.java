package pathing.routegen;

import java.util.List;

import math.Vector;
import pathing.Route;
import pathing.RouteGenerator;

public class ClosestRouteGenerator implements RouteGenerator {

	public ClosestRouteGenerator() {
	}
	
	public void generate(Route route, List<Vector> nails) {
		Vector position = route.start;
		
		while(nails.size() > 0) {
			Vector closest = nails.get(0);
			
			for (Vector u : nails) {
				if (position.distance(u) < position.distance(closest))
					closest = u;
			}
			
			nails.remove(closest);
			position = closest;
			route.add(closest);
		}
	}

}
