public class Controller {
    private final Output out;
    private final Input in;

    BoardState board = new BoardState();
    GameState game = new GameState(1);
    VictoryChecker victory = new VictoryChecker();


    Controller(Input in, Output out) {
        this.in = in;
        this.out = out;
    }

    public void run(){
        printBoard();
        printPlayerMovePrompt();
        if (board.getBoard().containsValue("")) {
            newMove();
            if (!victory.check(board.getBoardArray())) {
                game.switchPlayer();
                run();
            } else {
                printBoard();
                printWinningPlayerMessage();
                out.print("Game Over");
                //todo add draw output
            }
        }

    }

    //Could make private?
    public void newMove() {
        //todo get rid of board from move verifier?
        MoveVerifier move = new MoveVerifier(in, board);//should this live here?
        board.updateBoard(move.getValidMove(), game.getPlayer());
    }

    private void printBoard() {
        out.printBoard(board.getBoard());
    }

    private void printPlayerMovePrompt(){
        out.printPlayer(game.getPlayer());
    }

    private void printWinningPlayerMessage(){
        out.printWinningPlayer(game.getPlayer());
    }
}
