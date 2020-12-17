
import java.util.*;

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

        //Prompt the user continuously for next position until game ends
        while(true){
            //Take User Input
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter your position (1-9):");
            int playerPosition = scan.nextInt();

            System.out.println("You crossed at Postion : " + playerPosition);

            // Placing cross to players selected position
            TicTacToe.placePiece(gameBoard, playerPosition,"player");

            Random random = new Random();
            int cpuPosition = random.nextInt(9)+1;
            System.out.println("Robot Entered at Postion : " + cpuPosition);

            //Adding CPU as Player to the Game
            TicTacToe.placePiece(gameBoard, cpuPosition,"cpu");

            createGameBoard(gameBoard);

            checkWinner();
        }
    }


    public static String checkWinner(){
        List<List> winning = getWinnerPositions();
        return "";
    }


    public static List<List> getWinnerPositions() {
        // Tracking the Winner positions
        List topRow = Arrays.asList(1,2,3);
        List middleRow = Arrays.asList(4,5,6);
        List bottomRow = Arrays.asList(7,8,9);

        List leftColumn = Arrays.asList(1,4,7);
        List middleColumn = Arrays.asList(2,5,8);
        List rightColumn = Arrays.asList(3,6,9);

        List diagonalLeft = Arrays.asList(1,5,9);
        List diagonalRight = Arrays.asList(7,5,3);

        List<List> winning = new ArrayList<List>();
        winning.add(topRow);
        winning.add(middleRow);
        winning.add(bottomRow);
        winning.add(leftColumn);
        winning.add(middleColumn);
        winning.add(rightColumn);
        winning.add(diagonalLeft);
        winning.add(diagonalRight);
        return winning;
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
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
            default:
                break;
        }
    }
}
