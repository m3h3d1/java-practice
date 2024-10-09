package com.mehedi.javapractice.networking;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

class ImagePanel extends JPanel {
  private RealEstateViewer frame;
  public ImagePanel(RealEstateViewer parent) {
    frame = parent;
  }
  public void paintComponent(Graphics g) {
    if (frame.currentImage != null)
      g.drawImage(frame.currentImage, 0, 0, this);
  }
}
class RealEstateViewer extends JFrame implements ItemListener {
  public static final int WIDTH = 500, HEIGHT = 400;
  private final String dataFileURL = "https://raw.githubusercontent.com/ram8647/javajavajava/master/chptr15/real-estate-app-resources/homes.txt";
  private final String URLbase = "https://raw.githubusercontent.com/ram8647/javajavajava/master/chptr15/real-estate-app-resources/";
  private JTextArea display = new JTextArea(20, 20);

  private JComboBox<String> homeChoice = new JComboBox<String>();
  private ImagePanel imagePanel = new ImagePanel(this); // use the ImagePanel class
  public Image currentImage = null;

  public RealEstateViewer() {
    super("Home Viewer Application");
    homeChoice.addItemListener(this);
    this.getContentPane().add("North", homeChoice);
    this.getContentPane().add("East", display);
    this.getContentPane().add("Center", imagePanel);
    display.setLineWrap(true);
    initHomeChoices();
    showCurrentSelection();
  }

  private void initHomeChoices() {
    try {
      URL url = new URL(dataFileURL);
      BufferedReader data = new BufferedReader(new InputStreamReader(url.openStream()));
      String line = data.readLine();
      while (line != null) {
        homeChoice.addItem(line);
        line = data.readLine();
      }
      data.close();
    } catch (MalformedURLException e) {
      System.out.println("ERROR: " + e.getMessage());
    } catch (IOException e) {
      System.out.println("ERROR: " + e.getMessage());
    }
  }

  private void readTextIntoDisplay(URL url) throws IOException {
    BufferedReader data = new BufferedReader(new InputStreamReader(url.openStream()));
    display.setText(""); // Reset the text area
    String line = data.readLine();
    while (line != null) { // Read each line
      display.append(line + "\n"); // And add it to the display
      line = data.readLine();
    }
    data.close();
  }

  private void showCurrentSelection() {
    String choice = homeChoice.getSelectedItem().toString();
    try {
      URL url = new URL(URLbase + choice + ".txt"); // Create URL

      readTextIntoDisplay(url); // Download and display text file
      url = new URL(URLbase + choice + ".jpg"); // Create URL
      // //Download image
      currentImage = ImageIO.read(url);

      Toolkit.getDefaultToolkit().beep(); // Alert the user
      repaint();
    } catch (MalformedURLException e) {
      System.out.println("ERROR: " + e.getMessage());
    } catch (IOException e) {
      System.out.println("ERROR: " + e.getMessage());
    }
  }

  public void itemStateChanged(ItemEvent evt) {
    showCurrentSelection();
  }
}

public class RealEstate {
  public static void main(String[] args) {
    RealEstateViewer viewer = new RealEstateViewer();
    viewer.setSize(viewer.WIDTH, viewer.HEIGHT);
    viewer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    viewer.setVisible(true);
  }
}
