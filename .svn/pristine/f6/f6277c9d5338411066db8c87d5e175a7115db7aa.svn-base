/*
 * Abstract2DTool.java
 * TCSS 305 - Assignment 5 Part B 
 */
package tools;
import draw.DrawnShape;
import java.awt.Shape;
import java.awt.event.MouseEvent;

/**
 * @author Erica Putsche 
 * @version 05/15/2013
 */
public abstract class Abstract2DTool extends AbstractTool {
  
  
  @Override
  public void mouseDragged(final MouseEvent the_event) {
    super.mouseDragged(the_event);
    getPanel().setTemp(drawShape());
    getPanel().repaint();
  }
  
  @Override
  public void mouseReleased(final MouseEvent the_event) {
    super.mouseReleased(the_event);
    getPanel().add(drawShape());
    getPanel().repaint();
  }
  
  /**
   * Builds a shape.
   * @param the_x The x coordinate of the top left corner of this shape.
   * @param the_y The y coordinate of the top left corner of this shape.
   * @param the_width The width of this shape.
   * @param the_height The height of this shape.
   * @return The shape.
   */
  protected abstract Shape buildShape(final double the_x, final double the_y, 
                           final double the_width, final double the_height);
  
  /** 
   * Draws a shape.
   * @return The drawn shape.
   */
  private DrawnShape drawShape() {
    final double x1 = super.getPoint1().getX();
    final double x2 = super.getPoint2().getX();
    final double y1 = super.getPoint1().getY();
    final double y2 = super.getPoint2().getY();
    final double width = Math.abs(x1 - x2);
    final double height = Math.abs(y1 - y2);
 // fourth quadrant rectangle
    Shape shape = buildShape(x1, y1, width, height);
    
    // first quadrant rectangle
    if (x1 - x2 <= 0 && y1 - y2 >= 0) {
      shape = buildShape(x1, y2, width, height);
    } 
    // second
    if (x1 - x2 >= 0 && y1 - y2 >= 0) {
      shape = buildShape(x2, y2, width, height);
    }
    // third
    if (x1 - x2 >= 0 && y1 - y2 <= 0) {
      shape = buildShape(x2, y1, width, height);
    }
    return new DrawnShape(shape, getPanel().getColor(), getPanel().getThickness());
  }
}
