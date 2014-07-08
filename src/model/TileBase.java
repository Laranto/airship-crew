package model;

import java.lang.reflect.InvocationTargetException;

import model.tilebase.EmptySpace;
import model.tilebase.OutOfBoundsTile;

public interface TileBase extends Drawable{
    /**
     * Returns whether one can walk on it or not (for example if it's an wall)
     * @return
     */
    public boolean isWalkable();
}