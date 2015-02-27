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
 * A Candle is a part of a LineGraph. A line is defined by its close value.
 *
 * @author kallelehikoinen
 */
public class Line implements GraphPart {

    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Line(int x1, double y1, int x2, double y2) {
        this.x1 = x1;
        this.y1 = (int) (y1 * 100);
        this.x2 = x2;
        this.y2 = (int) (y2 * 100);
    }

    @Override
    public String toString() {
        return "x1,y1: " + x1 + "," + y1 + " x2,y2: " + x2 + "," + y2;
    }

    public int getX2() {
        return x2;
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getY2() {
        return y2;
    }

    /**
     * Draws Line
     *
     * @param g2d Graphic2D object to draw on
     * @param yOrigin substracted from Line y values
     * @param xOrigin substracted from Line x values
     * @param yScale multiplier for Line y values
     * @param xScale multiplier for Line x values
     */
    @Override
    public void draw(Graphics2D g2d, int yOrigin, int xOrigin, double yScale, double xScale) {
        int scaledX1 = (int) ((x1 - xOrigin) * xScale);
        int scaledY1 = (int) ((y1 - yOrigin) * yScale);
        int scaledX2 = (int) ((x2 - xOrigin) * xScale);
        int scaledY2 = (int) ((y2 - yOrigin) * yScale);
        g2d.drawLine(scaledX1, scaledY1, scaledX2, scaledY2);
    }

}
