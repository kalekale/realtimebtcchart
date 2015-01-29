package realtimebtcchart;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Timer;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kallelehikoinen
 */
public class GraphSurface extends JPanel {

    private Graph graph;
    private CoordinateSystem cs;
    private double xScale = 100.0;
    private double yScale = -0.01;
    private int yOrigin;
    private ArrayList<Line> lines;

    public GraphSurface(Graph graph) {
        lines = new ArrayList<Line>();
        this.graph = graph;
        Scheduler scheduler = new Scheduler(graph, this);
        cs = new CoordinateSystem(this.getWidth(), this.getHeight(), xScale, yScale);

    }

    public void update() {
        lines = graph.getLines();
        if (lines.size() > 1) {
            System.out.println("y2: " + lines.get(1).getY2());
            yOrigin = (int) Math.round(lines.get(1).getY2() * 0.9);
            System.out.println(graph.getLastX() * xScale + " >= " + this.getWidth());
            if (graph.getLastX() * xScale >= this.getWidth()) {
                xScale = 0.9 * xScale;
                System.out.println("xScale: " + xScale);
            }
            if (lines.get(1).getY2() > this.getHeight()) {
                yScale = -getHeight() / (double) Math.round(lines.get(1).getY2() / 10.0) / 2;
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        if (lines.size() > 1) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.translate(0, this.getHeight());
            g2d.setStroke(new BasicStroke(0.01f));
            g2d.scale(xScale, yScale);
            super.paintComponent(g2d);
            for (Line l : lines) {
                int x1 = l.getX1();
                int y1 = l.getY1() - yOrigin;
                int x2 = l.getX2();
                int y2 = l.getY2() - yOrigin;
                g2d.drawLine(x1, y1, x2, y2);
                System.out.println(x1 + ", " + y1 + ", " + x2 + ", " + y2);
            }
        }

    }

}
