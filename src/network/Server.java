package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public Client ServerClient;
    private ServerSocket serverSocket;

    public Server(int port) {
        try {
            this.serverSocket = new ServerSocket(port);
            ServerClient = new Client();
            while (true) {
                System.out.println("Waiting for connection");
                ServerClient.socket = serverSocket.accept();
                break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Client connected!");
        ServerClient.tgb = new Scanner(System.in);
        try {
            ServerClient.out = new PrintWriter(ServerClient.socket.getOutputStream(), true);
            ServerClient.in = new ListenerThread(new BufferedReader(new InputStreamReader(ServerClient.socket.getInputStream())));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ServerClient.listener = new Thread(ServerClient.in);
    }
}
