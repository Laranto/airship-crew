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
    
    
    public enum TileEnum{
        NULL(OutOfBoundsTile.class),EMPTY(EmptySpace.class);
        public Class typeClass;
        private TileEnum(Class typeClass) {
            this.typeClass=typeClass;
        }
        public TileBase createInstance(){
            try {
                return (TileBase)typeClass.getConstructor().newInstance();
            } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }
}