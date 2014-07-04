import java.awt.BorderLayout;

import javax.swing.JFrame;

import model.Map;
import controll.MainLoop;
import display.ControlPanel;
import display.MainDisplay;


public class Main {
    
    private MainDisplay display; 
    private ControlPanel controlPane;
    private MainLoop loop;
    
    
    public Main() {
        //Runs in this thread (Display Thread)
        createFrame();
        //Start a thread with the main loop (Logic Thread)
        new Thread(loop = new MainLoop()).start();
        loop.registerContainer(display);
        createMap();
    }



    private void createMap() {
        Map map = new Map(30, 30);
        loop.setMap(map);
        display.setMap(map);
    }



    public void createFrame() {
        JFrame frame = new JFrame("Airship Crew");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(display = new MainDisplay(),BorderLayout.CENTER);
        frame.add(controlPane = new ControlPanel(), BorderLayout.EAST);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }
    
    
    
    public static void main(String[] args) {
        new Main();
    }
}
