import network.Client;
import network.Server;

import javax.swing.*;

public class Controller {
    public static void main(String[] args) {
        String option = (String) JOptionPane.showInputDialog(null, "Server or client?", JOptionPane.QUESTION_MESSAGE);
        if (option.equals("server")) {
            Server server = new Server();
            server.start();
        } else {
            //String ip = (String) JOptionPane.showInputDialog(null,"IP?","Connect to..",JOptionPane.QUESTION_MESSAGE);
            Client client = new Client("",12345);
            client.start();
        }
    }
}
