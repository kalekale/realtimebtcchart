package realtimebtcchart.datavisualization;

import realtimebtcchart.datavisualization.GraphSurface;
import realtimebtcchart.datavisualization.Graph;
import java.util.TimerTask;

/**
 * Updates GraphSurface.
 */
public class ScheduledUpdate extends TimerTask {

    Graph graph;
    GraphSurface graphSurface;

    public ScheduledUpdate(Graph graph, GraphSurface gs) {
        this.graph = graph;
        this.graphSurface = gs;
    }

    /**
     * Updates GraphSurface
     */
    @Override
    public void run() {
        graphSurface.update();
        graphSurface.repaint();
    }

}
