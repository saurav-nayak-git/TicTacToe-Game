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
        // Creating a Game Board
        createGameBoard(gameBoard);

        //Take User Input
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your position (1-9):");
        int position = scan.nextInt();

        System.out.println("you crossed Postion : " + position);

        // Placing cross to players selected position
        TicTacToe.placePiece(gameBoard, position,"player");

        //Adding CPU as Player to the Game
        TicTacToe.placePiece(gameBoard, 9,"cpu");

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

    public static void placePiece(char[][] gameBoard, int pos, String user){

        char symbol = ' ';

        if(user.equals("player")){
            symbol ='X';
        }else if(user.equals("cpu")){
            symbol = 'O';
        }

        switch (pos) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[3][0] = symbol;
                break;
            case 8:
                gameBoard[3][2] = symbol;
                break;
            case 9:
                gameBoard[3][4] = symbol;
                break;
            default:
                break;
        }
    }
}
