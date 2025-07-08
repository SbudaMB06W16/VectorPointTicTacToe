/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.consoletictactoevpod;

/**
 *
 * @author Sibusiso
 */
import java.util.*;

public class ConsoleTicTacToeVPOD { 
    static final int[][] Vectors = { 
                                    {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Rows 
                                    {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Columns 
                                    {0, 4, 8}, {2, 4, 6}             // Diagonals 
                                   };

static char[] board = new char[9];
static Scanner scanner = new Scanner(System.in);
static Map<Integer, Character> vectorOwners = new HashMap<>();

public static void main(String[] args) {
    Arrays.fill(board, ' ');
    char currentPlayer = 'X';

    while (true) {
        displayBoard();
        displayHeatMap(currentPlayer);
        int move = askMove(currentPlayer);
        board[move] = currentPlayer;

        updateVectorOwnership(move, currentPlayer);

        if (checkWin(currentPlayer)) {
            displayBoard();
            System.out.println("Player " + currentPlayer + " wins!");
            break;
        }
        if (isTie()) {
            displayBoard();
            System.out.println("It's a tie!");
            break;
        }

        currentPlayer = currentPlayer == 'X' ? 'O' : 'X';
    }
}

static void displayBoard() {
    System.out.println("\nCurrent Board:");
    for (int i = 0; i < 9; i++) {
        System.out.print(" " + board[i] + " ");
        if (i % 3 != 2) System.out.print("|");
        if (i % 3 == 2 && i != 8) System.out.println("\n-----------");
    }
    System.out.println("\n");
}

static void displayHeatMap(char player) {
    System.out.println("Heatmap for player " + player + ": (potential win paths per cell)");
    for (int i = 0; i < 9; i++) {
        if (board[i] == ' ') {
            int score = 0; 
            for (int[] vec : Vectors) {
                if (contains(vec, i)) {
                    if (isVectorOpen(vec, player)) {
                        int myMark = 0;
                        for(int m : vec){
                            if (board[m] == player){
                                myMark++;
                            }
                        }
                        if(myMark == 0){
                            score++;
                        }
                        else{
                            score += myMark;
                        }
                    }
                    else if(isVectorOpponentOwned(vec, player)){
                        int oppMark = 0;
                        for(int m : vec){
                            if (board[m] != player && board[m] != ' '){
                                oppMark++;
                            }
                        }
                        if(oppMark == 0){
                            score++;
                        }
                        else{
                            score += oppMark;
                        }
                    }
                }
            }
            System.out.printf("[%d]:%d ", i + 1, score);
        } else {
            System.out.printf("[%d]:%c ", i + 1, board[i]);
        }
        if (i % 3 == 2) System.out.println();
    }
    System.out.println();
}

static boolean isVectorOpen(int[] vec, char player) {
    for (int c : vec) {
        if (board[c] != ' ' && board[c] != player) return false;
    }
    return true;
}

static boolean isVectorOpponentOwned(int[] vec, char player) {
    for (int c : vec) {
        if (board[c] == player) return false;
    }
    return true;
}

static int askMove(char player) {
    while (true) {
        System.out.print("Player " + player + " enter your move (1-9): ");
        int move = scanner.nextInt() - 1;
        if (move >= 0 && move < 9 && board[move] == ' ') return move;
        System.out.println("Invalid move. Try again.");
    }
}

static void updateVectorOwnership(int pos, char player) {
    for (int v = 0; v < Vectors.length; v++) {
        if (contains(Vectors[v], pos)) {
            Character owner = vectorOwners.get(v);
            if (owner == null) {
                vectorOwners.put(v, player);
            } else if (owner != player && owner != 'D') {
                vectorOwners.put(v, 'D'); // destroyed
                
            }
        }
    }
}

static boolean contains(int[] vector, int pos) {
    for (int x : vector) if (x == pos) return true;
    return false;
}

static boolean checkWin(char player) {
    for (int[] vec : Vectors) {
        if (board[vec[0]] == player && board[vec[1]] == player && board[vec[2]] == player)
            return true;
    }
    return false;
}

static boolean isTie() {
    for (int i = 0; i < 8; i++) {
        Character owner = vectorOwners.get(i);
        if (owner == null) {
            return false;
        }
        if (owner != 'D'){
            return false;
        }
    }
    return true;
}

}
