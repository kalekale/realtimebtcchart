package realtimebtcchart.datavisualization;

import realtimebtcchart.datavisualization.GraphPart;
import realtimebtcchart.datavisualization.Graph;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 * Contains and draws a Graph. Class is updated periodically by time interval
 * specified in Scheduler
 *
 * @author kallelehikoinen
 */
public class GraphSurface extends JPanel {

    private Graph graph;
    private double xScale = 100.0;
    private double yScale = -0.01;
    private int yOrigin;
    private int yMiddle;
    private ArrayList<GraphPart> parts;

    public GraphSurface(Graph graph) {
        parts = new ArrayList<>();
        this.graph = graph;
        Scheduler scheduler = new Scheduler(graph, this);
    }
    
    public double getXScale() {
        return this.xScale;
    }
    
    public int getYMiddle() {
        return this.yMiddle;
    }
    
    public int getYOrigin() {
        return this.yOrigin;
    }
    
    public double getYScale() {
        return this.yScale;
    }

    /**
     * Updated Graph for current time. Sets new yScale and or xScale if Graph
     * goes out of view.
     *
     */
    public void update() {
        graph.update(System.currentTimeMillis());
        parts = graph.getParts();
        if (parts.size() > 1) {
            yMiddle = parts.get(1).getY2() / 100 * 100;
            yOrigin = (int) Math.round(yMiddle - 5000);
            if (graph.getLastX() * xScale >= this.getWidth()) {
                xScale = 0.9 * xScale;
            }
            if (parts.get(1).getY2() > this.getHeight()) {
                yScale = -getHeight() / (double) (((yMiddle - yOrigin) * 2));
            }
        }
    }

    /**
     * Draws Graph on this.Graphics
     */
    @Override
    public void paintComponent(Graphics g) {
        if (parts.size() > 1) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.translate(0, this.getHeight());
            g2d.setStroke(new BasicStroke(0.01f));
            g2d.scale(xScale, yScale);
            super.paintComponent(g2d);
            graph.draw(g2d, yOrigin, yOrigin);
            drawYScale(g2d);
        }
    }

    public void drawYScale(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.black);
        g2d.setStroke(new BasicStroke(0.005f));
        for (double d = 0.1; d < 1; d += 0.1) {
            g2d.drawLine(0, (int) ((-this.getHeight() / yScale) * d), 6, (int) ((-this.getHeight() / yScale) * d));
        }
    }

}
