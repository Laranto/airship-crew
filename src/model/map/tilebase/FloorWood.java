package model.map.tilebase;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

import model.map.TileBase;

import common.DrawUtil;

public class FloorWood implements TileBase {
    
    private BufferedImage imageRepresentation;
    
    public FloorWood() {
        imageRepresentation = DrawUtil.getRandomImage(TileEnum.FLOOR_WOOD);
    }
    
    @Override
    public boolean isWalkable() {
        return true;
    }

    @Override
    public void paint(Graphics g,Point tilePosition) {
        Point pixelPos=DrawUtil.tilePosToPixel(tilePosition);//Top left of the tile
        g.drawImage(imageRepresentation, pixelPos.x, pixelPos.y, null);
    }


}
