package model;

import java.awt.Point;


/**
 * The/a Map holding objects. Able to generate view regions for a position that can be then displayed
 * @author Arni
 *
 */
public class Map {

    Tile[][] map;
    int width,height;
    
    public Map(int width, int height) {
        map = new Tile[width][height];
        this.width=width;
        this.height=height;
        emptyInitializeMap();
    }

    private void emptyInitializeMap() {
        for(int i = 0;i<width;i++){
            for(int j = 0;j<height;j++){
                map[i][j]=new Tile();
            }
        }
    }
    
    public ViewMap getViewMap(Point centerPosition){
        return new ViewMap(map, centerPosition);
    }
    
    
}
