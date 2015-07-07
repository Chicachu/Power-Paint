/*
 * DrawnShape.java
 * TCSS 305 - Assignment 5 Part B
 */
package draw;

import java.awt.Color;
import java.awt.Shape;

/**
 * Represents a drawn shape object with a shape, color and thickness.
 * @author Erica Putsche
 * @version 05/20/2013
 */
public class DrawnShape {
  
  /**
   * The shape.
   */
  private final Shape my_shape; 
  
  /**
   * The color.
   */
  private final Color my_color;
  
  /**
   * The stroke.
   */
  private final float my_stroke;
  
  /**
   * Constructs a drawn shape.
   * @param the_shape The shape.
   * @param the_color The color.
   * @param the_stroke The stroke.
   */
  public DrawnShape(final Shape the_shape, final Color the_color, final float the_stroke) {
    my_shape = the_shape; 
    my_color = the_color; 
    my_stroke = the_stroke;
  }
  
  /**
   * Gets the shape.
   * @return The shape.
   */
  public Shape getShape() {
    return my_shape;
  }
  
  /**
   * Gets the color.
   * @return The color.
   */
  public Color getColor() {
    return my_color;
  }
  
  /**
   * Gets the stroke.
   * @return The stroke.
   */
  public float getStroke() {
    return my_stroke;
  }
}
