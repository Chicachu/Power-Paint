/*
 * Pencil.java
 * TCSS 305 - Assignment 5 Part B
 */

package tools;

import draw.DrawnShape;

import java.awt.event.MouseEvent;
import java.awt.geom.GeneralPath;


/**
 * Adds pencil functionality by creating continuous lines.
 * @author Erica Putsche
 * @version 05/17/2013
 */
public class Pencil extends AbstractTool {
  
  /**
   * The General Path.
   */
  private GeneralPath my_path;
  
  @Override
  public void mousePressed(final MouseEvent the_event) {
    super.mousePressed(the_event);
    my_path = new GeneralPath();
    my_path.moveTo(getPoint1().getX(), getPoint1().getY());
  }

  @Override 
  public void mouseDragged(final MouseEvent the_event) {
    super.mouseDragged(the_event);
    my_path.lineTo(getPoint2().getX(), getPoint2().getY());
    final DrawnShape ds = 
        new DrawnShape(my_path, getPanel().getColor(), getPanel().getThickness());
    getPanel().setTemp(ds);
    getPanel().repaint();
  }
  
  @Override 
  public void mouseReleased(final MouseEvent the_event) {
    super.mouseReleased(the_event);
    my_path.lineTo(getPoint2().getX(), getPoint2().getY());
    final DrawnShape ds = 
        new DrawnShape(my_path, getPanel().getColor(), getPanel().getThickness());
    getPanel().add(ds);
    getPanel().repaint();
  }
} 
