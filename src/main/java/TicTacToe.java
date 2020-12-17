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

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your position (1-9):");
        int pos = scan.nextInt();

        System.out.println(pos);



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

         switch (pos) {
            case 1:
                gameBoard[0][0] = 'X';
                break;
            case 2:
                gameBoard[0][2] = 'X';
                break;
            case 3:
                gameBoard[0][4] = 'X';
                break;
            case 4:
                gameBoard[2][0] = 'X';
                break;
            case 5:
                gameBoard[2][2] = 'X';
                break;
            case 6:
                gameBoard[2][4] = 'X';
                break;
            case 7:
                gameBoard[3][0] = 'X';
                break;
            case 8:
                gameBoard[3][2] = 'X';
                break;
            case 9:
                gameBoard[3][4] = 'X';
                break;
            default:
                break;
        }
    }
}
