package model.tilebase;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import common.Constants;
import common.DrawUtil;

import model.TileBase;

public class EmptySpace implements TileBase {

    @Override
    public boolean isWalkable() {
        return false;
    }

    @Override
    public void paint(Graphics g,Point tilePosition) {
        Point pixelPos=DrawUtil.tilePosToPixel(tilePosition);//Top left of the tile
        g.setColor(new Color(128, 218, 235));//Sky Blue (Crayola)
        g.fillRect(pixelPos.x, pixelPos.y, Constants.TILE_SIZE_PX, Constants.TILE_SIZE_PX);
    }


}
