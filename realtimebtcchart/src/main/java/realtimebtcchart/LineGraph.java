
import java.awt.Graphics;
import java.awt.Graphics2D;

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

    public LineGraph() {
        
    }
    
    @Override
    public void draw(Graphics g) {
        g.drawLine(0, 0, 100, 100);
    }
    
    
    
}
