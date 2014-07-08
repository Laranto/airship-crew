package model;


public interface TileBase extends Drawable{
    /**
     * Returns whether one can walk on it or not (for example if it's an wall)
     * @return
     */
    public boolean isWalkable();
}