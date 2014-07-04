package model.tilebase;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import common.Constants;
import common.DrawUtil;

import model.TileBase;

public class OutOfBoundsTile implements TileBase {

    @Override
    public void paint(Graphics g, Point position) {
        Point pixelPos=DrawUtil.tilePosToPixel(position);//Top left of the tile
        g.setColor(Color.black);
        g.fillRect(pixelPos.x, pixelPos.y, Constants.TILE_SIZE_PX, Constants.TILE_SIZE_PX);
    }

    @Override
    public boolean isWalkable() {
        return false;
    }

}
