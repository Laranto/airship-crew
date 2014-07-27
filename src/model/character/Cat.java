package model.character;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;

import model.Direction;
import model.action.MoveAction;

import common.Constants;
import common.DrawUtil;

public class Cat extends Chara {

    private HashMap<Direction, BufferedImage> img = loadCatImages();
    private static final String IMG_DIR = Constants.CHARACTER_FOLDER+"player"+File.separator;
    private static final String NAME = "cat";
    private static final String IMG_NAME_SCHEMA = IMG_DIR+NAME+"_";
    
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
        map.put(Direction.NORTH, DrawUtil.getImage(new File(IMG_NAME_SCHEMA+Direction.NORTH.getShort()+".png")));
        map.put(Direction.SOUTH, DrawUtil.getImage(new File(IMG_NAME_SCHEMA+Direction.SOUTH.getShort()+".png")));
        map.put(Direction.EAST, DrawUtil.getImage(new File(IMG_NAME_SCHEMA+Direction.EAST.getShort()+".png")));
        map.put(Direction.WEST, DrawUtil.getImage(new File(IMG_NAME_SCHEMA+Direction.WEST.getShort()+".png")));
        return map;
    }

    @Override
    public MoveAction move(Direction dir) {
        mvAction=new MoveAction();
        mvAction.setFacingDirection(dir);
        mvAction.setOldPos(position);
        mvAction.setNewPos(
                new Point(
                        dir.getDirectionVector().get(0)+position.x,
                        dir.getDirectionVector().get(1)+position.y
                        )
                );
		return mvAction;
    }
    
    @Override
    public void executeMoveAction(MoveAction action) {
    	this.facingDirection=action.getFacingDirection();
    	position = action.getNewPos();
    	//TODO Get some translation animation?
    	//TODO move feet of the thing that moves / toggle pictures
    }
}
