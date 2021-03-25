import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MoveVerifierTest {
    @Mock
    private Input in;

    @Test
    public void shouldReturnMoveWhenValidInput(){
        MoveVerifier move = new MoveVerifier(in);
        Map<String, String> board = new HashMap<>(){{
            put("A1", "");put("A2", "");put("A3", "");
            put("B1", "");put("B2", "");put("B3", "");
            put("C1", "");put("C2", "");put("C3", "");
        }};
        when(in.readString(anyString())).thenReturn("A1");

        String actualMove = move.getValidMove(board);

        verify(in, times(1)).readString(anyString());
        assertThat(actualMove).isEqualTo("A1");
    }

    @Test
    public void shouldRecallMethodWhenInvalidInput(){
        MoveVerifier move = new MoveVerifier(in);
        Map<String, String> board = new HashMap<>(){{
            put("A1", "");put("A2", "");put("A3", "");
            put("B1", "");put("B2", "");put("B3", "");
            put("C1", "");put("C2", "");put("C3", "");
        }};
        when(in.readString(anyString())).thenReturn("test").thenReturn("A1");

        String actualMove = move.getValidMove(board);

        verify(in, times(2)).readString(anyString());
        assertThat(actualMove).isEqualTo("A1");
    }

    @Test
    public void shouldRecallMethodWhenMoveHasBeenTaken(){
        MoveVerifier move = new MoveVerifier(in);
        Map<String, String> board = new HashMap<>(){{
            put("A1", "X");put("A2", "");put("A3", "");
            put("B1", "");put("B2", "");put("B3", "");
            put("C1", "");put("C2", "");put("C3", "");
        }};
        when(in.readString(anyString())).thenReturn("A1").thenReturn("A2");

        String actualMove = move.getValidMove(board);

        verify(in, times(2)).readString(anyString());
        assertThat(actualMove).isEqualTo("A2");
    }
}