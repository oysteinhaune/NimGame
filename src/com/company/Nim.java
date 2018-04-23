package com.company;

public class Nim {
    private int pile1;
    private int pile2;
    private int pile3;

    public Nim(int pile1, int pile2, int pile3) {
        this.pile1 = pile1;
        this.pile2 = pile2;
        this.pile3 = pile3;
    }

    public void setPile1(int pile1) {
        this.pile1 = pile1;
    }

    public void setPile2(int pile2) {
        this.pile2 = pile2;
    }

    public void setPile3(int pile3) {
        this.pile3 = pile3;
    }

    public void removePieces(int number, int targetPile) {
        if (targetPile == 1) {
            this.pile1 -= number;
        }
        else if (targetPile == 2) {
            this.pile2 -= number;
        }
        else if (targetPile == 3) {
            this.pile3 -= number;
        }
    }

    public String toString() {
        return String.format("Pile 1: %d \n" +
                "Pile 2: %d \n"+
                "Pile 3: %d \n", pile1, pile2, pile3);
    }

    public boolean isValidMove(int number, int targetPile) {
        if (targetPile < 1 || targetPile > 3) {
            return false;
        }
        if (targetPile == 1 && this.pile1 < number) {
            return false;
        } else if  (targetPile == 2 && this.pile2 < number) {
            return false;
        } else if (targetPile == 3 && this.pile3 < number) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isGameOver() {
        if (this.pile1 == 0 && this.pile2 == 0 && this.pile3 == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public int getPile(int targetPile) {
        if (targetPile == 1) {
            return this.pile1;
        }
        else if (targetPile == 2) {
            return this.pile2;
        }
        else if (targetPile == 3) {
            return this.pile3;
        }
        return 0;
    }
}
