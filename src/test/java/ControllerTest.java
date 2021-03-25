import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ControllerTest {
    @Mock
    private Output out;

    @Mock
    private MoveVerifier move;

    @Mock
    private BoardState board;

    @Mock
    private GameState game;

    @Mock
    private VictoryChecker victory;

    @Test
    public void shouldPrintDrawWhenBoardIsFull(){
        Controller controller = new Controller(move, out, board, game, victory);
        when(board.isFull()).thenReturn(true);

        controller.run();

        verify(out, times(1)).printBoard(anyMap());
        verify(out, times(1)).printDraw();
        verify(out, times(1)).print("Game Over");
    }

    @Test
    public void shouldPrintWinningPlayer(){
        Controller controller = new Controller(move, out, board, game, victory);
        when(board.isFull()).thenReturn(false);
        when(game.getPlayer()).thenReturn(1);
        when(move.getValidMove(anyMap())).thenReturn("A1");
        when(victory.check(any())).thenReturn(true);


        controller.run();

        verify(out, times(2)).printBoard(anyMap());
        verify(out, never()).printDraw();
        verify(out, times(1)).printWinningPlayer(1);
        verify(board, times(1)).updateBoard("A1", 1);
        verify(out, times(1)).print("Game Over");
    }

    @Test
    public void shouldCallRunTwiceWhenLastMoveIsDraw(){
        Controller controller = new Controller(move, out, board, game, victory);
        when(board.isFull()).thenReturn(false).thenReturn(true);
        when(game.getPlayer()).thenReturn(1);
        when(move.getValidMove(anyMap())).thenReturn("A1");
        when(victory.check(any())).thenReturn(false);

        controller.run();

        verify(out, times(2)).printBoard(anyMap());
        verify(out, times(1)).printDraw();
        verify(out, never()).printWinningPlayer(anyInt());
        verify(board, times(1)).updateBoard("A1", 1);
        verify(out, times(1)).print("Game Over");
    }

    @Test
    public void shouldCallRunWhenMoveDidNotWin(){
        Controller controller = new Controller(move, out, board, game, victory);
        when(board.isFull()).thenReturn(false);
        when(game.getPlayer()).thenReturn(1);
        when(move.getValidMove(anyMap())).thenReturn("A1").thenReturn("A2");
        when(victory.check(any())).thenReturn(false).thenReturn(true);

        controller.run();

        verify(out, times(3)).printBoard(anyMap());
        verify(out, never()).printDraw();
        verify(out, times(1)).printWinningPlayer(1);
        verify(board, times(1)).updateBoard("A1", 1);
        verify(board, times(1)).updateBoard("A2", 1);
        verify(out, times(1)).print("Game Over");
    }
}