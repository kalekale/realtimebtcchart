package realtimebtcchart.datavisualization;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;


public interface Graph {
    
    void update(long tradesUntil);
    void draw(Graphics2D g, int xOffset, int yOffset);
    int getFirstY();
    ArrayList<GraphPart> getParts();

    public double getLastX();

    public void draw(Graphics2D g2d, int yOrigin, int xOrigin, double yScale, double xScale);
    
    public void newInterval(long interval, long until);
    
}
