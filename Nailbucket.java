import static java.lang.Math.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import math.Vector;

@SuppressWarnings("serial")
public class Nailbucket extends JPanel {
	public int width, height, radius, numNails;
	public List<Vector> nails;

	public Nailbucket() {
		radius = 200;
		width = height = radius * 2;
		numNails = 30;
		nails = new CopyOnWriteArrayList<Vector>();
		
		JFrame frame = new JFrame();
		frame.setLayout(new BorderLayout());
		
		frame.setSize(width + 20, height + 40);
		setSize(width, height);
		frame.add(this);
		frame.setVisible(true);
		
		createNails(numNails);
	}
	
	public void createNails(int numPts) {
		while(nails.size() < numNails) {
			float x = (float) random() * width;
			float y = (float) random() * height;
			
			if(sqrt(pow(x, 2) + pow(y, 2)) < radius) {
				nails.add(new Vector(x + radius, y + radius));
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
		
		g.setColor(Color.RED);
		for(Vector u : nails) {
			g.drawLine((int) u.x - 3, (int) u.y - 3, (int) u.x + 3, (int) u.y + 3);
		}
	}
}
