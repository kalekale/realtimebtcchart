package realtimebtcchart;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;


public interface Graph {
    
    void update(long tradesUntil);
    void draw(Graphics2D g, int xOffset, int yOffset);
    int getFirstY();
    ArrayList<GraphPart> getParts();

    public double getLastX();
    
}
