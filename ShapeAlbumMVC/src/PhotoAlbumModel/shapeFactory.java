package PhotoAlbumModel;

/**
 * The type Shape factory.
 */
public class shapeFactory {


  /**
   * Instantiates a new Shape factory.
   */
  public shapeFactory() {

  }

  /**
   * Create shape shape.
   *
   * @param name   the name
   * @param type   the type
   * @param width  the width
   * @param height the height
   * @param r      the r
   * @param g      the g
   * @param b      the b
   * @return the shape
   * @throws IllegalArgumentException the illegal argument exception
   */
  public IShape createShape( String name, String type, int width, int height, int r, int g, int b)
  throws IllegalArgumentException {
    // if the type is rectangle make a new instance and pass the values in
    if (type.equals("rectangle")) {
      return new rectangle(name, width, height, r, g, b);
    }
    // if the type if oval make a new instance and pass the values in
    else if(type.equals("oval")) {
      return new oval(name, width, height, r, g, b);
    }
    else {
      throw new IllegalArgumentException("There are no such shapes! ");
    }

  }
}
