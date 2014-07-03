package display;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class MainDisplay extends JPanel{
    
    /**
     * Displays the mainpart of the game.
     */
    public MainDisplay() {
        this.setPreferredSize(new Dimension(800, 600));
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.setBackground(Color.black);
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.RED.darker());
        g.fillRect(10, 10, 100, 100);
    }
}
