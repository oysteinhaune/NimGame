package com.company;

import java.util.Scanner;

public class NimGame {

    private Scanner scanner;
    private String activePlayer;
    private Nim nim;

    public NimGame() {
        this.scanner = new Scanner(System.in);
        this.activePlayer = "Player 1";
        this.nim = new Nim(10, 10 , 10);
        System.out.println("Rules:\nTake as many pieces a you want from 1 pile at the time.\n" +
                "The player who takes the last piece lose. Have fun! :D\n");
        this.run();
    }

    public void run() {
        System.out.println(this.nim);
        System.out.println(activePlayer + " enter the pile you want to use: ");
        int choosenPile = this.scanner.nextInt();
        System.out.println(activePlayer + " enter the amount of pieces you want to take.");
        int choosenAmount = this.scanner.nextInt();
        if (this.nim.isValidMove(choosenAmount, choosenPile)) {
            this.nim.removePieces(choosenAmount, choosenPile);
            if (this.nim.isGameOver()) {
                System.out.println("Sorry you lost " + activePlayer + "... " + this.getOtherPlayer() + " won the game!! :D");
            }
            else {
                this.switchPlayer();
                this.run();
            }
        }
        else {
            System.out.println("Error. That's not possible " + activePlayer + "... Try again.\n");
            this.run();
        }
    }

    public void switchPlayer() {
        if (this.activePlayer == "Player 1") {
            this.activePlayer = "Player 2";
        } else {
            this.activePlayer = "Player 1";
        }
    }

    public String getOtherPlayer() {
        if (this.activePlayer == "Player 1") {
            return "Player 2";
        } else {
            return "Player 1";
        }
    }
}
