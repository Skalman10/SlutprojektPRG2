import modell.Point;
import modell.TIAR;
import network.Client;
import network.Server;

import javax.swing.*;
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
        game.start();

    }

    public static void main(String[] args) {
        Controller c = new Controller();
        c.start();
    }
}
