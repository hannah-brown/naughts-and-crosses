import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MoveVerifierTest {
    @Mock
    private Input in;

    @Test
    public void shouldReturnMoveWhenValidInput(){
        BoardState board = new BoardState();
        MoveVerifier move = new MoveVerifier(in, board);
        when(in.readString(anyString())).thenReturn("A1");

        String actualMove = move.getValidMove();

        verify(in, times(1)).readString(anyString());
        assertThat(actualMove).isEqualTo("A1");
    }

    @Test
    public void shouldRecallMethodWhenInvalidInput(){
        BoardState board = new BoardState();
        MoveVerifier move = new MoveVerifier(in, board);
        when(in.readString(anyString())).thenReturn("test").thenReturn("A1");

        String actualMove = move.getValidMove();

        verify(in, times(2)).readString(anyString());
        assertThat(actualMove).isEqualTo("A1");
    }

    @Test
    public void shouldRecallMethodWhenMoveHasBeenTaken(){
        BoardState board = new BoardState();
        board.updateBoard("A1", 1);
        MoveVerifier move = new MoveVerifier(in, board);
        when(in.readString(anyString())).thenReturn("A1").thenReturn("A2");

        String actualMove = move.getValidMove();

        verify(in, times(2)).readString(anyString());
        assertThat(actualMove).isEqualTo("A2");
    }
}