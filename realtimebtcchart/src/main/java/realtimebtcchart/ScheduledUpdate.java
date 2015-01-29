
package realtimebtcchart;

import java.util.TimerTask;

/**
 *
 * @author kallelehikoinen
 */
public class ScheduledUpdate extends TimerTask {

    Graph graph;
    GraphSurface graphSurface;
    
    public ScheduledUpdate(Graph graph, GraphSurface gs) {
        this.graph = graph;
        this.graphSurface = gs;
    }
    
    @Override
    public void run() {
        graph.update(System.currentTimeMillis());
        graphSurface.update();
        graphSurface.repaint();
    }
    
    
    
}
