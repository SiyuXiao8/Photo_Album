package PhotoAlbumModel;

/**
 * The class Point 2 d.
 */
public class point2D {
  private int x;
  private int y;

  /**
   * Instantiates a new Point 2 d.
   *
   * @param x the x
   * @param y the y
   */
  public point2D(int x, int y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Sets point.
   *
   * @param x the x
   * @param y the y
   */
  public void setPoint(int x, int y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Gets x.
   *
   * @return the x
   */
  public int getX() {
    return this.x;
  }

  /**
   * Gets y.
   *
   * @return the y
   */
  public int getY() {
    return this.y;
  }

  /**
   * toString method.
   * @return a formatted string
   */
  @Override
  public String toString() {
    return this.x + ", " + this.y;
  }
}
