import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import PhotoAlbumModel.PhotoAlbumModel;
import PhotoAlbumModel.commandExecutor;
import controllers.controller;
import views.WebView;

/**
 * The type Test html.
 */
public class testHTML {
  private File file;
  private PhotoAlbumModel model;
  private commandExecutor data;

  /**
   * Sets up.
   *
   * @throws Exception the exception
   */
  @Before
  public void setUp() throws Exception {
    file = new File("testWeb.txt");
    model = new PhotoAlbumModel();
    data = model.executeTxtCommands(file);
    WebView view = new WebView(data, "test.html"); // makes a html file
    controller viewController = new controller(model, view, data);
    viewController.goWeb();
  }

  /**
   * Test web view.
   *
   * @throws FileNotFoundException the file not found exception
   */
  @Test
  public void testWebView() throws FileNotFoundException {
    StringBuilder stringInHTML = new StringBuilder();
    StringBuilder expectedString = new StringBuilder();
    expectedString.append("<!DOCTYPE html> \n").append("<html> \n")
            .append("<body> \n")
            .append("<h1>cs5004 Shapes Photo Album HTML view</h1> \n")
            .append("<div>\n")
            .append("    <h3> Face of the Sun</h3>\n")
            .append("    <svg width=1000 height=1000>\n")
            .append("        <ellipse id=\"head\" cx=\"350\" cy=\"350\" rx=\"200\" ry=\"200\" fill=\"rgb(255,255,0)\">\n")
            .append("        </ellipse>\n")
            .append("        <rect id=\"brow1\" x=\"395\" y=\"390\" width=\"20\" height=\"10\" fill=\"rgb(0,0,0)\">\n")
            .append("        </rect>\n")
            .append("    </svg>\n")
            .append("</div>\n")
            .append("</body> \n")
            .append("</html>\n");
    Scanner input = new Scanner(new File("test.html"));
    while (input.hasNextLine()) {
      String sentence = input.nextLine();
      if (!sentence.contains("<h2>")) {
        stringInHTML.append(sentence+"\n");
      }
    }
    assertEquals(expectedString.toString(), stringInHTML.toString());
  }

}
