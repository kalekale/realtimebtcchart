
package realtimebtcchart;

import java.awt.Graphics;
import javax.swing.JComponent;

public class CoordinateSystem extends JComponent {
    
    int xOrigin;
    int yOrigin;
    int xEnd;
    int yEnd;
    
    CoordinateSystem(int xEnd, int yEnd) {
        
    }

    CoordinateSystem(int width, int height, double xScale, double yScale) {
        System.out.println("xOrigin: " + width + " / " + xScale + "* 0.1");
        xOrigin = (int) (width / xScale - 0.9 * (width / xScale));
        yOrigin = (int) (height / yScale - 0.9 * height);
        System.out.println("xEnd: " + width + " / " + xScale);
        xEnd = (int) (width / xScale);
        yEnd = (int) (height / yScale);
    }
    
    
    
    @Override
    public void paintComponent(Graphics g) {
        g.drawLine(xOrigin, yOrigin, xEnd, yOrigin);
        g.drawLine(xOrigin, yOrigin, xOrigin, yEnd);
        System.out.println("xOrigin: " + xOrigin + " yOrigin: " + yOrigin + " xEnd: " + xEnd + " yEnd: " + yEnd);
    }
    
    
    
}
