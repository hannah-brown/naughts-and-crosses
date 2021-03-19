import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ControllerTest {
    @Mock
    private Output out;

    @Mock
    private Input in;

    @Test
    public void shouldPrintUpdatedBoardAndPlayer() {
        Controller controller = new Controller(in, out);
        when(in.readString(anyString())).thenReturn("A1");
        Map<String, String> expectedBoard = new HashMap<>(){{
            put("A1", "X");put("A2", "");put("A3", "");
            put("B1", "");put("B2", "");put("B3", "");
            put("C1", "");put("C2", "");put("C3", "");
        }};


        controller.newMove();

        verify(in, times(1)).readString("Please Enter Move");
        assertThat(controller.board.getBoard()).containsExactlyEntriesOf(expectedBoard);
        assertThat(controller.game.getPlayer()).isEqualTo(1);
    }

    @Test
    public void shouldRecallRunUntilThreeInARow() {
        Controller controller = new Controller(in, out);
        when(in.readString(anyString()))
                .thenReturn("A1")
                .thenReturn("A2")
                .thenReturn("A3")
                .thenReturn("B1")
                .thenReturn("B2")
                .thenReturn("B3")
                .thenReturn("C1");
        Map<String, String> expectedBoard = new HashMap<>(){{
            put("A1", "X");put("A2", "O");put("A3", "X");
            put("B1", "O");put("B2", "X");put("B3", "O");
            put("C1", "X");put("C2", "");put("C3", "");
        }};

        controller.run();

        verify(out, times(8)).printBoard(anyMap());
        verify(out, times(7)).printPlayer(anyInt());

        //todo test new Move is called right number of times

        assertThat(controller.board.getBoard()).containsExactlyEntriesOf(expectedBoard);
        verify(out, times(1)).printWinningPlayer(1);
        verify(out, times(1)).print("Game Over");
    }
}