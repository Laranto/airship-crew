package model;

import java.awt.Graphics;
import java.awt.Point;

import model.TileBase.TileEnum;
import model.tilebase.EmptySpace;

import common.DrawUtil;

public class ViewMap {
    private Tile[][] map;
    
    public ViewMap(Tile[][] fullMap,Point centerPosition) {
        map = new Tile[DrawUtil.TILES_WIDTH][DrawUtil.TILES_HEIGHT];
        Point topLeft = new Point(centerPosition.x-DrawUtil.TILES_WIDTH/2,centerPosition.y-DrawUtil.TILES_HEIGHT/2);
        for(int i = 0;i<DrawUtil.TILES_WIDTH;i++){
            for(int j = 0;j<DrawUtil.TILES_HEIGHT;j++){
                if((topLeft.x+i)<0||(topLeft.y+j)<0||(topLeft.x+i)>DrawUtil.TILES_WIDTH||(topLeft.y+j)>DrawUtil.TILES_HEIGHT){
                    map[i][j]=new Tile();
                    map[i][j].setBase(TileEnum.NULL.createInstance());
                }else{
                    map[i][j]=fullMap[topLeft.x+i][topLeft.y+j];
                }
            }
        }
    }
    
    public void paint(Graphics g){
        for(int i = 0;i<DrawUtil.TILES_WIDTH;i++){
            for(int j = 0;j<DrawUtil.TILES_HEIGHT;j++){
                map[i][j].paint(g, new Point(i,j));
            }
        }
    }
}
