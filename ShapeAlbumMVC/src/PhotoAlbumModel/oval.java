package PhotoAlbumModel;

/**
 * The type Oval.
 */
public class oval implements IShape {
  private String name;
  private int XRadius;
  private int YRadius;
  private color rgb;
  private point2D point;

  /**
   * Instantiates a new Oval.
   *
   * @param name    the name
   * @param XRadius the x radius
   * @param YRadius the y radius
   * @param r       the r
   * @param g       the g
   * @param b       the b
   */
  public oval(String name, int XRadius, int YRadius, int r, int g, int b) {
    this.name = name;
    this.XRadius = XRadius;
    this.YRadius = YRadius;
    rgb = new color(r,g,b);
    point = new point2D(0,0);
  }

  /**
   * setWidth method.
   * @param XRadius the X radius you want to set the Oval to
   */
  @Override
  public void setWidth(int XRadius) {
    this.XRadius = XRadius;
  }

  /**
   * setHeight method.
   * @param YRadius the Y radius you want to set the oval to
   */
  @Override
  public void setHeight(int YRadius) {
    this.YRadius = YRadius;
  }

  /**
   * setColor method. Represents the color in RGB value.
   * @param r the r
   * @param g the g
   * @param b the b
   */
  @Override
  public void setColor(int r, int g, int b) {
    rgb.setColor(r, g, b);
  }

  /**
   * setPoint method.
   * @param x the x
   * @param y the y
   */
  @Override
  public void setPoint(int x, int y) {
    this.point = new point2D(x,y);
    //point.setPoint(x, y);
  }

  /**
   * getWidth method.
   * @return the x radius of the oval
   */
  @Override
  public int getWidth() {
    return this.XRadius;
  }

  /**
   * getHeight method.
   * @return the y radius of the oval
   */
  @Override
  public int getHeight() {
    return this.YRadius;
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
   * @return the point2D instnace of current class
   */
  @Override
  public point2D getPoint() {
    return this.point;
  }

  /**
   * clone method. For making a deep copy of the shapes without reference.
   * @return a deep copy of oval class
   * @throws CloneNotSupportedException
   */
  @Override
  public Object clone() throws CloneNotSupportedException {
    oval copy = new oval(this.name, this.XRadius, this.YRadius,
            this.rgb.getR(), this.rgb.getG(), this.rgb.getB());
    copy.point = this.point;
    return copy;
  }

  /**
   * getName method.
   * @return name giving to oval
   */
  @Override
  public String getName() {
    return this.name;
  }

  /**
   * getType method.
   * @return type of the current class which is oval
   */
  @Override
  public String getType() {
    return "oval";
  }

  /**
   * toString method.
   * @return a formatted string that contains all info of the class
   */
  @Override
  public String toString() {
    return "Name: " + this.name + "\n"
            + "Type: oval \n"
            + "Center: (" + point.getX() + "," + point.getY()
            + "), Width: " + this.XRadius + ", Height: " + this.YRadius + ", Color: ("
            + rgb.getR() + "," + rgb.getG() + "," + rgb.getB() + ")";
  }
}
