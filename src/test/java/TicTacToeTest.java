import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TicTacToeTest {

    @Test
    public  void createGameBoard(){
        char[][] gameBoard = mockGameBoard();
        TicTacToe.createGameBoard(gameBoard);
        assertTrue(true);
    }

    @Test
    public void takePlayerInput(){
        char[][] gameBoard = mockGameBoard();
        TicTacToe.placePiece(gameBoard,5,"player");
        assertEquals(gameBoard[2][2],'X');
    }

    @Test
    public void placePlayerChoiceToGameBoard(){
        char[][] gameBoard = mockGameBoard();
        TicTacToe.placePiece(gameBoard,1,"player");
        assertEquals(gameBoard[0][0],'X');
    }

    @Test
    public void placeCPUChoiceToGameBoard(){
        char[][] gameBoard = mockGameBoard();
        TicTacToe.placePiece(gameBoard,1,"cpu");
        assertEquals(gameBoard[0][0],'O');
    }

    @Test
    public void placePostionForPlayerAndCPU(){
        char[][] gameBoard = mockGameBoard();
        TicTacToe.placePiece(gameBoard,9,"cpu");
        TicTacToe.placePiece(gameBoard,1,"player");
        assertEquals(gameBoard[0][0],'X');
        assertEquals(gameBoard[4][4],'O');
    }

    @Test
    public void playerPlacesFirstColums(){
        char[][] gameBoard = mockGameBoard();
        TicTacToe.placePiece(gameBoard,7,"player");
        TicTacToe.placePiece(gameBoard,4,"player");
        TicTacToe.placePiece(gameBoard,1,"player");

        TicTacToe.createGameBoard(gameBoard);

        assertEquals(gameBoard[0][0],'X');
        assertEquals(gameBoard[4][0],'X');
        assertEquals(gameBoard[4][0],'X');
    }

    @Test
    public void playerWonPlacingSymbolinVerticalLine(){
        char[][] gameBoard = mockGameBoard();
        TicTacToe.placePiece(gameBoard,7,"player");
        TicTacToe.placePiece(gameBoard,4,"player");
        TicTacToe.placePiece(gameBoard,1,"player");

        TicTacToe.placePiece(gameBoard,3,"cpu");
        TicTacToe.placePiece(gameBoard,5,"cpu");
        TicTacToe.placePiece(gameBoard,9,"cpu");

        TicTacToe.createGameBoard(gameBoard);

        String result = TicTacToe.checkWinner();
        System.out.println(result);
        assertEquals(result,"Congratulations you won!");
    }


    @Test
    public void WinnerPositionsCriteriaChecks(){
        List<List> winnerPos = TicTacToe.getWinnerPositions();
        List topRow = Arrays.asList(1,2,3);
        assertEquals(winnerPos.get(0),topRow);

        List middleRow = Arrays.asList(4,5,6);
        assertEquals(winnerPos.get(1),middleRow);

        List bottomRow = Arrays.asList(7,8,9);
        assertEquals(winnerPos.get(2),bottomRow);

        List leftColumn = Arrays.asList(1,4,7);
        assertEquals(winnerPos.get(3),leftColumn);

        List middleColumn = Arrays.asList(2,5,8);
        assertEquals(winnerPos.get(4),middleColumn);

        List rightColumn = Arrays.asList(3,6,9);
        assertEquals(winnerPos.get(5),rightColumn);

        List diagonalLeft = Arrays.asList(1,5,9);
        assertEquals(winnerPos.get(6),diagonalLeft);

        List diagonalRight = Arrays.asList(7,5,3);
        assertEquals(winnerPos.get(7),diagonalRight);

    }

    @Test
    public void checkWinner(){
       char[][] gameBoard = mockGameBoard();
       TicTacToe.placePiece(gameBoard,7,"player");
       TicTacToe.placePiece(gameBoard,4,"player");
       TicTacToe.placePiece(gameBoard,1,"player");
       TicTacToe.placePiece(gameBoard,3,"cpu");
       TicTacToe.placePiece(gameBoard,5,"cpu");
       TicTacToe.placePiece(gameBoard,9,"cpu");
       assertEquals(gameBoard[0][0],'X');
       assertEquals(gameBoard[4][0],'X');
       assertEquals(gameBoard[4][0],'X');
       assertEquals(gameBoard[0][0],'O');
       assertEquals(gameBoard[4][0],'O');
       assertEquals(gameBoard[4][0],'O');
   }

    private char[][] mockGameBoard() {
        char[][] gameBoard = {{' ','|',' ','|',' '},
                {'-','+','-','+','-'},
                {' ','|',' ','|',' '},
                {'-','+','-','+','-'},
                {' ','|',' ','|',' '}
        };
        return gameBoard;
    }
}
