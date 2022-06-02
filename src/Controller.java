import modell.Point;
import modell.TIAR;
import network.Client;
import network.Server;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Controller {
    private int player;
    private Point move;
    private String ip;
    private int port;
    private String mode;

    public void start() {
        /*
        String option = (String) JOptionPane.showInputDialog(null, "Server or client?", JOptionPane.QUESTION_MESSAGE);
        if (option.equals("server")) {
            Server server = new Server(12345);
            server.start();
        } else {
            //String ip = (String) JOptionPane.showInputDialog(null,"IP?","Connect to..",JOptionPane.QUESTION_MESSAGE);
            Client client = new Client("",12345);
            client.start();
        }

         */
        try {
            File config = new File("NetworkConfig.txt");
            Scanner configIn = new Scanner(config);
            String s;
            s = configIn.nextLine();
            ip = s.substring(s.indexOf("=")+1);
            System.out.println(ip);
            s = configIn.nextLine();
            port = Integer.parseInt(s.substring(s.indexOf("=")+1));
            System.out.println(port);
            s = configIn.nextLine();
            mode = s.substring(s.indexOf("=")+1);
            System.out.println(mode);
        } catch (FileNotFoundException e) {
            System.out.println("Config file not found!");
            e.printStackTrace();
        }
/*
        NetworkConfig config = new NetworkConfig();
        if (config.getMode().equals("server")) {
            Server server = new Server(config.getPort());
            server.start();
        } else if (config.getMode().equals("client")) {
            Client client = new Client(config.getIp(),config.getPort());
            client.start();
        }

        TIAR game = new TIAR(3);
        System.out.println(game.field.length);
        Point point = new Point();
        int player;
        for (int i = 0; i < game.field.length * game.field.length; i++) {
            game.move = new Point();
            player = (i) % 2 + 1;
            game.getMove();
            game.playerMove(player, game.move);
            game.printMatrix();
            if (game.checkWin()) {
                System.out.println("Spelare " + player + " vann spelet!");
                break;
            }
        }
        */

    }

    public static void main(String[] args) {
        Controller c = new Controller();
        c.start();
    }
}
