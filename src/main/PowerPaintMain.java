package main;
/*
 * TCSS 305 - Assignment 5 Part A 
 */

import gui.PowerPaintGUI;

/**
 * Runs PowerPaint by instantiating and starting the SnapShopGUI.
 * 
 * @author Erica Putsche
 * @version 05/09/2013
 */
public final class PowerPaintMain {
  
  /**
   * Private constructor, to prevent instantiation of this class.
   */
  private PowerPaintMain() {
    throw new IllegalStateException();
  }

  /**
   * The main method, invokes the SnapShop GUI. Command line arguments are
   * ignored.
   * 
   * @param the_args Command line arguments.
   */
  public static void main(final String[] the_args) {
    final PowerPaintGUI gui = new PowerPaintGUI();
    gui.start();
  }
}
