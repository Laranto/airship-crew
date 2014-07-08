package display;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

import model.map.Map;

import common.Constants;

public class MainDisplay extends JPanel{
    
    private Map map;
    private Point playerPosition = new Point(2, 6);
    
    /**
     * Displays the mainpart of the game.
     */
    public MainDisplay() {
        this.setPreferredSize(new Dimension(Constants.BOARD_WIDTH, Constants.BOARD_HEIGHT));
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.setBackground(Color.black);
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if(map!=null){
            map.getViewMap(playerPosition).paint(g);
        }
    }

    public void setMap(Map map) {
        this.map=map;
    }
}
