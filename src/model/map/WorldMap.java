package model.map;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.action.MoveAction;
import model.character.Chara;
import model.map.tilebase.TileEnum;
import model.object.ASObject;


/**
 * The/a Map holding objects. Able to generate view regions for a position that can be then displayed
 * @author Arni
 *
 */
public class WorldMap {

	ArrayList<ASObject> objects;
    Tile[][] map;
    Set<Chara> charas;
    int width,height;
    
    public WorldMap(int width, int height) {
        charas=new HashSet<>();
        map = new Tile[width][height];
        objects = new ArrayList<>();
        this.width=width;
        this.height=height;
        emptyInitializeMap();
    }
    
    /**
     * @param byteWorldMap a byte array recieved from toByte
     */
    public WorldMap(byte[] byteWorldMap){
    	//TODO create the worldmap from bytes
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
    
    public void setMapTile(TileEnum tileType,int x, int y){
        map[x][y].setBase(tileType.createInstance());
    }

    public void put(Chara chara , int x , int y) {
        charas.add(chara);
        map[x][y].setChara(chara);
        chara.getPosition().setLocation(x, y);
    }
    
    public Tile getTile(Point pos){
        return map[pos.x][pos.y];
    }
    
    public void executeMoveActions(Collection<MoveAction> mvActions){
    	for(MoveAction mvAction:mvActions){
    		Chara movingCharacter = map[mvAction.getOldPos().x][mvAction.getOldPos().y].getChara();
    		map[mvAction.getNewPos().x][mvAction.getNewPos().y].setChara(movingCharacter);
    	}
    }
    
    public void moveCharas(){
        for (Chara chara:charas) {
            if(chara.getMvAction()!=null){
                if(getTile(chara.getMvAction().getNewPos()).isWalkable()){
                    getTile(chara.getPosition()).setChara(null);
                    chara.getPosition().setLocation(chara.getMvAction().getNewPos());
                    getTile(chara.getPosition()).setChara(chara);
                }
            }
        }
    }
    
    public byte[] toByte(){
    	//TODO convert the map and all its contents to a byte array
		return null;
    }
    
}
