package tools;

import java.awt.geom.Ellipse2D;

/**
 * Listens to mouse input to draw Ellipse shapes.
 * @author Erica Putsche
 * @version 05/20/2013
 */
public class Ellipse extends Abstract2DTool {
  
  /**
   * Builds an ellipse shape.
   * @param the_x The first x coordinate.
   * @param the_y The first y coordinate.
   * @param the_width The width of the ellipse.
   * @param the_height The height of the ellipse.
   * @return The ellipse shape.
   */
  protected Ellipse2D.Double buildShape(final double the_x, final double the_y, 
                                          final double the_width, final double the_height) {
    return new Ellipse2D.Double(the_x, the_y, the_width, the_height);
  }
}

