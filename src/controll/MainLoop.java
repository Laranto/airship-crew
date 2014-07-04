package controll;

import java.awt.Container;
import java.util.HashSet;
import java.util.Set;



/**
 * This class is the main loop of the game. It calls all other tasks to be done. To be used in a thread (hence runnable)
 * @author Arni
 *
 */
public class MainLoop implements Runnable {

    private boolean gameRunning;
    private Set<Container> drawList;
    
    public MainLoop() {
        gameRunning = true;
        drawList = new HashSet<>(); //Use of hashset so something is just once in the list and we don't care about the order
    }
    
    public void registerDrawable(Container drawable){
        drawList.add(drawable);
    }
    
    @Override
    public void run() {
        while(gameRunning){
            for (Container drawable : drawList) {
                drawable.repaint();
            }
        }
    }

}
