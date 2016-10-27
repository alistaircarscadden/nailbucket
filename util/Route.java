package util;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import math.Vector;

public class Route {
	public List<Vector> route;
	
	public Route() {
		route = new CopyOnWriteArrayList<Vector>();
	}
	
	public void add(Vector u) {
		if(!route.contains(u))
			route.add(u);
		else
			System.err.println("Adding already visited vector to route.");
	}
	
	public void remove(Vector u) {
		if(route.contains(u))
			route.remove(u);
		else
			System.err.println("Removing non-routed vector from route.");
	}
}
