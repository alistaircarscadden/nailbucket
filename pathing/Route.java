package pathing;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import math.Vector;

public class Route {
	
	public List<Vector> route;
	public Vector start;
	public Color color;
	public String name;
	
	public Route(String name, Color color, Vector start) {
		this.route = new ArrayList<Vector>();
		this.color = color;
		this.name = name;
		this.start = start;
	}
	
	public void add(Vector u) {
		if(!route.contains(u))
			route.add(u);
		else
			System.err.println("Vector already in route. Not adding.");
	}
	
	public void remove(Vector u) {
		if(route.contains(u))
			route.remove(u);
		else
			System.err.println("Vector not in route. Cannot remove.");
	}
	
	public void pop() {
		if(route.size() > 0)
			route.remove(route.size() - 1);
	}
	
	public double distance() {
		double distance = 0;
		
		if(route.size() > 0) {
			distance += route.get(0).distance(start);
			
			for(int i = 1; i < route.size(); i++){
				distance += route.get(i).distance(route.get(i-1));
			}
		}
		
		return distance;
	}
	
}
