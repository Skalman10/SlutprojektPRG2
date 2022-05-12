package network;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    private Client ServerClient;
    private ServerSocket serverSocket;

    public Server() {
        try {
            System.out.println("hej");
            this.serverSocket = new ServerSocket();
            System.out.println("hej2");
            this.ServerClient = new Client();
            System.out.println("hej3");
            while (true) {
                System.out.println("Waiting for connection");
                this.ServerClient.socket = serverSocket.accept();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        System.out.println("Den starta");
        this.ServerClient.start();
    }
}
