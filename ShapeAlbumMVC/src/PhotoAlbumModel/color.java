package PhotoAlbumModel;

/**
 * The Color class.
 */
public class color {
  private int r;
  private int g;
  private int b;

  /**
   * Instantiates a new Color.
   *
   * @param r the r
   * @param g the g
   * @param b the b
   */
  public color(int r, int g, int b) {
    this.r = r;
    this.g = g;
    this.b = b;

  }

  /**
   * Sets color.
   *
   * @param r the r
   * @param g the g
   * @param b the b
   */
  public void setColor(int r, int g, int b) {
    this.r = r;
    this.g = g;
    this.b = b;
  }

  /**
   * Gets r.
   *
   * @return the r
   */
  public int getR() {
    return this.r;
  }

  /**
   * Gets g.
   *
   * @return the g
   */
  public int getG() {
    return this.g;
  }

  /**
   * Gets b.
   *
   * @return the b
   */
  public int getB() {
    return this.b;
  }
}
