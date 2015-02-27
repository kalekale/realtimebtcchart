package realtimebtcchart.datavisualization;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 * Graph interface. A graph consists of GraphParts and can be drawn on a
 * Graphics object
 *
 * @author kallelehikoinen
 */
public interface Graph {

    /**
     * Creates new Candle for the time interval between lastUpdate and given
     * param
     *
     * @param tradesUntil updates Graph to given time.
     *
     *
     *
     */
    void update(long tradesUntil);

    int getFirstY();

    ArrayList<GraphPart> getParts();

    public double getLastX();

    /**
     * Draws the Graphs GraphParts on the Graphics given as param
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
