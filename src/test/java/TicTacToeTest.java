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
        TicTacToe.placePiece(gameBoard,1,"saurav");
        assertEquals(gameBoard[0][0],'X');
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
