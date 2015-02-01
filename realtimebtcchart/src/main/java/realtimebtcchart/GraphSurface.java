package realtimebtcchart;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
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
    private ArrayList<GraphPart> parts;

    public GraphSurface(Graph graph) {
        parts = new ArrayList<GraphPart>();
        this.graph = graph;
        Scheduler scheduler = new Scheduler(graph, this);
        cs = new CoordinateSystem(this.getWidth(), this.getHeight(), xScale, yScale);

    }

    public void update() {
        graph.update(System.currentTimeMillis());
        parts = graph.getParts();
        if (parts.size() > 1) {
            System.out.println("y2: " + parts.get(1).getY2());
            yOrigin = (int) Math.round(parts.get(1).getY2() * 0.95);
            System.out.println(graph.getLastX() * xScale + " >= " + this.getWidth());
            if (graph.getLastX() * xScale >= this.getWidth()) {
                xScale = 0.9 * xScale;
                System.out.println("xScale: " + xScale);
            }
            if (parts.get(1).getY2() > this.getHeight()) {
                yScale = -getHeight() / (double) (((parts.get(1).getY2()-yOrigin)*2));
                System.out.println("yScale: " + yScale);
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        if (parts.size() > 1) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.translate(0, this.getHeight());
            g2d.setStroke(new BasicStroke(0.01f));
            g2d.scale(xScale, yScale);
            super.paintComponent(g2d);
            graph.draw(g2d, yOrigin, yOrigin);
        }
    }

}
