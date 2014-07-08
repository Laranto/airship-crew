package model.map.tilebase;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

import model.map.TileBase;

import common.DrawUtil;

/**
 * Aka "sky"
 * @author Arni
 *
 */
public class EmptySpace implements TileBase {
    
    private BufferedImage imageRepresentation;
    
    public EmptySpace() {
        imageRepresentation = DrawUtil.getRandomImage(TileEnum.EMPTY);
    }
    
    @Override
    public boolean isWalkable() {
        return false;
    }

    @Override
    public void paint(Graphics g,Point tilePosition) {
        Point pixelPos=DrawUtil.tilePosToPixel(tilePosition);//Top left of the tile
        g.drawImage(imageRepresentation, pixelPos.x, pixelPos.y, null);
    }


}
