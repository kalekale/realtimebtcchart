package realtimebtcchart;

import realtimebtcchart.ui.UI;
import realtimebtcchart.dataproccessing.BtcChina;
import realtimebtcchart.dataproccessing.Statistics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kallelehikoinen
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BtcChina btcna = new BtcChina();
        Statistics stat = new Statistics(btcna);
        btcna.connect();
        UI kayttis = new UI(stat);
    }
}
