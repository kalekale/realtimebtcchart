package realtimebtcchart;


import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kallelehikoinen
 */
public class UI extends JFrame {
    
    public UI(Statistics stat) {
        this.add(new GraphSurface(new LineGraph(stat)));
        this.setSize(600, 480);
        this.setTitle("Live Bitcoin Chart");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    
}
