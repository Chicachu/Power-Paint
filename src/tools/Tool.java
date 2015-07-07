/*
 * TCSS 305 - Assignment 5 Part A
 */

package tools;

import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputAdapter;

public abstract class Tool extends MouseInputAdapter {
  private Point my_point1; 
  /**
   * Gets the start point for the line.
   */
  @Override
  public void mousePressed(final MouseEvent the_event) {
    // point gets anchored.
    my_point1 = the_event.getPoint();
  }
  
  public void setPoint1(Point the_point1) {
    my_point1 = the_point1;
  }
  
  public Point getPoint1() {
    return my_point1;
  }
}
