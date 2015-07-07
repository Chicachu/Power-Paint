/*
 * Line.java
 * TCSS 305 - Assignment 5 Part A
 */

package tools;

import draw.DrawnShape;

import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;

/**
 * Makes a line and adds it to it's drawing panel.
 * @author Erica Putsche
 * @version 05/15/2013
 */
public class Line extends AbstractTool {
  
  /**
   * Gets the end point for the line. 
   * @param the_event The mouse event.
   */
  @Override
  public void mouseReleased(final MouseEvent the_event) {
    super.mouseReleased(the_event);        
    getPanel().add(makeLine());
    getPanel().repaint();
  }
  
  @Override
  public void mouseDragged(final MouseEvent the_event) {
    super.mouseDragged(the_event);
    getPanel().setTemp(makeLine());
    getPanel().repaint();
  }
  
  /**
   * Makes a line.
   * @return A line.
   */
  private DrawnShape makeLine() {
    final Line2D.Double line = new Line2D.Double(getPoint1(), getPoint2());
    return new DrawnShape(line, getPanel().getColor(), getPanel().getThickness());
  }
}
