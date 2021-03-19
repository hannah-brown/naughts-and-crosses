public class GameState {
    private int player;

    GameState (int player) {
        this.player = player;
    }

    public int getPlayer() {
        return player;
    }

    public void switchPlayer() {
        if(player == 1) {
            this.player = 2;
        } else {
            this.player = 1;
        }
    }
}
