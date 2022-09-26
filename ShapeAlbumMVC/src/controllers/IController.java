package controllers;

import java.io.IOException;

/**
 * The interface Controller.
 */
public interface IController {
  /**
   * Go web.
   *
   * @throws IOException the io exception
   */
  void goWeb() throws IOException;

  /**
   * Go swing.
   */
  void goSwing();
}
