package model.character;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;

import model.Direction;

import common.Constants;
import common.DrawUtil;

public class Cat extends Chara {

    HashMap<Direction, BufferedImage> img = loadCatImages();
    
    public Cat() {
        facingDirection = Direction.SOUTH;
    }
    
    @Override
    public void paint(Graphics g , Point position) {
        Point pixelPos=DrawUtil.tilePosToPixel(position);//Top left of the tile
        g.drawImage(img.get(facingDirection), pixelPos.x, pixelPos.y, null);
    }

    //TODO Stop using static stuff
    private HashMap<Direction, BufferedImage> loadCatImages() {
        HashMap<Direction, BufferedImage> map = new HashMap<>();
        map.put(Direction.NORTH, DrawUtil.getImage(new File(Constants.CHARACTER_FOLDER+"player\\cat_n.png")));
        map.put(Direction.SOUTH, DrawUtil.getImage(new File(Constants.CHARACTER_FOLDER+"player\\cat_s.png")));
        map.put(Direction.EAST, DrawUtil.getImage(new File(Constants.CHARACTER_FOLDER+"player\\cat_e.png")));
        map.put(Direction.WEST, DrawUtil.getImage(new File(Constants.CHARACTER_FOLDER+"player\\cat_w.png")));
        return map;
    }

    @Override
    public void move(Direction dir) {
        // TODO Auto-generated method stub
    }
}
