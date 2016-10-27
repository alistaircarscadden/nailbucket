import static java.lang.Math.random;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import math.Vector;
import util.Route;

@SuppressWarnings("serial")
public class Nailbucket extends JPanel {
	public int width, height, radius, numNails;
	public List<Vector> nails;
	public List<Route> routes;

	public Nailbucket() {
		radius = 200;
		width = height = radius * 2;
		numNails = 30;
		nails = new ArrayList<Vector>();
		routes = new ArrayList<Route>();
		
		JFrame frame = new JFrame();
		frame.setLayout(new BorderLayout());
		
		frame.setSize(width + 20, height + 40);
		setSize(width, height);
		frame.add(this);
		frame.setVisible(true);
		
		createNails(numNails);
		
		/*
		 * CREATION OF ROUTE ALGORITHMS
		 */
		Route random = new Route(Color.WHITE, "Random") {
			public void generate(List<Vector> nails) {
				for(Vector nail : nails)
					route.add(nail);
			}
		};
		
		Route closest = new Route(Color.YELLOW, "Closest") {
			public void generate(List<Vector> nails) {
				List<Vector> tempNails = new ArrayList<Vector>();
				for(Vector u : nails)
					tempNails.add(u);
				Vector pos = new Vector(radius, radius);
				
				while(tempNails.size() > 0) {
					Vector closest = tempNails.get(0);
					for (Vector u : tempNails) {
						if (pos.distance(u) < pos.distance(closest))
							closest = u;
					}
					tempNails.remove(closest);
					pos = closest;
					route.add(closest);
				}
			}
		};
		
		random.generate(nails);
		closest.generate(nails);
		
		//routes.add(random);
		routes.add(closest);
		
		repaint();
	}
	
	public void createNails(int numPts) {
		while(nails.size() < numNails) {
			Vector newNail = new Vector(random() * radius * 2,
										random() * radius * 2);
			
			if(newNail.distance(new Vector(radius, radius)) < radius) {
				nails.add(newNail);
			}
		}
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
		g.drawLine((int) radius - 3, (int) radius - 3, (int) radius + 3, (int) radius + 3);
		g.drawLine((int) radius - 3, (int) radius + 3, (int) radius + 3, (int) radius - 3);
	}
}
