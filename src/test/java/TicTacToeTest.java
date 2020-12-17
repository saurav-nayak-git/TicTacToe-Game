import org.junit.Test;
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
        assertEquals(gameBoard[0][0],'X');
        assertEquals(gameBoard[4][0],'X');
        assertEquals(gameBoard[4][0],'X');
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
