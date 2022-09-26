import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import PhotoAlbumModel.txtFileProcessor;

/**
 * The type Test file processor.
 */
public class testFileProcessor {
  private List<String> commands;

  /**
   * Sets up.
   *
   * @throws FileNotFoundException the file not found exception
   */
  @Before
  public void setUp() throws FileNotFoundException {
    txtFileProcessor processor = new txtFileProcessor(new File("testWeb.txt"));
    commands = processor.getCommandList();
  }

  /**
   * Test processor.
   */
  @Test
  public void testProcessor() {
    List<String> expected = new ArrayList<>();
    expected.add("shape head oval 350 350 200 200 255 255 0");
    expected.add("shape brow1 rectangle 395 390 20 10 0 0 0");
    expected.add("snapshot Face of the Sun");
    assertEquals(expected, commands);
  }
}
