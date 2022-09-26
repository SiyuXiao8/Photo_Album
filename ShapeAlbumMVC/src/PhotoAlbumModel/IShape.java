package PhotoAlbumModel;

/**
 * The interface Shape.
 */
public interface IShape extends Cloneable {
  /**
   * Sets width.
   *
   * @param width the width
   */
  void setWidth(int width);

  /**
   * Sets height.
   *
   * @param height the height
   */
  void setHeight(int height);

  /**
   * Sets color.
   *
   * @param r the r
   * @param g the g
   * @param b the b
   */
  void setColor(int r, int g, int b);

  /**
   * Sets point.
   *
   * @param x the x
   * @param y the y
   */
  void setPoint(int x, int y);

  /**
   * Gets width.
   *
   * @return the width
   */
  int getWidth();

  /**
   * Gets height.
   *
   * @return the height
   */
  int getHeight();

  /**
   * Gets color.
   *
   * @return the color
   */
  color getColor();

  /**
   * Gets point.
   *
   * @return the point
   */
  point2D getPoint();

  Object clone() throws CloneNotSupportedException;

  /**
   * Gets name.
   *
   * @return the name
   */
  String getName();

  /**
   * Gets type.
   *
   * @return the type
   */
  String getType();
}
