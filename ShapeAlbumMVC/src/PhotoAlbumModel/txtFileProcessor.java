package PhotoAlbumModel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The type Txt file processor.
 */
public class txtFileProcessor {
  private List<String> commands;

  /**
   * Instantiates a new Txt file processor.
   *
   * @param input the input
   * @throws FileNotFoundException the file not found exception
   */
  public txtFileProcessor(File input) throws FileNotFoundException {
    commands = new ArrayList<>();
    Scanner scan = new Scanner(input);
    while (scan.hasNext()) {
      String one = scan.nextLine();
      // do not include the lines that are empty or includes #
      if (!one.contains("#") && !one.equals("")) {
        // add the command lines to a list
        commands.add(one);
      }
    }

  }

  /**
   * Gets command list.
   *
   * @return the command list
   */
  public List<String> getCommandList() {
    return commands;
  }

}
