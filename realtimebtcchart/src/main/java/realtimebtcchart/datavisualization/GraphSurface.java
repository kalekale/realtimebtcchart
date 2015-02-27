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
    private double xScale = 10.0;
    private double yScale = -0.1;
    private int yOrigin = 0;
    private int yMiddle = 0;
    private ArrayList<GraphPart> parts;
    private int xOrigin = 0;
    
    public void setYorigin() {
        int yOrigin = graph.getFirstY();
        
        yOrigin = yOrigin/100;
        yOrigin = yOrigin * 100;
    }
    
    public void moveLeft() {
        xOrigin -= 1;
        System.out.println(xOrigin);
        paintComponent(getGraphics());
    }
    
    public void moveRight() {
        xOrigin += 1;
        paintComponent(getGraphics());
    }
    
    public GraphSurface(Graph graph) {
        parts = new ArrayList<>();
        this.graph = graph;
        Scheduler scheduler = new Scheduler(graph, this, 1);
    }
    
    public GraphSurface(Graph graph, int updateInterval) {
        parts = new ArrayList<>();
        this.graph = graph;
        Scheduler scheduler = new Scheduler(graph, this, updateInterval);
    }
    
    public double getXScale() {
        return this.xScale;
    }
    
    public int getYOrigin() {
        return this.yOrigin;
    }
    
    public double getYScale() {
        return this.yScale;
    }
    
    public int getXOrigin() {
        return xOrigin;
    }
    
    public void setXScale(double scale) {
        this.xScale = scale;
    }
    
    public void setXOrigin(int xOrigin) {
        this.xOrigin = xOrigin;
    }
    
    public void setYOrigin(int yOrigin) {
        this.yOrigin = yOrigin;
    }
    
    public void setYScale(double scale) {
        this.yScale = scale;
    }

    /**
     * Updated Graph for current time. Sets new yScale and or xScale if Graph
     * goes out of view.
     *
     */
    public void update() {
        graph.update(System.currentTimeMillis());
        parts = graph.getParts();
    }

    /**
     * Draws Graph on this.Graphics
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (parts.size() > 1) {
            setYorigin();
            Graphics2D g2d = (Graphics2D) g;
            g2d.translate(0, this.getHeight());
            g2d.setStroke(new BasicStroke(0.01f));
            super.paintComponent(g2d);
            graph.draw(g2d, yOrigin, xOrigin, yScale, xScale);
            drawYScale(g2d);
        }
    }

    public void drawYScale(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.black);
        for (double d = 0.1; d < 1; d += 0.1) {
            g2d.drawLine(0, (int)(-this.getHeight() * d),(int) this.getWidth()+xOrigin, (int)(-this.getHeight() * d));
            g2d.drawString(String.valueOf((yOrigin+this.getHeight()/yScale * -d)/100.0), 0, (int)(-this.getHeight() * d));
        }
    }

}
