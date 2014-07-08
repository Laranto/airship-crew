package common;

import java.io.File;

public class Constants {
    public static final int BOARD_HEIGHT = 600;
    public static final int BOARD_WIDTH = 600;
    public static final int CONTROLL_WIDTH = 200;
    
    public static final int TILE_SIZE_PX = 40; //600 / 40 = 15 Tiles displayed (like in SS13)
    private static final String RESOURCES_FOLDER = "resources"; 
    public static final String TILES_FOLDER = RESOURCES_FOLDER+File.separator+"tiles"+File.separator;
    public static final String CHARACTER_FOLDER = RESOURCES_FOLDER+File.separator+"character"+File.separator;
    
}
