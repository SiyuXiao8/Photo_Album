package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import PhotoAlbumModel.commandExecutor;
import PhotoAlbumModel.PhotoAlbumModel;
import views.SwingView;
import views.WebView;


/**
 * The type Controller.
 */
public class controller implements ActionListener, IController{
  private PhotoAlbumModel model;
  private SwingView swingView;
  private WebView webView;
  private int count;
  private commandExecutor data;

  /**
   * Instantiates a new Controller.
   *
   * @param model     the model
   * @param swingView the swing view
   * @param data      the data
   */
// for swingView, overload
  public controller(PhotoAlbumModel model, SwingView swingView, commandExecutor data) { // takes the view also
    this.model = model;
    this.swingView = swingView;
    this.data = data;
    this.count = 0;
    this.swingView.setActionListener(this);

  }

  /**
   * Instantiates a new Controller.
   *
   * @param model the model
   * @param view  the view
   * @param data  the data
   */
// for webView, overload
  public controller(PhotoAlbumModel model, WebView view, commandExecutor data) {
    this.model = model;
    this.webView = view;
    this.data = data;
  }

  @Override
  public void goWeb() throws IOException {
    this.webView.makeHeader();
    this.webView.makeBody();
    this.webView.makeEnding();
  }

  @Override
  public void goSwing() {
    this.swingView.Visible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (count >= data.getSnapshot().size()) {
      count = data.getSnapshot().size() - 1; // set the current snapshot to the last snapshot
    }
    else if (count < 0) {
      count = 0;
    }
    switch(e.getActionCommand()) {
      // for prev button
      case "prev":
        count--; // decrement the count to show previous index album
        this.swingView.setCount(count);
        this.swingView.repaintCenterPanel();
        break;

      // for select button
      case "select":
        this.swingView.userSelect();
        this.count = this.swingView.getCount();
        break;

      // for next button
      case "next":
        count++; // increment the count to show next album in the list
        this.swingView.setCount(count);
        this.swingView.repaintCenterPanel();
        break;

      // for quit button
      case "quit":
        System.exit(0);
        break;
    }
  }
}
