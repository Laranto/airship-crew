package model.map;

import java.awt.Graphics;
import java.awt.Point;

import model.Drawable;
import model.character.Chara;
import model.map.tilebase.EmptySpace;

public class Tile implements Drawable{
    private TileBase base;
    private Chara character;
    
    public Tile() {
        base = new EmptySpace();
    }
    
    @Override
    public void paint(Graphics g , Point position) {
        base.paint(g, position);
        if(character!=null){
            character.paint(g, position);
        }
    }

    public TileBase getBase() {
        return base;
    }

    public void setBase(TileBase base) {
        this.base = base;
    }

    public void setChara(Chara chara) {
        character=chara;
    }
}
