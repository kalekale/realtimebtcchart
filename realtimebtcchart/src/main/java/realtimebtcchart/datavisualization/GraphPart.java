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
 * GraphPart interface. A graph consists of GraphParts that can be drawn on a
 * Graphics object
 *
 * @author kallelehikoinen
 */
public interface GraphPart {

    public int getX2();

    public int getY2();

    /**
     * Draws the GraphPart on the Graphics given as param
     *
     * @param g Graphics to draw GraphPart on
     * @param xOffset value substracted from GraphPart x values
     * @param yOffset value substracted from GraphPart y values
     * @param xScale multiplier for GraphPart x values
     * @param yScale multiplier for GraphPart y values
     *
     */
    public void draw(Graphics2D g2d, int yOrigin, int xOrigin, double yScale, double xScale);

}
