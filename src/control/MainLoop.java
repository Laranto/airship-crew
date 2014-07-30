package control;

import java.awt.Container;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

import model.map.WorldMap;

/**
 * This class is the main loop of the game. It calls all other tasks to be done.
 * To be used in a thread (hence runnable)
 * 
 * @author Arni
 * 
 */
public class MainLoop implements Runnable {

	private boolean gameRunning;
	private Set<Container> drawList;
	private WorldMap map;
	private Socket connection;

	public MainLoop() {
		gameRunning = true;
		drawList = new HashSet<>(); // Use of hashset so something is just once
									// in the list and we don't care about the
									// order
	}

	public void registerContainer(Container container) {
		drawList.add(container);
	}

	public void setMap(WorldMap map) {
		this.map = map;
	}

	@Override
	public void run() {
		while (gameRunning) {
			if (map != null) {
				map.moveCharas();
			}
			for (Container drawable : drawList) {
				drawable.repaint();
			}
			sendActions();
			recieveUpdate();
			executeUpdate();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * Execute the changeset so the map is equivalent to the servers again
	 */
	private void executeUpdate() {
		// TODO Auto-generated method stub
	}

	/**
	 * Recieve the changeset from the server and prepare it for execution
	 */
	private void recieveUpdate() {
		// TODO Auto-generated method stub

	}

	/**
	 * Sends the intended actions to the server. The server will calculate if
	 * the action is valid and what will be achieved by the action
	 */
	private void sendActions() {
		// TODO Auto-generated method stub

	}

}
