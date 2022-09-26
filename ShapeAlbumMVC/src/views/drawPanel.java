package views;

import java.awt.*;
import java.util.Iterator;
import java.util.List;

import javax.swing.*;

import PhotoAlbumModel.IShape;

/**
 * The type Draw panel.
 */
public class drawPanel extends JPanel {
  private List<IShape> snapshot;

  /**
   * Instantiates a new Draw panel.
   *
   * @param snapshot the snapshot
   */
  public drawPanel(List<IShape> snapshot) {
    this.snapshot = snapshot;

  }
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Iterator<IShape> iterator = snapshot.iterator(); // iterates through the list of shapes
    while(iterator.hasNext()) {
      IShape shape = iterator.next();
      // condition for rectangle, draw rectangle with the info giving in the snapshot list
      if (shape.getType().equals("rectangle")) {
        g.setColor(new Color(shape.getColor().getR(),
                             shape.getColor().getG(),
                             shape.getColor().getB()));
        g.drawRect(shape.getPoint().getX(), shape.getPoint().getY(),
                   shape.getWidth(), shape.getHeight());
        g.fillRect(shape.getPoint().getX(), shape.getPoint().getY(),
                shape.getWidth(), shape.getHeight());
      }
      // condition for oval, draw oval with the info giving in the snapshot list
      else if (shape.getType().equals("oval")) {
        g.setColor(new Color(shape.getColor().getR(),
                shape.getColor().getG(),
                shape.getColor().getB()));
        g.drawOval(shape.getPoint().getX(), shape.getPoint().getY(),
                shape.getWidth(), shape.getHeight());
        g.fillOval(shape.getPoint().getX(), shape.getPoint().getY(),
                shape.getWidth(), shape.getHeight());
      }
    }
  }
}
