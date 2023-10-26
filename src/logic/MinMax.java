package logic;
import board.Board;
public class MinMax {
    static int[] bestMove = new int[2];
    static int depth;

    private static int minMax(boolean isMaximizing, Board copy, String player, String opponent) {
        if (copy.isWinner("x") || copy.isWinner("o")) {
            return !isMaximizing ? 10 : -10;
        }

        if (copy.isGameOver()) {
            return 0;
        }

        if (isMaximizing) {
            depth++;
            int highestVal = Integer.MIN_VALUE;
            int [] bestMove = new int[2];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (copy.isValidMove(i, j)) {
                        copy.placeMark(player, i, j);
                        int score = minMax(false, copy, player, opponent);
                        if (score > highestVal) {
                            highestVal = score;
                            bestMove[0] = i;
                            bestMove[1] = j;
                        }
                        copy.placeMark(" ", i, j);
                    }
                }
            }
            return --depth == 0 ? Integer.parseInt(bestMove[0] + "" + bestMove[1])  : highestVal;
        }
        else {
            int minScore = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (copy.isValidMove(i, j)) {
                        copy.placeMark(opponent, i, j);
                        minScore = Math.min(minMax(true, copy, player, opponent), minScore);
                        copy.placeMark(" ", i, j);
                    }
                }
            }
            return minScore;
        }
    }
    public static int [] getBestMove(Board board, String player, String opponent) {
        int minmax = minMax(true, board, player, opponent);
        String[] value = String.valueOf(minmax).split("");

        if (value.length == 1) {
            bestMove[0] = 0;
            bestMove[1] = minmax;
        } else {
            bestMove[0] = Integer.parseInt(value[0]);
            bestMove[1] = Integer.parseInt(value[1]);
        }
        return bestMove;
    }

}
