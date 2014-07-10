package network.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class AirshipCrewServer {
    private ServerSocket serverSock;
    private List<Socket> connectedClients;

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
                        
                        connectedClients.add(newclient);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
