package network.server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientWorker implements Runnable{

	private Socket socket;
	private AirshipCrewServer server;
	
	public ClientWorker(Socket clientSocket) {
		socket = clientSocket;
		try {
			new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		server.getMap();
		
	}
	
}
