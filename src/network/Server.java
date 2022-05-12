package network;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    private Client ServerClient;
    private ServerSocket serverSocket;

    public Server() {
        try {
            this.serverSocket = new ServerSocket();
            this.ServerClient = new Client();
            while (true) {
                System.out.println("Waiting for connection");
                this.ServerClient.socket = serverSocket.accept();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        this.ServerClient.start();
    }
}
