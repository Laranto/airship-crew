package model.character;

import java.awt.Point;

import model.Direction;
import model.Drawable;
import model.action.MoveAction;

public abstract class Chara implements Drawable{
    protected Direction facingDirection;
    protected Point position = new Point(0, 0);
    protected MoveAction mvAction;
    
    public abstract void move(Direction dir);
    
    public Point getPosition(){
        return position;
    }

    public MoveAction getMvAction() {
        return mvAction;
    }
}
