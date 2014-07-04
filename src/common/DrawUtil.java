package common;

import java.awt.Point;

public class DrawUtil {
    /**
     * Number of tiles in width
     */
    public static final int TILES_WIDTH = Constants.BOARD_WIDTH/Constants.TILE_SIZE_PX;
    /**
     * Number of tiles in height
     */
    public static final int TILES_HEIGHT = Constants.BOARD_HEIGHT/Constants.TILE_SIZE_PX;

    public static Point tilePosToPixel(Point tilePos){
        return new Point(tilePos.x*Constants.TILE_SIZE_PX,tilePos.y*Constants.TILE_SIZE_PX);
    }
}
