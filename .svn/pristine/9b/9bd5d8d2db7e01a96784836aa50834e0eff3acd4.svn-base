package draw;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.JPanel;

/**
 * Represents a drawing panel.
 * @author Erica Putsche
 * @version 05/20/2013
 */
@SuppressWarnings("serial")
public class DrawingPanel extends JPanel {

  /** 
   * The grid of lines.
   */
  private static List<Line2D.Double> my_grid;
  
  /**
   * Spacing size of the grid.
   */
  private static final int GRID_SPACING = 20;
  
  /**
   * The shapes already drawn on the panel.
   */
  private final Stack<DrawnShape> my_drawn_shapes;
  
  /**
   * The shapes that have been undone.
   */
  private final Stack<DrawnShape> my_undo_shapes;
  
  /**
   * The current color.
   */
  private Color my_current_color;
  
  /**
   * The current thickness.
   */
  private float my_current_thickness;
  
  /** 
   * A temporary shape used in creating the hover effect as a shape is drawn.
   */
  private DrawnShape my_hover_shape;
  
  /**
   * Whether the grid is on or off.
   */
  private boolean my_grid_on; 
  
  /**
   * Constructs a drawing panel.
   */
  public DrawingPanel() {
    super();
    this.setBackground(Color.white);
    my_drawn_shapes = new Stack<>();
    my_grid = new ArrayList<>();
    my_undo_shapes = new Stack<>();
  }
  
  @Override
  public void paintComponent(final Graphics the_graphics) {
    super.paintComponent(the_graphics);
    final Graphics2D g2d = (Graphics2D) the_graphics;
    if (my_drawn_shapes != null) {
      for (DrawnShape s : my_drawn_shapes) {
        g2d.setColor(s.getColor());
        g2d.setStroke(new BasicStroke(s.getStroke()));
        g2d.draw(s.getShape());
      }
    }

    if (my_hover_shape != null) {
      g2d.setColor(my_hover_shape.getColor());
      g2d.setStroke(new BasicStroke(my_hover_shape.getStroke()));
      g2d.draw(my_hover_shape.getShape());
    }

    if (my_grid_on) {
      g2d.setColor(Color.GRAY);
      g2d.setStroke(new BasicStroke(1));
      for (Line2D.Double line : my_grid) {
        g2d.draw(line);
      }
    }
  }
  
  /** 
   * Sets the thickness. 
   * @param the_thickness The thickness.
   */
  public void setThickness(final float the_thickness) {
    my_current_thickness = the_thickness;
  }
  
  /**
   * Gets the thickness.
   * @return The thickness.
   */
  public float getThickness() {
    return my_current_thickness;
  }
  
  /** 
   * Sets the color.
   * @param the_color The color.
   */
  public void setColor(final Color the_color) {
    my_current_color = the_color;
  }
  
  /** 
   * Gets the color.
   * @return The color.
   */
  public Color getColor() {
    return my_current_color;
  }
  
  /**
   * Sets a temporary shape, used for the hover effect before mouse release.
   * @param the_shape The temporary shape to be drawn.
   */
  public void setTemp(final DrawnShape the_shape) {
    my_hover_shape = the_shape;
  }
  
  /** 
   * Gets the temporary shape, used for the hover effect before mouse release.
   * @return The temporary shape.
   */
  public DrawnShape getTemp() {
    return my_hover_shape;
  }
  
  /**
   * Adds a shape to the drawn shapes array.
   * @param the_shape The shape.
   */
  public void add(final DrawnShape the_shape) {
    my_drawn_shapes.push(the_shape);
  }
  
  /**
   * Undos the last thing drawn to the panel.
   */
  public void undo() {
    if (my_drawn_shapes != null) {
      my_undo_shapes.push(my_drawn_shapes.pop());
    }
    repaint();
  }
  
  /**
   * Clears the hover shape.
   */
  public void resetHoverShape() {
    my_hover_shape = null;
  }
  
  /**
   * Redraws the last thing undone from the panel.
   */
  public void redo() {
    if (my_undo_shapes != null) {
      my_drawn_shapes.push(my_undo_shapes.pop());
    }
    repaint();
  }
  
  /**
   * Gets the number of shapes drawn on the panel.
   * @return The number of shapes drawn on the panel.
   */
  public int getNumberOfShapesOnPanel() {
    return my_drawn_shapes.size();
  }
  
  /**
   * Gets the number of shapes most recently undone.
   * @return The number of shapes most recently undone.
   */
  public int getNumberOfUndoShapes() {
    return my_undo_shapes.size();
  }
  
  /**
   * Clears the undo shapes.
   */
  public void resetUndoShapes() {
    my_undo_shapes.clear();
  }
  
  /**
   * Toggles the grid on and off.
   */
  public void toggleGrid() {
    my_grid_on = !my_grid_on;
    drawGrid();
  }
  
  /**
   * Creates the lines that make up the grid.
   */
  private void drawGrid() {
    Line2D.Double line; 
    // vertical lines
    for (int i = GRID_SPACING; i < this.getWidth(); i += GRID_SPACING) {
      line = new Line2D.Double((double) i, 0, (double) i, this.getHeight());
      my_grid.add(line);
    }
    
    // horizontal lines
    for (int i = GRID_SPACING; i < this.getHeight(); i += GRID_SPACING) {
      line = new Line2D.Double(0, (double) i, this.getWidth(), (double) i);
      my_grid.add(line);
    }
  }
  
  /** 
   * Clears the drawing panel of everything that has been drawn onto it.
   */
  public void clear() {
    my_drawn_shapes.clear();
    my_hover_shape = null;
    this.repaint();
  }
}
