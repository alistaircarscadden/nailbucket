import static java.lang.Math.random;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import math.Vector;
import pathing.Route;
import pathing.RouteGenerator;
import pathing.routegen.ClosestRouteGenerator;
import pathing.routegen.RandomRouteGenerator;

@SuppressWarnings("serial")
public class Nailbucket extends JPanel {
	
	public int width, height, radius;
	public List<Vector> nails;
	public List<Route> routes;
	public Vector start;

	public Nailbucket() {
		radius = 200;
		width = height = radius * 2;
		nails = new ArrayList<Vector>();
		routes = new ArrayList<Route>();
		start = new Vector(width/2, height/2);
		
		JFrame frame = new JFrame();
		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setSize(width + 20, height + 40);
		setSize(width, height);
		frame.add(this);
		frame.setVisible(true);
		
		nails = getNewNails(10, radius, start);
		
		RouteGenerator rg;
		
		rg = new RandomRouteGenerator();
		Route random = new Route("Random", Color.WHITE, start);
		rg.generate(random, getNailsCopy());
		routes.add(random);
		
		rg = new ClosestRouteGenerator();
		Route closest = new Route("Closest", Color.YELLOW, start);
		rg.generate(closest, getNailsCopy());
		routes.add(closest);
		
		for(Route r : routes) {
			System.out.printf("%s: %d\n", r.name, (int) r.distance());
		}
		
		repaint();
	}
	
	public List<Vector> getNewNails(int numPts, double radius, Vector center) {
		List<Vector> newNails = new ArrayList<Vector>();
		
		while(newNails.size() < numPts) {
			Vector newNail = new Vector(random() * radius * 2 + center.x - radius,
										random() * radius * 2 + center.y - radius);
			
			if(newNail.distance(new Vector(center.x, center.y)) < radius) {
				System.out.printf("New nail at: (%d, %d)\n", (int) newNail.x, (int) newNail.y);
				newNails.add(newNail);
			}
		}
		
		return newNails;
	}
	
	public List<Vector> getNailsCopy() {
		List<Vector> nailsCopy = new ArrayList<Vector>();
		
		for(Vector u : nails)
			nailsCopy.add(u);
		
		return nailsCopy;
	}

	public static void main(String[] args) {
		new Nailbucket();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillOval(0, 0, radius * 2, radius * 2);
		
		for(Route route : routes) {
			g.setColor(route.color);
			Vector pos = new Vector(radius, radius);
			for(Vector u : route.route) {
				g.drawLine((int) pos.x, (int) pos.y, (int) u.x, (int) u.y);
				pos = u;
			}
		}
		
		g.setColor(Color.RED);
		for(Vector u : nails) {
			g.drawLine((int) u.x - 3, (int) u.y - 3, (int) u.x + 3, (int) u.y + 3);
			g.drawLine((int) u.x - 3, (int) u.y + 3, (int) u.x + 3, (int) u.y - 3);
		}
		
		g.setColor(Color.BLUE);
		g.drawLine((int) start.x - 3, (int) start.y - 3, (int) start.x + 3, (int) start.y + 3);
		g.drawLine((int) start.x - 3, (int) start.y + 3, (int) start.x + 3, (int) start.y - 3);
	}
	
}
