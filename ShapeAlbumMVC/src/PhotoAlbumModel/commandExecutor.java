package PhotoAlbumModel;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * The type Command executor.
 */
public class commandExecutor {
  private List<String> commands;
  private PhotoAlbumModel model;
  private shapeFactory factory;

  /**
   * Instantiates a new Command executor.
   *
   * @param commands the commands
   */
  // make a instances of a model and execute the commands, have methods that returns useful
  // info like the ID list, desc list, album list
  public commandExecutor(List<String> commands)  { // takes in a list of commands
    this.commands = commands;
    model = new PhotoAlbumModel();
    factory = new shapeFactory();
  }

  /**
   * Execute.
   *
   * @throws Exception the exception
   */
  public void execute() throws Exception {
    Iterator<String> iterator = commands.iterator();
    while(iterator.hasNext()) { // iterate through list of strings
      String sentence = iterator.next(); // points to the command line
      Scanner word = new Scanner(sentence); // scan the command line
      String each = word.next(); // each is the words in the command line

      // if the command line has shape
      if (each.equals("shape")) {
        while (word.hasNext()) {
          String name = word.next();
          String type = word.next();
          int xpos = Integer.parseInt(word.next());
          int ypos = Integer.parseInt(word.next());
          int width = Integer.parseInt(word.next());
          int height = Integer.parseInt(word.next());
          int r = Integer.parseInt(word.next());
          int g = Integer.parseInt(word.next());
          int b = Integer.parseInt(word.next());
          IShape shape = factory.createShape(name,type,width,height,r,g,b); // shape is created
          model.placeShape(shape, xpos, ypos); // this shape is added to the album
        }
      }
      // if the command line has move
      else if (each.equals("move")) {
        while (word.hasNext()) {
          String name = word.next();
          int xpos = Integer.parseInt(word.next());
          int ypos = Integer.parseInt(word.next());
          model.moveShape(name, xpos, ypos);
        }
      }
      // if the command line has snapshot
      else if (each.equalsIgnoreCase("snapShot")) {
        String desc = "";
        while(word.hasNext()) {
          desc += " " + word.next();
        }
        model.snapshot(desc);
      }
      // if the command line has resize
      else if (each.equals("resize")) {
        String name = word.next();
        int width = Integer.parseInt(word.next());
        int height = Integer.parseInt(word.next());
        model.resizeShape(name, width,height);
      }
      // if the command line has color
      else if (each.equals("color")) {
        String name = word.next();
        int r = Integer.parseInt(word.next());
        int g = Integer.parseInt(word.next());
        int b = Integer.parseInt(word.next());
        model.changeColor(name, r, g, b);
      }
      // if the command line has remove
      else if (each.equals("remove")) {
        String name = word.next();
        model.removeShape(name);
      }
    }
  }

  /**
   * Gets list id.
   *
   * @return the list id
   */
  public List<String> getListID() {
    return model.getListID();
  }

  /**
   * Gets list desc.
   *
   * @return the list desc
   */
  public List<String> getListDesc() {
    return model.getListDesc();
  }

  /**
   * Gets snapshot.
   *
   * @return the snapshot
   */
  public List<List<IShape>> getSnapshot() {
    return model.getSnapshot();
  }
}
