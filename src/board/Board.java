package board;
import boardInterface.BoardInterface;
import java.util.Arrays;
public class Board implements BoardInterface {
    public String[][] board = new String[3][3];

    public Board() {
        for (String[] row : board) {
            Arrays.fill(row, " ");
        }
    }

    @Override
    public boolean isValidMove(int i, int j) {
        return board[i][j].equals(" ");
    }

    @Override
    public void placeMark(String mark, int row, int col) {
        board[row][col] = mark;
    }
    @Override
    public boolean isWinner(String mark) {
        // Horizontal Wins
        if (board[0][0].equals(mark)
                && board[0][1].equals(mark)
                && board[0][2].equals(mark))  return true;

        if (board[1][0].equals(mark)
                && board[1][1].equals(mark)
                && board[1][2].equals(mark)) return true;

        if (board[2][0].equals(mark)
                && board[2][1].equals(mark)
                && board[2][2].equals(mark)) return true;

            // Vertical Wins:
        if (board[0][0].equals(mark)
                && board[1][0].equals(mark)
                && board[2][0].equals(mark)) return true;
        if (board[0][1].equals(mark)
                && board[1][1].equals(mark)
                && board[2][1].equals(mark)) return true;
        if (board[0][2].equals(mark)
                && board[1][2].equals(mark)
                && board[2][2].equals(mark)) return true;

            // Diagonal wins
        if (board[0][0].equals(mark)
                && board[1][1].equals(mark)
                && board[2][2].equals(mark)) return true;
        if (board[0][2].equals(mark)
                && board[1][1].equals(mark)
                && board[2][0].equals(mark)) return true;

        return false;
    }
    @Override
    public boolean isGameOver() {
        return isWinner("x") || isWinner("o") || !hasEmptyCells();
    }
    @Override
    public boolean hasEmptyCells() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].equals(" ")) {
                    return true;
                }
            }
        }
        return false;
    }
    @Override
    public void printBoard() {
        for (String[] array : board) {
            System.out.println(Arrays.toString(array));
        }
    }
}
