package boardInterface;

public interface BoardInterface {
    /**
     * Method that return true if any of the winning conditions are met else returns false
     * @param mark
     * @return
     */
    boolean isWinner(String mark);

    /**
     * Method that checks if the game is over
     * @return
     */
    boolean isGameOver();

    /**
     * Method should check if the location row/col on the board
     * is a valid move. Can x or o be placed on a cell or
     * is it already taken
     * @param row
     * @param col
     * @return
     */
    boolean isValidMove(int row, int col);

    /**
     * Used after checking if move is valid. Places x or o on the board.
     * Maybe should be modified to return a copy of the board which
     * includes the additional move.
     * @param mark
     * @param row
     * @param col
     * @return
     */
    void placeMark(String mark, int row, int col);

    /**
     * Can be used to keep ongoing count of taken cells for
     * quick reference. Every time a mark is placed number of
     * empty cells go down from 9 to 0. When 0 it should be
     * a base case an a winner or draw should be checked
     * @return
     */
    boolean hasEmptyCells();

    /**
     * Prints board to the console. Probably double for loop
     * for rows and columns
     */
    void printBoard();
}
