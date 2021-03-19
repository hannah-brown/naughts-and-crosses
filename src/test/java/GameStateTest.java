import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameStateTest {

    @Test
    public void switchPlayer() {
        GameState game = new GameState(1);

        game.switchPlayer();

        assertThat(game.getPlayer()).isEqualTo(2);
    }

    @Test
    public void switchPlayerTwice() {
        GameState game = new GameState(1);

        game.switchPlayer();
        game.switchPlayer();

        assertThat(game.getPlayer()).isEqualTo(1);
    }
}