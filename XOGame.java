package MyClass26;

import java.util.Scanner;

public class XOGame {
    FieldXO gameField;
    Scanner scanner = new Scanner(System.in);
    char whoMakeNextTurn;
    boolean gameOver = false;

    void setupNewGame() {
        System.out.println("Will play new XO game");
        this.gameField = new FieldXO();
        this.gameField.initField();
    }

    void play() {
        this.setupNewGame();
        System.out.println("Who will make firs turn: ");
        char first = this.scanner.next().charAt(0);
        if (first == 'X' || first == 'O') {
            this.whoMakeNextTurn = first;
        } else {
            System.out.println("I recognizing only X or O (zero). So first will be X");
            this.whoMakeNextTurn = 'X';
        }

        while (!gameOver) {
            turn();
            this.gameOver = this.gameField.isGameOver(this.whoMakeNextTurn);
            if (this.gameOver) {
                System.out.println(this.whoMakeNextTurn + " win!");
            }
            if (this.whoMakeNextTurn == 'X') {
                this.whoMakeNextTurn = 'O';
            } else {
                this.whoMakeNextTurn = 'X';
            }
        }
        System.out.println("Game over.");

    }

    void turn() {
        System.out.println(this.whoMakeNextTurn + ", your turn.");
        System.out.print("Chose row: ");
        int rowNumber = this.scanner.nextInt();
        System.out.print("Chose column: ");
        int colNumber = this.scanner.nextInt();
        int rowIndex = rowNumber -1;
        int colIndex = colNumber -1;
        if (this.gameField.isPlaceFree(rowIndex, colIndex)) {
            this.gameField.setValue(rowIndex, colIndex, whoMakeNextTurn);
            this.gameField.printField();
        } else {
            System.out.println("Wrong number (maybe this place is not free?). Make turn again");
            turn();
        }
    }
}
