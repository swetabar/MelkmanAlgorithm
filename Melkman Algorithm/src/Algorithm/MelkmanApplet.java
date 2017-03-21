package Algorithm;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class MelkmanApplet extends Applet implements MouseListener {

	private static final long serialVersionUID = 1L;

	private final ArrayList<Point> points = new ArrayList<Point>();

	private ArrayList<Point> melkmanPoints = null;

	MelkmanAlgorithm mAlgo = new MelkmanAlgorithm();

	@Override
	public void init() {
		this.resize(800, 800);
		this.addMouseListener(this);
	}

	private void drawPoints(final Graphics g) {
		g.setColor(Color.WHITE);
		for (int i = 0; i < this.points.size(); i++)
			g.fillOval(this.points.get(i).x - 3, this.points.get(i).y - 3, 6, 6);
	}

	private void drawLine(final Graphics g) {
		g.setColor(Color.MAGENTA);
		for (int i = 0; i < this.points.size() - 1; i++)
			g.drawLine(this.points.get(i).x, this.points.get(i).y,
					this.points.get(i + 1).x, this.points.get(i + 1).y);
	}

	private void drawHullLine(final Graphics g) {
		if (this.melkmanPoints == null)
			return;
		g.setColor(Color.GREEN);
		for (int i = 0; i < this.melkmanPoints.size() - 1; i++)
			g.drawLine(this.melkmanPoints.get(i).x,
					this.melkmanPoints.get(i).y,
					this.melkmanPoints.get(i + 1).x,
					this.melkmanPoints.get(i + 1).y);
	}

	@Override
	public void paint(final Graphics g) {
		this.setBackground(Color.BLACK);
		this.drawPoints(g);
		this.drawLine(g);
		this.drawHullLine(g);
	}

	@Override
	public void mouseClicked(final MouseEvent arg0) {
		// TODO Auto-generated method stub
		this.points.add(new Point(arg0.getX(), arg0.getY()));
		if (this.points.size() >= 3)
			this.melkmanPoints = this.mAlgo.returnConvexHull(this.points);
		this.repaint();

	}

	@Override
	public void mouseEntered(final MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(final MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(final MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(final MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
