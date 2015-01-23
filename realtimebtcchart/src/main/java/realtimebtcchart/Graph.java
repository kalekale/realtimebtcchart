package realtimebtcchart;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;


public interface Graph {
    
    ArrayList<Graphics2D> parts = new ArrayList();
    
    void draw(Graphics g);
    
}
