import java.util.*;

class TicTacToe {

    static ArrayList<Integer> playerPostions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();

    public static void main(String[] args) {
        startTicTacToeGame();
    }

    private static void startTicTacToeGame() {
        char[][] gameBoard = fetchGameBoard();

        // Creating a Game Board
        createGameBoard(gameBoard);

        //Prompt the user continuously for next position until game ends
        while(true){
            playerXMakesMove(gameBoard);

            cpuOMakesMove(gameBoard);

            //Checking the winner of the gane
            String result = checkWinner();

            //exiting once you won
            exitGame(result);
        }
    }

    private static char[][] fetchGameBoard() {
        char[][] gameBoard = {{' ','|',' ','|',' '},
                {'-','+','-','+','-'},
                {' ','|',' ','|',' '},
                {'-','+','-','+','-'},
                {' ','|',' ','|',' '}
        };
        return gameBoard;
    }

    private static void cpuOMakesMove(char[][] gameBoard) {
        //Letting CPU choose random position out of 9 available positions
        Random random = new Random();
        int cpuPos = random.nextInt(9)+1;
        //TODO: Need to remove -- For Test Purpose Only -- Dead Code --
        //System.out.println("BOT Entered at Postion : " + cpuPos);

        //Checking if the cpu entered in occupied positions both by cpu as well as player X
        while(playerPostions.contains(cpuPos) || cpuPositions.contains(cpuPos) ){
            //TODO: Need to remove -- For Test Purpose Only -- Dead Code --
            //System.out.println("Position taken! Entering a new positions");
            cpuPos = random.nextInt(9) + 1;
        }

        //Adding CPU as Player to the Game
        placePiece(gameBoard, cpuPos,"cpu");

        //Display the existing board
        createGameBoard(gameBoard);
    }

    private static void playerXMakesMove(char[][] gameBoard) {
        //Take User Input
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your position (1-9):");
        int playerPos = scan.nextInt();

        //TODO: Need to remove -- For Test Purpose Only -- Dead Code --
        //System.out.println("Player X Entered @ position : " + playerPos);

        //Checking if the player X entered in wrong position, occupied positions both by cpu as well as player X
        while(playerPostions.contains(playerPos) || cpuPositions.contains(playerPostions) ){
            System.out.println("Position is taken ! Please Enter a Correct Positions");
             playerPos = scan.nextInt();
        }

        // Placing cross to players selected position
        placePiece(gameBoard, playerPos,"player");
    }

    private static void exitGame(String result) {
        if(result.length()>0){
            System.out.println(result);
            System.exit(0);
        }
    }


    public static String checkWinner(){
        List<List> winningCriteriaList = getWinnerPositions();

        // Checking for each wining criteria if plaues have reached the position combination
        for(List winningCriteria : winningCriteriaList){
             if(playerPostions.containsAll(winningCriteria)){
                 return "Congratulations you won!";
             }else if(cpuPositions.containsAll(winningCriteria)){
                 return "CPU wins! Better Luck Next Time";
             }else if(playerPostions.size() + cpuPositions.size() ==9){
                 return "DRAW!!!";
             }
         }

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

    public static void placePiece(char[][] gameBoard, int position, String user){

        char symbol = ' ';

        if(user.equals("player")){
            symbol ='X';
            // keeping track of Player Postion as we play
            playerPostions.add(position);
        }else if(user.equals("cpu")){
            symbol = 'O';
            //keeping track of CPU position as we play
            cpuPositions.add(position);
        }

        switch (position) {
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
