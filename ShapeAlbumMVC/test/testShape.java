import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import PhotoAlbumModel.IShape;
import PhotoAlbumModel.oval;
import PhotoAlbumModel.rectangle;

/**
 * The type Test shape.
 */
public class testShape {
  private IShape rectangle;
  private IShape oval;

  /**
   * Sets up.
   */
  @Before
  public void setUp() {
    rectangle = new rectangle("rectOne", 5,10,0,0,0);
    oval = new oval("OvalOne", 50, 100, 1, 1, 1);

  }

  /**
   * Test set width.
   */
  @Test
  public void testSetWidth() {
    rectangle.setWidth(10);
    assertEquals(10, rectangle.getWidth(), 0.01);

    oval.setWidth(1);
    assertEquals(1, oval.getWidth(),0.01);
  }

  /**
   * Test set height.
   */
  @Test
  public void testSetHeight() {
    rectangle.setHeight(100);
    assertEquals(100, rectangle.getHeight(), 0.01);

    oval.setHeight(88);
    assertEquals(88, oval.getHeight(),0.01);
  }

  /**
   * Test set color.
   */
  @Test
  public void testSetColor() {
    rectangle.setColor(100,10,1);
    assertEquals(100, rectangle.getColor().getR(),0.01);
    assertEquals(10, rectangle.getColor().getG(),0.01);
    assertEquals(1, rectangle.getColor().getB(),0.01);

    oval.setColor(1,10,100);
    assertEquals(100, rectangle.getColor().getR(),0.01);
    assertEquals(10, rectangle.getColor().getG(),0.01);
    assertEquals(1, rectangle.getColor().getB(),0.01);
  }

  /**
   * Test set point.
   */
  @Test
  public void testSetPoint() {
    rectangle.setPoint(1,1);
    assertEquals(1,rectangle.getPoint().getX(),0.01);
    assertEquals(1,rectangle.getPoint().getY(),0.01);

    oval.setPoint(22,33);
    assertEquals(22,oval.getPoint().getX(),0.01);
    assertEquals(33,oval.getPoint().getY(),0.01);
  }
}
