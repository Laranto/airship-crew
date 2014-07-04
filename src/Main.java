import java.awt.BorderLayout;

import javax.swing.JFrame;

import controll.MainLoop;

import display.MainDisplay;


public class Main {
    
    private MainDisplay display; 
    private MainLoop loop;
    
    
    public Main() {
        //Runs in this thread (Display Thread)
        createFrame();
        //Start a thread with the main loop (Logic Thread)
        new Thread(loop = new MainLoop()).start();
        
        loop.registerDrawable(display);
    }



    public void createFrame() {
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
