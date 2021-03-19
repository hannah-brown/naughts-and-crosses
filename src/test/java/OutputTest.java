import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputTest {

    private static final Output out = new Output();
    private static ByteArrayOutputStream bo;

    @Before
    public void setUp() {
        bo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bo));
    }

    @Test
    public void shouldCallSystemOutPrint() throws IOException {
        out.print("test");

        bo.flush();
        String allWrittenLines = new String(bo.toByteArray());

        assertThat(allWrittenLines).isEqualTo("test\n");
    }


    @Test
    public void shouldCallSystemOutPrintToPrintBoard() throws IOException {
        Map<String, String> board = new HashMap<>(){{
            put("A1", "X");put("A2", "");put("A3", "");
            put("B1", "");put("B2", "");put("B3", "");
            put("C1", "");put("C2", "");put("C3", "");
        }};

        String expectedOutput =
                "    1  2  3\n" +
                "A   X |  | \n" +
                "   ---------\n" +
                "B    |  | \n" +
                "   ---------\n" +
                "C    |  | \n";

        out.printBoard(board);

        bo.flush();
        String allWrittenLines = new String(bo.toByteArray());

        assertThat(allWrittenLines).isEqualTo(expectedOutput);
    }

    @Test
    public void shouldPrintPlayer() throws IOException {

        out.printPlayer(1);

        bo.flush();
        String allWrittenLines = new String(bo.toByteArray());

        assertThat(allWrittenLines).isEqualTo("Player 1's move\n");
    }

    @Test
    public void shouldPrintWinningPlayerMessage() throws IOException {

        out.printWinningPlayer(1);

        bo.flush();
        String allWrittenLines = new String(bo.toByteArray());

        assertThat(allWrittenLines).isEqualTo("Player 1 wins\n");
    }

}