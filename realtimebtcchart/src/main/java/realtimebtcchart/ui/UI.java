package realtimebtcchart.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import realtimebtcchart.dataproccessing.Statistics;
import realtimebtcchart.datavisualization.CandlestickGraph;
import realtimebtcchart.datavisualization.GraphSurface;
import realtimebtcchart.datavisualization.LineGraph;

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

    private Statistics stat;
    private GraphSurface gs;
    private JButton left;
    private JButton right;

    public UI(Statistics stat) {
        this.stat = stat;
        this.setLayout(new FlowLayout());
        JComboBox graphDropDownMenu = graphDropDownMenu();
        this.add(graphDropDownMenu);
        JComboBox intervalDropDownMenu = timeIntervalDropDownMenu();
        this.add(intervalDropDownMenu);
        JButton startButton = startButton(graphDropDownMenu, intervalDropDownMenu);
        this.add(startButton);
        JButton stopButton = stopButton();
        this.add(stopButton);
        this.setSize(650, 600);
        this.setTitle("Live Bitcoin Chart");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public JComboBox graphDropDownMenu() {
        String[] graphNames = new String[]{"Line Graph", "Candelstick Graph"};
        JComboBox<String> comboGraph = new JComboBox<String>(graphNames);
        return comboGraph;
    }

    public JComboBox timeIntervalDropDownMenu() {
        String[] intervals = new String[]{"1 min", "3 min", "5 min", "10 min"};
        JComboBox<String> comboIntervals = new JComboBox<String>(intervals);
        return comboIntervals;
    }

    public JButton startButton(final JComboBox graph, final JComboBox time) {
        JButton button = new JButton("Start");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGraphSurface(graph, time);
            }
        });
        return button;
    }

    public JButton stopButton() {
        JButton button = new JButton("Stop");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeComponent(gs);
                removeComponent(left);
                removeComponent(right);
            }
        });
        return button;
    }

    private void startGraphSurface(JComboBox graph, JComboBox time) {
        System.out.println(time.getSelectedItem().toString());
        String timeString = time.getSelectedItem().toString().replaceAll("\\D", "");
        int interval = Integer.parseInt(timeString);
        gs = null;
        if (graph.getSelectedItem().equals("Line Graph")) {
            gs = new GraphSurface(new LineGraph(stat), interval);
        }
        if (graph.getSelectedItem().equals("Candelstick Graph")) {
            gs = new GraphSurface(new CandlestickGraph(stat), interval);
        }
        gs.setPreferredSize(new Dimension(600, 480));
        gs.setBackground(Color.white);
        gs.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        this.add(gs);
        left = (moveLeftButton());
        right = (moveRightButton());
        this.add(left);
        this.add(right);
        this.revalidate();
    }

    private void removeComponent(Component c) {
        remove(c);
        revalidate();
        repaint();
    }

    public JButton moveLeftButton() {
        JButton button = new JButton("Move Left");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gs.moveLeft();
            }
        });
        return button;
    }

    public JButton moveRightButton() {
        JButton button = new JButton("Move Right");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gs.moveRight();
            }
        });
        return button;
    }

}
