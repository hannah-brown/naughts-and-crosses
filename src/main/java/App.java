public class App {

    public static void main(String[] args) {
        Output out = new Output();
        Input in = new Input();
        MoveVerifier moveVerifier = new MoveVerifier(in);
        BoardState board = new BoardState();
        GameState game = new GameState(1);
        VictoryChecker victory = new VictoryChecker();
        Controller controller = new Controller(moveVerifier, out, board, game, victory);
        controller.run();
    }
}
