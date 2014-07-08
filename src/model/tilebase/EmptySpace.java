package model.tilebase;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;

import common.Constants;
import common.DrawUtil;

import model.TileBase;

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
//        g.setColor(new Color(128, 218, 235));//Sky Blue (Crayola)
//        g.fillRect(pixelPos.x, pixelPos.y, Constants.TILE_SIZE_PX, Constants.TILE_SIZE_PX);
    }


}
