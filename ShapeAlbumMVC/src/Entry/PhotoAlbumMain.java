package Entry;

import java.io.File;

import PhotoAlbumModel.PhotoAlbumModel;
import PhotoAlbumModel.commandExecutor;
import controllers.controller;
import views.SwingView;
import views.WebView;

/**
 * The type Photo album main.
 */
public class PhotoAlbumMain {

  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {

    String inputFileName = "";
    String outputFileName = "";
    boolean webView = false;
    boolean graphicalView = false;
    // width and height for storing canvas size for graphical view
    int width = 1000;
    int height = 1000;
    try {
      for (int i = 0; i < args.length; i++) {
        if (args[i].equals("-in")) {
          inputFileName = args[i + 1];
        }
        if (args[i].equals("-out")) {
          outputFileName = args[i + 1];
        }
        if (args[i].equals("-view") || args[i].equals("-v")) {
          if (args[i + 1].equals("web")) {
            webView = true;
          }
          if (args[i + 1].equals("graphical")) {
            graphicalView = true;
            try {
              if (args[i + 2] != null && args[i + 3] != null) {
                width = Integer.parseInt(args[i + 2]);
                height = Integer.parseInt(args[i + 3]);
              }
            } catch (Exception ignored) {}
          }
        }
      }

      // get the file name that is passing in from the args
      File file = new File(inputFileName);
      PhotoAlbumModel model = new PhotoAlbumModel();
      // pass it in to file, process the commands
      commandExecutor data = model.executeTxtCommands(file);
      // determine which view
      if (webView) {
        WebView view = new WebView(data, outputFileName);
        controller controller1 = new controller(model, view, data);
        controller1.goWeb();
      }
      if (graphicalView) {
        SwingView view = new SwingView(data, width, height);
        controller controller1 = new controller(model, view, data);
        controller1.goSwing();
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}