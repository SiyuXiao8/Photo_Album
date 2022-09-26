package PhotoAlbumModel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * The type Photo album model.
 */
public class PhotoAlbumModel implements IPhotoAlbumModel {
  private List<IShape> album; // current list of shapes is stored
  private List<List<IShape>> snapshots; // list of list, store album
  private java.io.File file = new java.io.File("snapshot.txt");
  private List<String>  listSnap;
  private List<String> listDesc;

  /**
   * Instantiates a new Photo album model.
   */
  public PhotoAlbumModel( ) {
    album = new ArrayList<>();
    listSnap = new ArrayList<>();
    snapshots = new ArrayList<>();
    listDesc = new ArrayList<>();
  }

  /**
   * placeShape method. The first step, since you need to place the shape on the album first.
   * pass in the name of the shape you want to place and the xy position you want to place it at.
   * @param shape the shape
   * @param x     the x
   * @param y     the y
   */
  @Override
  public void placeShape(IShape shape, int x, int y) {
    shape.setPoint(x, y);
    album.add(shape);
  }

  /**
   * moveShape method. to move the XY position of the shape
   * @param name the shape
   * @param x     the x
   * @param y     the y
   * @throws Exception when you did not place any shape on the album
   */
  @Override
  public void moveShape(String name, int x, int y) {
    // get shape of the name
    Iterator<IShape> iterator = album.iterator();
    while (iterator.hasNext()) {
      // iterates through the album and check the name
      IShape shape = iterator.next();
      // if the name is the same then move that shape and change its xy based on input
      if (shape.getName().equals(name)) {
        int index = album.indexOf(shape);
        IShape element = album.get(index); // get that shape
        element.setPoint(x, y); // changes its x and y pos
        album.set(index, element); // update the shape info
      }
    }
  }

  /**
   * changeColor method. change the rgb color of the shape you wanted.
   * @param name the shape
   * @param r     the r
   * @param g     the g
   * @param b     the b
   */
  @Override
  public void changeColor(String name, int r, int g, int b) {
    Iterator<IShape> iterator = album.iterator();
    while(iterator.hasNext()) {
      IShape shape = iterator.next();
      if (shape.getName().equals(name)) {
        int index = album.indexOf(shape);
        IShape element = album.get(index);
        element.setColor(r, g, b);
        album.set(index, element);// update the shape info
      }
    }
  }

  /**
   * resizeShape method. change the width and height of the shape you want.
   * @param name  the shape
   * @param width  the width
   * @param height the height
   */
  @Override
  public void resizeShape(String name, int width, int height) {
    Iterator<IShape> iterator = album.iterator();
    while (iterator.hasNext()) {
      IShape shape = iterator.next();
      if (shape.getName().equals(name)) {
        int index = album.indexOf(shape);
        IShape element = album.get(index);
        element.setWidth(width);
        element.setHeight(height);
        album.set(index, element);// update the shape info
      }
    }
  }

  /**
   * removeShape method. remove the shape you specified from the album.
   * @param name the shape
   */
  @Override
  public void removeShape(String name) {
    Iterator<IShape> iterator = album.iterator();
    while (iterator.hasNext()) {
      IShape shape = iterator.next();
      if (shape.getName().equals(name)) {
        album.remove(shape);
      }
    }
  }

  /**
   * displayCurrentAlbum method. prints out the shape of the current album in the console to show.
   * @return a string that contains all the info for the shapes that is on the album
   */
  @Override
  public String displayCurrentAlbum() {
    Iterator<IShape> iterator = album.iterator();
    String output = "";
    // first iterator prints out the current album
    while (iterator.hasNext()) {
      System.out.println(iterator.next() + "\n");
    }
    // second iterator saves and return the current album as a string
    Iterator<IShape> iterator2 = album.iterator();
    while (iterator2.hasNext()) {
      output += iterator2.next() + "\n";
    }
    return output;
  }

  /**
   * resetAlbum method. remove everything on the album.
   */
  @Override
  public void resetAlbum() {
    album.clear();
  }

  /**
   * getListID method.
   * @return a list that contains all the ID's of the snapshots
   */
  @Override
  public List<String> getListID() {
    return listSnap;
  }

  /**
   * getListDesc method.
   * @return a list that contains all the description of the snapshots
   */
  @Override
  public List<String> getListDesc() {
    return listDesc;
  }


  /**
   * getSnapshot method.
   * @return a list of list that contains all the snapshot of the shapes
   */
  @Override
  public List<List<IShape>> getSnapshot() {
    return snapshots;
  }

  /**
   * listOfSnapshots method. Prints out all the snapshot's ID for viewing purpose.
   */
  @Override
  public void listOfSnapshots() {
    System.out.println("List of snapshots taken before rest: " + listSnap);
    System.out.println("list of desc: " + listDesc);
  }

  /**
   * snapshot method. Captures the current album, saves it to a list.
   * @param description the description
   * @throws Exception display exception
   */
  @Override
  public void snapshot(String description) throws Exception {
    Timestamp now = Timestamp.from(Instant.now());
    String snapShotID = now.toString();
    SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    listSnap.add(snapShotID); // add the snapshot IDs to a list
    listDesc.add(description); // add the description to a list

    List<IShape> copyAlbum = new ArrayList<>(); // copy the current album to a list
    Iterator<IShape> iterator1 = album.iterator();
    while (iterator1.hasNext()) {
      copyAlbum.add((IShape) iterator1.next().clone());
    }
    snapshots.add(copyAlbum); // store the current list of shapes to a list
    // need the ID and Description info
    FileWriter fw = new FileWriter(file, true);
    BufferedWriter bw = new BufferedWriter(fw);
    bw.write("Snapshot ID: " + now + "\n");
    bw.write("Timestamp: " + time.format(now) + "\n");
    bw.write("Description: "+ description + "\n");
    bw.write("Shape Information: \n");
    Iterator<IShape> iterator = album.iterator();
    while (iterator.hasNext()) {
      bw.write(iterator.next().toString());
      bw.write("\n");
      bw.newLine();
    }
    bw.close();
  }

  /**
   * displaySnapshot method. Prints out all the snapshot that was taken to the console for viewing.
   * @throws FileNotFoundException if file does not exist
   */
  @Override
  public void displaySnapshot() throws FileNotFoundException {
    System.out.println("Printing Snapshots");
    Scanner input = new Scanner(new File("snapshot.txt")); //taking input from txt file
    while (input.hasNextLine())
    {
      System.out.println(input.nextLine());
    }
  }

  /**
   * executeTxtCommands method. Takes the input txt file and runs the commands and returns.
   * instances of model that contains all snapshot information.
   * @param file the file
   * @return a instances of model that contains all useful information to make views
   * @throws Exception when file does not exists
   */
  public commandExecutor executeTxtCommands (File file) throws Exception {
    txtFileProcessor processor = new txtFileProcessor(new File(String.valueOf(file)));
    List<String> listOfCommands = processor.getCommandList();
    commandExecutor executor = new commandExecutor(listOfCommands);
    executor.execute();
    return executor;
  }
}
