package views;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import PhotoAlbumModel.IShape;
import PhotoAlbumModel.commandExecutor;

/**
 * The type Web view.
 */
public class WebView {
  private java.io.File file;
  private commandExecutor data;
  private List<String> listID;
  private List<String> listDesc;
  private List<List<IShape>> snapshots;
  private int width;
  private int height;

  /**
   * Instantiates a new Web view.
   *
   * @param data           the data
   * @param outputFileName the output file name
   */
  public WebView(commandExecutor data, String outputFileName) {
    this.data = data;
    listID = this.data.getListID();
    listDesc = this.data.getListDesc();
    snapshots = this.data.getSnapshot();
    this.width = 1000;
    this.height = 1000;
    file = new java.io.File(outputFileName);

  }

  /**
   * Make header.
   *
   * @throws IOException the io exception
   */
  public void makeHeader() throws IOException {
    FileWriter fw = new FileWriter(file, true);
    BufferedWriter bw = new BufferedWriter(fw);
    bw.write("<!DOCTYPE html> \n");
    bw.write("<html> \n");
    bw.write("<body> \n");
    bw.write("<h1>cs5004 Shapes Photo Album HTML view</h1> \n");
    bw.close();
  }

  /**
   * Make body.
   *
   * @throws IOException the io exception
   */
  public void makeBody() throws IOException {
    StringBuilder string = new StringBuilder();
    int count = 0;
    for (List<IShape> list: snapshots) { // starting with first snapshot
      // add timeID and description as headings
      string.append("<div>\n"); // open div
      string.append("    <h2>").append(listID.get(count)).append("</h2>\n");
      string.append("    <h3>").append(listDesc.get(count)).append("</h3>\n");
      string.append("    <svg").append(" width=") // start drawing
              .append(this.width).append(" height=").append(this.height).append(">\n");
      count++;
      for (IShape each : list) {
        // condition for rectangle
        if (each.getType().equals("rectangle")) { // prints every single shape
          string.append("        <rect id=\"").append(each.getName()).append("\"")
                  .append(" x=\"").append(each.getPoint().getX()).append("\"")
                  .append(" y=\"").append(each.getPoint().getY()).append("\"")
                  .append(" width=\"").append(each.getWidth()).append("\"")
                  .append(" height=\"").append(each.getHeight()).append("\"")
                  .append(" fill=\"rgb(")
                  .append(each.getColor().getR()).append(",")
                  .append(each.getColor().getG()).append(",")
                  .append(each.getColor().getB()).append(")\">\n")
                  .append("        </rect>\n");
        }
        // condition for oval
        else if (each.getType().equals("oval")) { // prints every single shape
          string.append("        <ellipse id=\"").append(each.getName()).append("\"")
                  .append(" cx=\"").append(each.getPoint().getX()).append("\"")
                  .append(" cy=\"").append(each.getPoint().getY()).append("\"")
                  .append(" rx=\"").append(each.getWidth()).append("\"")
                  .append(" ry=\"").append(each.getHeight()).append("\"")
                  .append(" fill=\"rgb(")
                  .append(each.getColor().getR()).append(",")
                  .append(each.getColor().getG()).append(",")
                  .append(each.getColor().getB()).append(")\">\n")
                  .append("        </ellipse>\n");
        }
      }
        string.append("    </svg>\n"); // finish drawing
        string.append("</div>\n"); // close div


    }
    count = 0;
    // write the stringbuilder to the file
    FileWriter fw = new FileWriter(file, true);
    BufferedWriter bw = new BufferedWriter(fw);
    bw.write(String.valueOf(string));
    bw.close();
  }

  /**
   * Make ending.
   *
   * @throws IOException the io exception
   */
  public void makeEnding() throws IOException {
    FileWriter fw = new FileWriter(file, true);
    BufferedWriter bw = new BufferedWriter(fw);
    bw.write("</body> \n");
    bw.write("</html>");
    bw.close();
  }
}
