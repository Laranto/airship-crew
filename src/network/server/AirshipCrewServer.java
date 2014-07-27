package network.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

import model.map.WorldMap;

public class AirshipCrewServer {
    private ServerSocket serverSock;
    private List<Socket> connectedClients;
    private WorldMap map;
    
    public AirshipCrewServer(int port) {
        try {
            serverSock = new ServerSocket(port);
            connectedClients = new LinkedList<>();
            new Thread(new Runnable() {

                @Override
                public void run() {
                    Socket newclient;
                    try {
                        newclient = serverSock.accept();
                        //TODO Initialize Client worker, that sends the map to the client
                        
                        connectedClients.add(newclient);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        runServer();
    }

	private void runServer() {
		//TODO Generate Map
		//TODO Receive Client inputs
		//TODO Execute Client inputs
		//TODO Send all executed commands to clients for them to update the map (changes)
	}

	public WorldMap getMap() {
		return map;
	}
}
