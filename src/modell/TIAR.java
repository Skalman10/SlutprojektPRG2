package modell;

import java.util.Arrays;
import java.util.Scanner;

public class TIAR {
    private int[][] field;
    private Point move;

    public TIAR(int dimension) {
        this.field = new int[dimension][dimension];
    }

    public void start() {
        System.out.println(field.length);
        Point point = new Point();
        int player;
        for (int i = 0; i < field.length* field.length; i++) {
            move = new Point();
            player = (i) % 2 + 1;
            getMove();
            playerMove(player, move);
            System.out.println(Arrays.deepToString(field));
            if (checkWin()) {
                System.out.println("Spelare " + player + " vann spelet!");
            }
        }
    }

    private void getMove() {
        Scanner in = new Scanner(System.in);
        Point move = new Point(in.nextInt()-1, in.nextInt()-1);
        this.move = move;
    }

    private void playerMove(int player, Point move) {
        if (field[move.getX()][move.getY()] == 0) {
            this.field[move.getX()][move.getY()] = player;
        }
    }
    private boolean checkWin() {
        if (horizontal() || vertical() || diagonal()) {
            return true;
        } else {
            return false;
        }
    }

    private boolean horizontal() {
        for (int i =)
    }
}
