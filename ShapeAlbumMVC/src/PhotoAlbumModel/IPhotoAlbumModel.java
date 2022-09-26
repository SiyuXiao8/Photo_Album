package PhotoAlbumModel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * The interface Photo album model.
 */
public interface IPhotoAlbumModel {
  /**
   * Place shape.
   *
   * @param shape the shape
   * @param x     the x
   * @param y     the y
   */
// first step. you need to put the shape on the album
  void placeShape(IShape shape, int x, int y);

  /**
   * Move shape.
   *
   * @param name the shape
   * @param x    the x
   * @param y    the y
   * @throws Exception the exception
   */
  void moveShape(String name, int x, int y) throws Exception;

  /**
   * Change color.
   *
   * @param name the shape
   * @param r    the r
   * @param g    the g
   * @param b    the b
   */
  void changeColor(String name, int r, int g, int b);

  /**
   * Resize shape.
   *
   * @param name   the shape
   * @param width  the width
   * @param height the height
   */
  void resizeShape(String name, int width, int height);

  /**
   * Remove shape.
   *
   * @param name the shape
   */
  void removeShape(String name);

  /**
   * Display current album string.
   *
   * @return the string
   */
  String displayCurrentAlbum(); // print current shapes in the list/ "album", return it as a string

  /**
   * Snapshot.
   *
   * @param description the description
   * @throws Exception the exception
   */
  void snapshot(String description) throws Exception; // overload, can pass optional description if wanted

  /**
   * List of snapshots.
   */
  void listOfSnapshots(); // display snapshot IDs, add to list then print it out "display"

  /**
   * Display snapshot.
   *
   * @throws FileNotFoundException the file not found exception
   */
  void displaySnapshot() throws FileNotFoundException; // read everything from the file

  /**
   * Reset album.
   */
  void resetAlbum();

  /**
   * Execute txt commands command executor.
   *
   * @param file the file
   * @return the command executor
   * @throws Exception the exception
   */
  commandExecutor executeTxtCommands (File file) throws Exception;

  /**
   * Gets list id.
   *
   * @return the list id
   */
  List<String> getListID();

  /**
   * Gets list desc.
   *
   * @return the list desc
   */
  List<String> getListDesc();

  /**
   * Gets snapshot.
   *
   * @return the snapshot
   */
  List<List<IShape>> getSnapshot();
}
