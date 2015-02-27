/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package realtimebtcchart.datavisualization;

import realtimebtcchart.datavisualization.ScheduledUpdate;
import realtimebtcchart.datavisualization.GraphSurface;
import realtimebtcchart.datavisualization.Graph;
import java.util.Timer;

/**
 * Creates a ScheduledUpdate.
 *
 * @author kallelehikoinen
 */
public class Scheduler {

    public Scheduler(Graph graph, GraphSurface gs, int updateInterval) {
        Timer timer = new Timer();
        timer.schedule(new ScheduledUpdate(graph, gs), updateInterval * 60000, updateInterval * 60000);
    }

}
