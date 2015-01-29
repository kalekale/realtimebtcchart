package realtimebtcchart;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;


public interface Graph {
    
    void update(long tradesUntil);
    void draw(Graphics g);
    int getFirstY();
    ArrayList<Line> getLines();

    public double getLastX();
    
}
