package display;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import model.character.Chara;
import model.map.WorldMap;

import common.Constants;

public class MainDisplay extends JPanel{
    
    private WorldMap map;
    private Chara player;
    
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
        if(map!=null &&player!=null){
            map.getViewMap(player.getPosition()).paint(g);
        }
    }

    public void setMap(WorldMap map) {
        this.map=map;
    }

    public Chara getPlayer() {
        return player;
    }

    public void setPlayer(Chara player) {
        this.player = player;
    }

    public WorldMap getMap() {
        return map;
    }
    
    
}
