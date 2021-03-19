import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class VictoryCheckerTest {

    @Test
    public void shouldReturnTrueWhenFirstRowVictory() {
        VictoryChecker victoryChecker = new VictoryChecker();
        String[][] board = new String[][]{
                {"X", "X", "X"},
                {"", "", ""},
                {"", "", ""}
        };

        boolean isVictory = victoryChecker.check(board);

        assertThat(isVictory).isTrue();
    }

    @Test
    public void shouldReturnFalseWhenEmpty() {
        VictoryChecker victoryChecker = new VictoryChecker();
        String[][] board = new String[][]{
                {"", "", ""},
                {"", "", ""},
                {"", "", ""}
        };

        boolean isVictory = victoryChecker.check(board);

        assertThat(isVictory).isFalse();
    }

    @Test
    public void shouldReturnTrueWhenSecondRowVictory() {
        VictoryChecker victoryChecker = new VictoryChecker();
        String[][] board = new String[][]{
                {"", "", ""},
                {"X", "X", "X"},
                {"", "", ""}
        };

        boolean isVictory = victoryChecker.check(board);

        assertThat(isVictory).isTrue();
    }

    @Test
    public void shouldReturnTrueWhenLastRowVictoryNaughts() {
        VictoryChecker victoryChecker = new VictoryChecker();
        String[][] board = new String[][]{
                {"", "", ""},
                {"", "", ""},
                {"O", "O", "O"}
        };

        boolean isVictory = victoryChecker.check(board);

        assertThat(isVictory).isTrue();
    }

    @Test
    public void shouldReturnTrueWhenFirstColumnVictory() {
        VictoryChecker victoryChecker = new VictoryChecker();
        String[][] board = new String[][]{
                {"X", "", ""},
                {"X", "", ""},
                {"X", "O", "O"}
        };

        boolean isVictory = victoryChecker.check(board);

        assertThat(isVictory).isTrue();
    }

    @Test
    public void shouldReturnTrueWhenSecondColumnVictory() {
        VictoryChecker victoryChecker = new VictoryChecker();
        String[][] board = new String[][]{
                {"X", "O", ""},
                {"", "O", ""},
                {"X", "O", "O"}
        };

        boolean isVictory = victoryChecker.check(board);

        assertThat(isVictory).isTrue();
    }

    @Test
    public void shouldReturnTrueWhenMainDiagonalVictory() {
        VictoryChecker victoryChecker = new VictoryChecker();
        String[][] board = new String[][]{
                {"X", "", ""},
                {"X", "X", ""},
                {"", "O", "X"}
        };

        boolean isVictory = victoryChecker.check(board);

        assertThat(isVictory).isTrue();
    }

    @Test
    public void shouldReturnTrueWhenCounterDiagonalVictory() {
        VictoryChecker victoryChecker = new VictoryChecker();
        String[][] board = new String[][]{
                {"X", "", "O"},
                {"X", "O", ""},
                {"O", "O", ""}
        };

        boolean isVictory = victoryChecker.check(board);

        assertThat(isVictory).isTrue();
    }
}