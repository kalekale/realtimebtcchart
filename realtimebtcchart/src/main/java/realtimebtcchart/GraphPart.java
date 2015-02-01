/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package realtimebtcchart;

import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *
 * @author kallelehikoinen
 */
public interface GraphPart{
    
    void draw(Graphics g, int xOffset, int yOffset);

    public int getX2();

    public int getY2();


    
}
