package model.map.tilebase;

import java.io.File;
import java.lang.reflect.InvocationTargetException;

import model.map.TileBase;

import common.Constants;

public enum TileEnum{
    NULL(OutOfBoundsTile.class,null),
    EMPTY(EmptySpace.class,"sky"),
    FLOOR_WOOD(FloorWood.class,"floor_wood");
    @SuppressWarnings("rawtypes")
    public Class typeClass;
    public String folderName;
    
    private TileEnum(@SuppressWarnings("rawtypes") Class typeClass,String folderName) {
        this.typeClass=typeClass;
        this.folderName = folderName;
    }
    
    @SuppressWarnings("unchecked")
    public TileBase createInstance(){
        try {
            return (TileBase)typeClass.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    
    public File getFolder(){
        return new File(Constants.TILES_FOLDER+File.separator+folderName);
    }
}