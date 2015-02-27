package realtimebtcchart.datavisualization;

import realtimebtcchart.dataproccessing.Statistics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kallelehikoinen
 */
public class LineGraph implements Graph {

    ArrayList<GraphPart> lines = new ArrayList();
    long previousUpdate = 0;
    Statistics stat;

    public LineGraph(Statistics stat) {
        Line l1 = new Line(0, 0, 0, 0);
        lines.add(l1);
        this.stat = stat;
    }

    public void update(long tradesUntil) {
        double lastClose = stat.close(previousUpdate, tradesUntil);
        previousUpdate = tradesUntil;
        GraphPart last = lines.get(lines.size() - 1);
        double y2 = lastClose;
        int x2 = lines.size();
        int x1 = last.getX2();
        double y1 = last.getY2() / 100.0;
        lines.add(new Line(x1, y1, x2, y2));
    }

    @Override
    public int getFirstY() {
        return lines.get(1).getY2();
    }

    @Override
    public double getLastX() {
        return lines.get(lines.size() - 1).getX2();
    }



    @Override
    public ArrayList<GraphPart> getParts() {
        return this.lines;
    }

    @Override
    public void draw(Graphics2D g2d, int yOrigin, int xOrigin, double yScale, double xScale) {
        for (GraphPart l : lines) {
            l.draw(g2d, yOrigin, xOrigin, yScale, xScale);
        }
    }


}
