// Arda Demir - 2025

import javax.swing.JFrame;

public class App {
    public static void main(String[] args) throws Exception {
      gameFrame frame = new gameFrame();                        // create window
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     // set default close operation to exit on close
      frame.setSize(1000, 600);                    // width:1000  -  height:600
      frame.setVisible(true);                                 // set visibility of frame to true
    }
}