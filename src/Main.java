import java.awt.BorderLayout;

import javax.swing.JFrame;

import display.MainDisplay;


public class Main {
    
    private MainDisplay display; 
    
    public Main() {
        JFrame frame = new JFrame("Airship Crew");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(display = new MainDisplay(),BorderLayout.CENTER);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        new Main();
    }
}
