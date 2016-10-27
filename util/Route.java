package util;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import math.Vector;

public class Route {
	public List<Vector> route;
	public Color color;
	public String name;
	
	public Route(Color color, String name) {
		this.route = new ArrayList<Vector>();
		this.color = color;
		this.name = name;
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
	
	public void generate(List<Vector> nails) {
		for(Vector nail : nails)
			route.add(nail);
	}
}
