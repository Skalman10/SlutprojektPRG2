package modell;

import java.util.Arrays;
import java.util.Scanner;

public class TIAR {
    public int[][] field;
    public Point move;

    public TIAR(int dimension) {
        this.field = new int[dimension][dimension];
    }

    public void start() {
        System.out.println(field.length);
        Point point = new Point();
        int player;
        for (int i = 0; i < field.length * field.length; i++) {
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

    public void getMove() {
        Scanner in = new Scanner(System.in);
        Point move = new Point(in.nextInt() - 1, in.nextInt() - 1);
        this.move = move;
    }

    public void playerMove(int player, Point move) {
        if (field[move.getX()][move.getY()] == 0) {
            this.field[move.getX()][move.getY()] = player;
        }
    }

    public boolean checkWin() {
        if (horizontal() || vertical() || diagonal()) {
            return true;
        } else {
            return false;
        }
    }

    private boolean diagonal() {
        boolean win = false;
        if (field[1][1]!=0) {
            if (field[0][0] == field[1][1] && field[1][1] == field[2][2]) {
                win = true;
            } else {
                if (field[0][2] == field[1][1] && field[1][1] == field[2][0]) {
                    win = true;
                }
            }
        }
        return win;
    }

    private boolean vertical() {
        boolean win = false;
        for (int i = 0; i < this.field.length; i++) {
            if (field[0][i] != 0) {
                if (field[0][i] == field[1][i] && field[1][i] == field[2][i]) {
                    win = true;
                }
            }
        }
        return win;
    }

    private boolean horizontal() {
        boolean win = false;
        for (int i = 0; i < this.field.length; i++) {
            if (field[i][0] != 0) {
                if (field[i][0] == field[i][1] && field[i][1] == field[i][2]) {
                    win = true;
                }
            }
        }
        return win;
    }

    public void printMatrix() {
        for (int i =0;i<field.length;i++) {
            System.out.println(field[i][0]+" "+field[i][1]+" "+field[i][2]);
        }
    }
}
