package controll;

import java.awt.Container;
import java.util.HashSet;
import java.util.Set;

import model.map.Map;



/**
 * This class is the main loop of the game. It calls all other tasks to be done. To be used in a thread (hence runnable)
 * @author Arni
 *
 */
public class MainLoop implements Runnable {

    private boolean gameRunning;
    private Set<Container> drawList;
    private Map map;
    
    public MainLoop() {
        gameRunning = true;
        drawList = new HashSet<>(); //Use of hashset so something is just once in the list and we don't care about the order
    }
    
    public void registerContainer(Container container){
        drawList.add(container);
    }
    
    public void setMap(Map map){
        this.map=map;
    }
    
    @Override
    public void run() {
        while(gameRunning){
            if(map!=null){
            map.moveCharas();
            }
            for (Container drawable : drawList) {
                drawable.repaint();
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
