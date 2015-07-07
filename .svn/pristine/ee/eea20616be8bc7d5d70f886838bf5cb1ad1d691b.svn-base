/*
 * TCSS 305 - Assignment 5 Part A
 */

package gui;
import draw.DrawingPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.event.MouseInputAdapter;


import tools.AbstractTool;

/**
 * Creates a GUI for PowerPaint that allows the user to draw and create shapes.
 * 
 * @author Erica Putsche
 * @version 05/09/2013
 */
@SuppressWarnings("serial")
public final class PowerPaintGUI extends JFrame {
  
  /** The Dimension of the screen. */
  private static final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
  
  /** The width of the screen. */ 
  private static final int SCREEN_WIDTH = SCREEN_SIZE.width;
  
  /** The height of the screen. */ 
  private static final int SCREEN_HEIGHT = SCREEN_SIZE.height;
  
  /** The default width of the drawing panel. */
  private static final int DEFAULT_WIDTH = 400;
  
  /** The default height of the drawing panel. */
  private static final int DEFAULT_HEIGHT = 300;
  
  /**
   * A constant for the string "Exit".
   */
  private static final String EXIT_STRING = "Exit";
  
  /**
   * A constant for the string "Clear".
   */
  private static final String CLEAR_STRING = "Clear";
  
  /**
   * A constant for the string "Grid".
   */
  private static final String GRID_STRING = "Grid";
  
  /**
   * A constant for the string "Thickness".
   */
  private static final String THICK_STRING = "Thickness";

  /**
   * Thickness options.
   */
  private static final int[] THICKNESS_OPTIONS = {1, 2, 4};

  /**
   * A constant for the string "Color".
   */
  private static final String COLOR_STRING = "Color...";
 
  /**
   * A constant for the string "About".
   */
  private static final String ABOUT_STRING = "About"; 
  
  /**
   * A constant for the string "Undo".
   */
  private static final String UNDO_STRING = "Undo"; 
  
  /**
   * A constant for the string "Redo".
   */
  private static final String REDO_STRING = "Redo";  
  
  /**
   * AbstractTool names.
   */
  private static final String[] TOOL_NAMES = {"Pencil", "Line", "Ellipse", "Rectangle"};
  
  /** 
   * My property change support tool.
   */
  private PropertyChangeSupport my_pcs; 
  
  /** The drawing panel. */
  private DrawingPanel my_drawing_panel;
  
  /** 
   * AbstractTool objects.
   */
  private List<AbstractTool> my_tools;
  
  /** 
   * All the actions.
   */
  private Map<String, Action> my_actions;
  
  /** 
   * Responsible for creating and displaying the GUI for PowerPaint.
   */
  public void start() {
    setupTools();
    setupActions();
    setupComponents();
  }
  
  /**
   * Sets up the GUI's components.
   */
  private void setupComponents() {
    setTitle("TCSS 305 PowerPaint - Spring 2013");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    my_drawing_panel = new DrawingPanel();
    my_pcs = new PropertyChangeSupport(this);
    addPropertyChangeListener(new ColorPropertyChangeListener());
    my_drawing_panel.setBackground(Color.white);
    my_drawing_panel.setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));

    setJMenuBar(createMenuBar());
    final JToolBar tool_bar = createToolBar();
    
    add(tool_bar, BorderLayout.SOUTH);
    add(my_drawing_panel, BorderLayout.CENTER);
    

    pack();
    setLocation();
    setVisible(true); 
  }
  
  /**
   * Adds a property change listener.
   * @param the_listener The property change listener.
   */
  public void addPropertyChangeListener(final PropertyChangeListener the_listener) {
    my_pcs.addPropertyChangeListener(the_listener);
  }
  
  /**
   * Removes a property change listener.
   * @param the_listener The property change listener.
   */
  public void removePropertyChangeListener(final PropertyChangeListener the_listener) {
    my_pcs.removePropertyChangeListener(the_listener);
  }
  
  /**
   * Sets up actions.
   */
  private void setupActions() {    
    my_actions = new HashMap<>();
    
    // exit action
    final Action exit_action = new AbstractAction(EXIT_STRING, new ImageIcon("./exit.gif")) {
      public void actionPerformed(final ActionEvent the_event) {
        dispose();
      }
    };
    exit_action.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_X);
    
    // clear action
    final Action clear_action = new AbstractAction(CLEAR_STRING) {
      public void actionPerformed(final ActionEvent the_event) {
        my_drawing_panel.clear();
      }
    };
    clear_action.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_C);
    
    // grid action
    final Action grid_action = new AbstractAction(GRID_STRING) {
      public void actionPerformed(final ActionEvent the_event) {
        my_drawing_panel.toggleGrid();
        my_drawing_panel.repaint();
      }
    };
    grid_action.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_G);
    
    // about action
    final Action about_action = new AbstractAction(ABOUT_STRING) {
      public void actionPerformed(final ActionEvent the_event) {
        JOptionPane.showMessageDialog(PowerPaintGUI.this, 
                                      "PowerPaint Pro TCSS 305 Spring 2013");
      }
    };
    about_action.putValue(Action.MNEMONIC_KEY,  KeyEvent.VK_A);
    
    final Action undo_action = new AbstractAction(UNDO_STRING) {
      public void actionPerformed(final ActionEvent the_event) {
        if (my_drawing_panel.getNumberOfShapesOnPanel() > 0) {
          my_drawing_panel.undo();
        }
      }
    };
    undo_action.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_U);
    
    final Action redo_action = new AbstractAction(REDO_STRING) {
      public void actionPerformed(final ActionEvent the_event) {
        if (my_drawing_panel.getNumberOfUndoShapes() > 0) {
          my_drawing_panel.redo();
        }
      }
    };
    redo_action.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_D);
    
    final Action color_action = new ColorAction(COLOR_STRING);
    color_action.addPropertyChangeListener(new ColorPropertyChangeListener());
    
    // sets up all tool actions.
    for (MouseInputAdapter t : my_tools) {
      final String name = t.getClass().getSimpleName();
      final ImageIcon icon = new ImageIcon("./" + name + ".gif");
      setupToolAction(name, icon, t);
    }
    
    my_actions.put(EXIT_STRING, exit_action);
    my_actions.put(CLEAR_STRING, clear_action);
    my_actions.put(GRID_STRING, grid_action);
    my_actions.put(COLOR_STRING, color_action);
    my_actions.put(ABOUT_STRING, about_action);
    my_actions.put(UNDO_STRING,  undo_action);
    my_actions.put(REDO_STRING,  redo_action);    
  }
  
  /**
   * Initializes the tool objects.
   */
  private void setupTools() {
    my_tools = new ArrayList<>();
    my_tools.add(new tools.Pencil());
    my_tools.add(new tools.Line());
    my_tools.add(new tools.Ellipse());
    my_tools.add(new tools.Rectangle());
  }
 
  /** 
   * Sets up the actions for the tools.
   * @param the_name The name of the tool.
   * @param the_icon The icon for the tool.
   * @param the_tool The tool object.
   */
  private void setupToolAction(final String the_name, final ImageIcon the_icon, 
                               final MouseInputAdapter the_tool) {
    
    final char first_char = the_name.charAt(0);
    
    final Action action = new AbstractAction(the_name, the_icon) {
      public void actionPerformed(final ActionEvent the_event) {
        final MouseListener[] listeners = my_drawing_panel.getMouseListeners();
        final MouseMotionListener[] motion_listeners = 
            my_drawing_panel.getMouseMotionListeners();
        
        for (MouseListener m : listeners) {
          my_drawing_panel.removeMouseListener(m);
        }
        for (MouseMotionListener m : motion_listeners) {
          my_drawing_panel.removeMouseMotionListener(m);
        }
        my_drawing_panel.addMouseListener(the_tool);
        my_drawing_panel.addMouseMotionListener(the_tool);
      }
    };
    action.putValue(Action.MNEMONIC_KEY, KeyEvent.getExtendedKeyCodeForChar(first_char));
    my_actions.put(the_name, action);
    
  }
  
  /**
   * Creates a menu bar with menu items.
   * @return A menu bar with menu items.
   */
  private JMenuBar createMenuBar() {
    final JMenuBar bar = new JMenuBar();
    
    // menus (File - clear, exit; Options - grid, thickness; 
      // Tools - color, pencil, line, rectangle, ellipse; Help - about;)
    final JMenu file_menu = createFileMenu();
    final JMenu options_menu = createOptionsMenu();
    final JMenu tools_menu = createToolsMenu();
    final JMenu help_menu = createHelpMenu();
    
    bar.add(file_menu); 
    bar.add(options_menu); 
    bar.add(tools_menu); 
    bar.add(help_menu); 
    
    bar.setOpaque(true);
    return bar;
  }
  
  /**
   * Creates a file menu.
   * @return The file menu.
   */
  private JMenu createFileMenu() {
    final JMenu file_menu = new JMenu("File");
    file_menu.setMnemonic(KeyEvent.VK_F);
    JMenuItem item = new JMenuItem(my_actions.get(CLEAR_STRING));
    file_menu.add(item);
    file_menu.addSeparator();
    item = new JMenuItem(my_actions.get(EXIT_STRING));
    file_menu.add(item);
    
    return file_menu;
  }
  
  /**
   * Creates an options menu.
   * @return The options menu.
   */
  private JMenu createOptionsMenu() {
    final JMenu options_menu = new JMenu("Options"); 
    options_menu.setMnemonic(KeyEvent.VK_O);
    final JCheckBoxMenuItem checkbox = new JCheckBoxMenuItem(my_actions.get(GRID_STRING));
    options_menu.add(checkbox); // grid
    final JMenu thickness_menu = createThicknessMenu();
    options_menu.add(thickness_menu);
    return options_menu;
  }
  
  /** 
   * Creates a menu for thickness options.
   * @return The menu for thickness options.
   */
  private JMenu createThicknessMenu() { 
    final JMenu thickness_menu = new JMenu(THICK_STRING);
    final ButtonGroup group = new ButtonGroup();
    
    for (int f : THICKNESS_OPTIONS) {
      final JRadioButtonMenuItem button = createThicknessOption(f);
      if (THICKNESS_OPTIONS[0] == f) {
        button.setSelected(true);
      }
      group.add(button);
      thickness_menu.add(button);
    }
    thickness_menu.setMnemonic(KeyEvent.VK_T);
    
    
    return thickness_menu;
  }
  
  /**
   * Creates a button for a thickness option.
   * @param the_number The level of thickness.
   * @return The thickness options.
   */
  private JRadioButtonMenuItem createThicknessOption(final int the_number) {
    final JRadioButtonMenuItem thickness_option = 
        new JRadioButtonMenuItem((int) the_number + "");
    final Action action = new AbstractAction(the_number + "") {
      public void actionPerformed(final ActionEvent the_event) {
        my_drawing_panel.setThickness(the_number);
      }
    };
    final String number = the_number + "";
    final char num = number.charAt(0);
    thickness_option.addActionListener(action);
    thickness_option.setMnemonic(num);
    return thickness_option;
  }
  
  /**
   * Creates a tools menu.
   * @return The tools menu.
   */
  private JMenu createToolsMenu() {
    final JMenu tools_menu = new JMenu("Tools"); 
    tools_menu.setMnemonic(KeyEvent.VK_T);
    
    tools_menu.add(my_actions.get(COLOR_STRING));
    tools_menu.addSeparator();
    final ButtonGroup group = new ButtonGroup();
    for (String s : TOOL_NAMES) {
      final JRadioButton jbutton = new JRadioButton(my_actions.get(s));
      if (TOOL_NAMES[0].equals(s)) { // set pencil to selected
        setMouseListeners(my_tools.get(0));
        jbutton.setSelected(true);
      }
      group.add(jbutton);
      tools_menu.add(jbutton);
    }
    tools_menu.setOpaque(true);
    
    return tools_menu;
  }
  
  /** 
   * Sets the tool mouse listeners to the drawing panel.
   * @param the_tool The tool.
   */
  private void setMouseListeners(final AbstractTool the_tool) {
    my_drawing_panel.addMouseListener(the_tool);
    my_drawing_panel.addMouseMotionListener(the_tool);
  }
   
  /**
   * Creates a help menu.
   * @return The help menu.
   */
  private JMenu createHelpMenu() {
    final JMenu help_menu = new JMenu("Help"); 
    help_menu.setMnemonic(KeyEvent.VK_H);
    help_menu.add(my_actions.get(ABOUT_STRING));
    
    return help_menu;
  }
  
  /**
   * Creates a tool bar.
   * @return The tool bar.
   */
  private JToolBar createToolBar() {
    final JToolBar tool_bar = new JToolBar(); 
    tool_bar.add(my_actions.get(COLOR_STRING));
    tool_bar.addSeparator();
    final ButtonGroup group = new ButtonGroup();
    for (String s : TOOL_NAMES) {
      final JToggleButton jbutton = new JToggleButton(my_actions.get(s));
      if (TOOL_NAMES[0].equals(s)) { // set pencil to selected.
        setMouseListeners(my_tools.get(0));
        jbutton.setSelected(true);
      }
      group.add(jbutton);
      tool_bar.add(jbutton);
    }
    
    tool_bar.add(my_actions.get(UNDO_STRING));
    tool_bar.add(my_actions.get(REDO_STRING));
    
    return tool_bar;
  }
  /**
   * Sets the center of the frame to the center of the screen.
   */
  private void setLocation() {
    setLocation(SCREEN_WIDTH / 2 - getWidth() / 2,
                SCREEN_HEIGHT / 2 - getHeight() / 2);
  }
  
  /**
   * Allows the user to pick and choose colors they want to use for drawing.
   * @author Erica Putsche
   * @version 05/20/2013
   */
  private class ColorAction extends AbstractAction {
    
    /**
     * The source.
     */
    private JComponent my_source;
    
    /** 
     * A constructor for a ColorAction.
     * @param the_name The name of the color action.
     */
    public ColorAction(final String the_name) {
      super(the_name);
    }
    
    /**
     * Sets the color to be used while drawing.
     * @param the_event The event.
     */
    public void actionPerformed(final ActionEvent the_event) {
      final Color color = JColorChooser.showDialog(null, "A Color Chooser", null);
      my_drawing_panel.setColor(color);
      my_source = (JComponent) the_event.getSource();
      my_source.setBackground(my_drawing_panel.getColor());
    }
  }
  
  /**
   * Changes the sources background color when the color is changed.
   * @author Erica Putsche
   * @version 05/20/2013
   */
  public class ColorPropertyChangeListener implements PropertyChangeListener {

    @Override
    public void propertyChange(final PropertyChangeEvent the_event) {
      //final Object source =  the_event.getSource();
      //source.changeBackground();
    }
    
  }
}
