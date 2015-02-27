/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package realtimebtcchart.datavisualization;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
 *
 * @author kallelehikoinen
 */
public interface GraphPart{
    

    public int getX2();

    public int getY2();

    public void draw(Graphics2D g2d, int yOrigin, int xOrigin, double yScale, double xScale);


    
}
