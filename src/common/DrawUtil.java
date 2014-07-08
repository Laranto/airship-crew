package common;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;

import model.map.tilebase.TileEnum;

public class DrawUtil {
    private static Random                                 rand         = new Random();
    private static HashMap<TileEnum, List<BufferedImage>> tileImageMap     = loadImageMap();
    private static HashMap<File, BufferedImage> singleImageMap = new HashMap<>();

    /**
     * Number of tiles in width
     */
    public static final int                               TILES_WIDTH  = Constants.BOARD_WIDTH / Constants.TILE_SIZE_PX;
    /**
     * Number of tiles in height
     */
    public static final int                               TILES_HEIGHT = Constants.BOARD_HEIGHT / Constants.TILE_SIZE_PX;

    public static Point tilePosToPixel(Point tilePos) {
        return new Point(tilePos.x * Constants.TILE_SIZE_PX , tilePos.y * Constants.TILE_SIZE_PX);
    }

    public static BufferedImage getImage(File file){
        BufferedImage img = singleImageMap.get(file);
        if(img==null){
            img = loadImage(file);
            singleImageMap.put(file, img);
        }
        return img;
    }
    
    private static HashMap<TileEnum, List<BufferedImage>> loadImageMap() {
        HashMap<TileEnum, List<BufferedImage>> imgMap = new HashMap<>();
        for (TileEnum tileType : TileEnum.values()) {
            File imageFolder = tileType.getFolder();
            if (imageFolder.exists()) {
                File[] imageFiles = imageFolder.listFiles(new FilenameFilter() {
                    @Override
                    public boolean accept(File dir , String name) {
                        return name.toLowerCase().endsWith(".png");
                    }
                });
                imgMap.put(tileType, new ArrayList<BufferedImage>(imageFiles.length));
                for (File imgFile : imageFiles) {
                    imgMap.get(tileType).add(loadImage(imgFile));
                }
            }
        }
        return imgMap;
    }

    private static BufferedImage loadImage(File imgFile) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(imgFile);
        } catch (IOException e) {
            System.err.println("Tried reading file " + imgFile.getAbsolutePath());
            e.printStackTrace();
        }
        return img;
    }

    public static BufferedImage getRandomImage(TileEnum type) {
        List<BufferedImage> imgList = tileImageMap.get(type);
        return imgList.get(rand.nextInt(imgList.size()));
    }
}
