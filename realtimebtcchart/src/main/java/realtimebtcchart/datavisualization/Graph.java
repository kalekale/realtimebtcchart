package realtimebtcchart.datavisualization;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;


public interface Graph {
    
    void update(long tradesUntil);
    int getFirstY();
    ArrayList<GraphPart> getParts();

    public double getLastX();

    public void draw(Graphics2D g2d, int yOrigin, int xOrigin, double yScale, double xScale);
    
    
}
