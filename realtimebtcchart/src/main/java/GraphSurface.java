
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kallelehikoinen
 */
public class GraphSurface extends JPanel {
    
    private Graph graph;
    
    public GraphSurface(Graph graph) {
        this.graph = graph;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        graph.draw(g);
    }
    
}
