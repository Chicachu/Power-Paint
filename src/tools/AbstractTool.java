/*
 * AbstractTool.java
 * TCSS 305 - Assignment 5 Part A
 */

package tools;
import draw.DrawingPanel;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputAdapter;

/**
 * Retrieves information from the panel for the tools to use to do their job.
 * @author Erica Putsche
 * @version 05/15/2013
 */
public abstract class AbstractTool extends MouseInputAdapter {
  
  /**
   * The first point when a user presses mouse.
   */
  private Point my_point1; 
  
  /**
   * The second point when a user releases the mouse.
   */
  private Point my_point2;
  
  /**
   * The drawing panel for which these tools work.
   */
  private DrawingPanel my_panel;
  
  /**
   * Gets the start point for the line.
   * @param the_event The mouse event.
   */
  @Override
  public void mousePressed(final MouseEvent the_event) {
    // point gets anchored.
    my_point1 = the_event.getPoint();
    my_panel = (DrawingPanel) the_event.getSource();
    my_panel.resetUndoShapes();
  }
  
  @Override
  public void mouseDragged(final MouseEvent the_event) {
    my_point2 = the_event.getPoint();
  }
  
  @Override
  public void mouseReleased(final MouseEvent the_event) {
    my_point2 = the_event.getPoint();
    my_panel.resetHoverShape();
  }
  
  /** 
   * Gets the first point.
   * @return The first point.
   */
  public Point getPoint1() {
    return my_point1;
  }
  
  /**
   * Gets the second point.
   * @return The second point.
   */
  public Point getPoint2() {
    return my_point2;
  }
  
  /**
   * Gets the drawing panel.
   * @return The drawing panel.
   */
  public DrawingPanel getPanel() {
    return my_panel;
  }
}
