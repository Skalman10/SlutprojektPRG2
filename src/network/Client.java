package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public Socket socket;
    private Scanner tgb;
    private PrintWriter out;
    private ListenerThread in;
    private Thread listener;

    public Client(String ip, int port) {
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
        try {
            System.out.println("hej4");
            socket = new Socket("", 3300);
            System.out.println("hej5");
            tgb = new Scanner(System.in);
            System.out.println("hej6");
            out = new PrintWriter(socket.getOutputStream(), true);
            System.out.println("hej7");
            in =  new ListenerThread(new BufferedReader(new InputStreamReader(socket.getInputStream())));
            System.out.println("hej8");
            listener = new Thread(in);
            System.out.println("hej9");
        } catch (Exception e) {
            System.out.println("Client failed to connect");
            System.exit(0);
        }
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
