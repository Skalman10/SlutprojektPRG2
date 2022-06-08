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


         if (mode.equals("client")) {
            Client client = new Client(ip, port);
            client.start();
        }

        if (mode.equals("server")) {
            Server server = new Server(port);
            server.start();
            TIAR game = new TIAR(3);
            System.out.println(game.field.length);
            for (int i = 0; i < game.field.length * game.field.length; i++) {
                game.printMatrix();
                for (int f =0;f<game.field.length;f++) {
                    server.ServerClient.out.println
                            (game.field[f][0]+" "+game.field[f][1]+" "+game.field[f][2]);
                }
                game.move = new Point();
                player = (i) % 2 + 1;
                game.getMove();
                game.playerMove(player, game.move);
                if (game.checkWin()) {
                    System.out.println("Spelare " + player + " vann spelet!");
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Controller c = new Controller();
        c.start();
    }
}
