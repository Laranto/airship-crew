package model;

import java.awt.Graphics;
import java.awt.Point;

import model.tilebase.EmptySpace;

public class Tile implements Drawable{
    private TileBase base;

    public Tile() {
        base = new EmptySpace();
    }
    
    @Override
    public void paint(Graphics g , Point position) {
        base.paint(g, position);
    }

    public TileBase getBase() {
        return base;
    }

    public void setBase(TileBase base) {
        this.base = base;
    }
}
