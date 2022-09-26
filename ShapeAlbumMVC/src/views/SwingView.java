package views;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

import PhotoAlbumModel.IShape;
import PhotoAlbumModel.commandExecutor;

/**
 * The type Swing view.
 */
public class SwingView extends JFrame {
  private int WIDTH = 0;
  private int HEIGHT = 0;
  private commandExecutor data;
  private List<String> timeID;
  private List<String> description;
  private List<List<IShape>> snapshots;
  private int count;
  private JPanel topPanel, centerPanel, botPanel;
  private JButton prev, select, next, quit;
  private List<IShape> snapshot;

  /**
   * Instantiates a new Swing view.
   *
   * @param data   the data
   * @param width  the width
   * @param height the height
   */
  public SwingView(commandExecutor data, int width, int height) {
    super();
    this.WIDTH = width;
    this.HEIGHT = height;
    this.data = data;
    timeID = this.data.getListID();
    description = this.data.getListDesc();
    snapshots = this.data.getSnapshot();

    setSize(WIDTH, HEIGHT);
    setTitle("cs5004 Shapes Photo Album Viewer");
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    setLayout(new BorderLayout(1,1));
    // top
    topPanel = new JPanel();
    topPanel.setBackground(Color.PINK);
    topPanel.setLayout(new GridLayout(2,1));
    JLabel ID = new JLabel();
    JLabel desc = new JLabel();
    ID.setText(timeID.get(0)); // displaying 0
    desc.setText(description.get(0));

    topPanel.add(ID);
    topPanel.add(desc);

    // middle
    snapshot = snapshots.get(count);
    centerPanel = new drawPanel(snapshot);

    // bot
    botPanel = new JPanel();
    botPanel.setBackground(Color.ORANGE);
    botPanel.setLayout(new GridLayout(1,4));

    // setting up buttons
    prev = new JButton("<< Prev <<");
    select = new JButton("^^ Select ^^");
    next = new JButton(">> Next >>");
    quit = new JButton("xx Quit xx");

    // adding button to actionCommands
    prev.setActionCommand("prev");
    select.setActionCommand("select");
    next.setActionCommand("next");
    quit.setActionCommand("quit");

    // add buttons to the bottom panel
    botPanel.add(prev);
    botPanel.add(select);
    botPanel.add(next);
    botPanel.add(quit);

    // 3 different panel add to Jframe
    this.add(topPanel, BorderLayout.NORTH);
    this.add(centerPanel, BorderLayout.CENTER);
    this.add(botPanel, BorderLayout.SOUTH);
  }

  /**
   * Sets action listener.
   *
   * @param listener the listener
   */
// controller is the listener that waits for user to click on the button
  public void setActionListener(ActionListener listener) {
    prev.addActionListener(listener);
    select.addActionListener(listener);
    next.addActionListener(listener);
    quit.addActionListener(listener);
  }

  /**
   * Visible.
   *
   * @param value the value
   */
  public void Visible(boolean value) {
    this.setVisible(value);
  }

  /**
   * Sets count.
   *
   * @param value the value
   */
  public void setCount(int value) {
    this.count = value;
  }

  /**
   * Gets count.
   *
   * @return the count
   */
  public int getCount() {
    return this.count;
  }

  /**
   * Repaint center panel.
   */
  public void repaintCenterPanel() {

    try {
      snapshot = snapshots.get(count);
      centerPanel.revalidate(); // reset the center panel, for new drawing
      centerPanel = new drawPanel(snapshot); // gets a new album of shapes
      topPanel = new JPanel(); // gets new id and desc
      topPanel.setBackground(Color.PINK);
      topPanel.setLayout(new GridLayout(2, 1));
      JLabel ID = new JLabel();
      JLabel desc = new JLabel();
      ID.setText(timeID.get(count)); // displaying ID and desc according to index
      desc.setText(description.get(count));
      topPanel.add(ID);
      topPanel.add(desc);

      // add the modified top and center panel
      this.add(centerPanel, BorderLayout.CENTER);
      this.add(topPanel, BorderLayout.NORTH);
    } catch (Exception e) {
      //dialog showing out of range
      JOptionPane.showMessageDialog(this,"Out of bound!");

    }
  }

  /**
   * User select.
   */
  public void userSelect() {
    Object [] options = timeID.toArray();
    Object choice = JOptionPane.showInputDialog(this,"Choose", "Menu",
            JOptionPane.INFORMATION_MESSAGE,null,options,options[0]);
    int index = timeID.indexOf(choice);
    this.count = index;
    repaintCenterPanel();
  }
}
