package PhotoAlbumModel;

/**
 * The type Rectangle.
 */
public class rectangle implements IShape {
  private String name;
  private int width;
  private int height;
  private color rgb;
  private point2D point;

  /**
   * Instantiates a new Rectangle.
   *
   * @param name   the name
   * @param width  the width
   * @param height the height
   * @param r      the r
   * @param g      the g
   * @param b      the b
   */
  public rectangle (String name, int width, int height, int r, int g, int b) {
    this.name = name;
    this.width = width;
    this.height = height;
    this.rgb = new color(r,g,b);
    this.point = new point2D(0,0);
  }

  /**
   * setWidth class.
   * @param width the width you want to set the rectangle to
   */
  @Override
  public void setWidth(int width) {
    this.width = width;
  }

  /**
   * setHeight method.
   * @param height the height you want to set the rectangle to
   */
  @Override
  public void setHeight(int height) {
    this.height = height;
  }

  /**
   * setColor method. represents the color in RGB value.
   * @param r the r
   * @param g the g
   * @param b the b
   */
  @Override
  public void setColor(int r, int g, int b) {
    rgb.setColor(r, g, b);
  }

  /**
   * setPoint method. Initialize the x and y point to 0.
   */
  @Override
  public void setPoint(int x, int y) {
    this.point = new point2D(x, y);
  }

  /**
   * getWidth method.
   * @return the width of rectangle
   */
  @Override
  public int getWidth() {
    return this.width;
  }

  /**
   * getHeight method.
   * @return the height of the rectangle
   */
  @Override
  public int getHeight() {
    return this.height;
  }

  /**
   * getColor method.
   * @return the rgb instance of current class
   */
  @Override
  public color getColor() {
    return this.rgb;
  }
  /**
   * getPoint method.
   * @return the point2D instance of current class
   */
  @Override
  public point2D getPoint() {
    return this.point;
  }

  /**
   * toString method.
   * @return a formatted string that contains all the relevant info for rectangle class
   */
  @Override
  public String toString() {
    return "Name: " + this.name + "\n"
            + "Type: rectangle \n"
            + "Min corner: (" + point.getX() + "," + point.getY()
            + "), Width: " + this.width + ", Height: " + this.height + ", Color: ("
            + rgb.getR() + "," + rgb.getG() + "," + rgb.getB() + ")";
  }

  /**
   * clone method. To make deep copy of the shape.
   * @return a copy of the rectangle
   * @throws CloneNotSupportedException
   */
  @Override
  public Object clone() throws CloneNotSupportedException {
    rectangle copy = new rectangle(this.name, this.width, this.height,
            this.rgb.getR(), this.rgb.getG(), this.rgb.getB());
    copy.point = this.point;
    return copy;
  }

  /**
   * getName method.
   * @return the name of the rectangle
   */
  @Override
  public String getName() {
    return this.name;
  }

  /**
   * getType method.
   * @return the current type, which is rectangle
   */
  @Override
  public String getType() {
    return "rectangle";
  }


}
