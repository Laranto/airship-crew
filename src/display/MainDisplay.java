package display;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class MainDisplay extends JPanel{
    
    public MainDisplay() {
        this.setPreferredSize(new Dimension(800, 600));
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.setBackground(Color.black);
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.magenta);
        g.fillRect(10, 10, 100, 100);
    }
}
