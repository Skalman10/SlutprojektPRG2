package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public Socket socket;
    public Scanner tgb;
    public PrintWriter out;
    public ListenerThread in;
    public Thread listener;

    public Client(String ip, int port) {
        System.out.println(ip);
        try {
            socket = new Socket(ip, port);
            tgb = new Scanner(System.in);
            out = new PrintWriter(socket.getOutputStream(), true);
            in =  new ListenerThread(new BufferedReader(new InputStreamReader(socket.getInputStream())));
            listener = new Thread(in);
        } catch (Exception e) {
            System.exit(0);
        }
    }
    public Client(String ip) {
        try {
            socket = new Socket(ip, 3300);
            tgb = new Scanner(System.in);
            out = new PrintWriter(socket.getOutputStream(), true);
            in =  new ListenerThread(new BufferedReader(new InputStreamReader(socket.getInputStream())));
            listener = new Thread(in);
        } catch (Exception e) {
            System.exit(0);
        }
    }

    public Client() {
    }

    public void start() {
        listener.start();
        boolean run = true;
        while (run) {
            String msg = tgb.nextLine();
            out.println(msg);
        }
        out.close();
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Done!");
    }
}

