/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package realtimebtcchart.datavisualization;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

/**
 *
 * @author kallelehikoinen
 */
public class LineTest {

    Line line1;
    Line line2;

    public LineTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        line1 = new Line(0, 0, 1, 1);
        line2 = new Line(0, 0, 0, 0);
    }

    @Test
    public void toStringTest() {
        assertTrue(line1.toString().equals("x1,y1: 0,0 x2,y2: 1,100"));
    }

    @Test
    public void getX1() {
        assertTrue(line1.getX1() == 0);
    }

    @Test
    public void getX2() {
        assertTrue(line1.getX1() == 0);
    }

    @Test
    public void getY1() {
        assertTrue(line1.getX1() == 0);
    }

    @Test
    public void getY2() {
        assertTrue(line1.getX1() == 0);
    }

    @Test
    public void drawTest() {

        Graphics gMock = Mockito.mock(Graphics2D.class);
        int x1 = -1;
        int y1 = -1;
        int x2 = 0;
        int y2 = 99;
        line1.draw((Graphics2D) gMock, 1, 1, 1, 1);
        Mockito.verify(gMock).drawLine(x1, y1, x2, y2);
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
