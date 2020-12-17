import java.util.Scanner;

class TicTacToe {

    public static void main(String[] args) {
        startTicTacToeGame();
    }

    private static void startTicTacToeGame() {
        char[][] gameBoard = {{' ','|',' ','|',' '},
                {'-','+','-','+','-'},
                {' ','|',' ','|',' '},
                {'-','+','-','+','-'},
                {' ','|',' ','|',' '}
        };

        createGameBoard(gameBoard);

    }

    public static void createGameBoard(char[][] gameBoard) {
        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
