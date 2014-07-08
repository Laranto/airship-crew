package model.character;

import model.Direction;
import model.Drawable;

public abstract class Character implements Drawable{
    protected Direction facingDirection;
    
    public abstract void move(Direction dir);
    
}
