import modell.Point;
import modell.TIAR;
import network.Client;
import network.Server;

import javax.swing.*;
import java.util.Arrays;
import java.util.Scanner;

public class Controller {
    private int player;
    private Point move;

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
        TIAR game = new TIAR(3);
        System.out.println(game.field.length);
        Point point = new Point();
        int player;
        for (int i = 0; i < game.field.length * game.field.length; i++) {
            game.move = new Point();
            player = (i) % 2 + 1;
            game.getMove();
            game.playerMove(player, game.move);
            System.out.println(Arrays.deepToString(game.field));
            /*
            if (game.checkWin()) {
                System.out.println("Spelare " + player + " vann spelet!");
            }
             */
        }
    }

    public static void main(String[] args) {
        Controller c = new Controller();
        c.start();
    }
}
