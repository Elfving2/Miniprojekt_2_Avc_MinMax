package Main;

import board.Board;

import java.util.Scanner;

import logic.MinMax;

public class Main {

    static int rowIndex, columnIndex;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        playGame();
    }
    private static void playGame() {
        Board board = new Board();
        int[] moves;
        while (!board.isGameOver()) {
            moves = MinMax.getBestMove(board, "x", "o");

            board.printBoard();
            System.out.printf("Best Move : %d, %d \n", moves[0], moves[1]);
            rowIndex = -1;
            columnIndex = -1;
            getUserInput(board);
            board.placeMark("x", rowIndex, columnIndex);
            // AI
            if (!board.isGameOver()) {
                moves = MinMax.getBestMove(board, "o", "x");
                board.placeMark("o", moves[0], moves[1]);
                System.out.println("Board\n");
                board.printBoard();
            }

        }
        String result = board.isWinner("x") ? "X is winner" : board.isWinner("o") ? "O is winner" : "Draw";
        System.out.println(result);
        scanner.close();
    }

    private static int checkForValidInput(String str) {
        switch (str) {
            case "0", "1", "2" -> {
                return Integer.parseInt(str);
            }
            default -> {
                System.out.println("Not a valid chose, please try again!");
                return -1;
            }
        }
    }

    private static void getUserInput(Board board) {
        while (rowIndex == -1 || columnIndex == -1) {

            System.out.print("Choose row: ");
            rowIndex = checkForValidInput(scanner.nextLine());

            if (rowIndex != -1) {
                System.out.print("Choose column: ");
                columnIndex = checkForValidInput(scanner.nextLine());

                if (columnIndex != -1 && !board.isValidMove(rowIndex, columnIndex )) {
                    System.out.println("This square is already taken, please try again!");
                    rowIndex = -1;
                    columnIndex = -1;
                }
            }
        }
    }
}