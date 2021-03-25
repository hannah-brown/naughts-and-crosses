public class Controller {
    private final Output out;
    private final MoveVerifier move;

    private final BoardState board;
    private final GameState game;
    private final VictoryChecker victory;

    Controller(MoveVerifier move, Output out, BoardState board, GameState game, VictoryChecker victory) {
        this.out = out;
        this.move = move;
        this.board = board;
        this.game = game;
        this.victory = victory;
    }

    public void run(){
        printBoard();
        if(board.isFull()) {
            printDrawMessage();
        } else {
            printPlayerMovePrompt();
            updateBoardWithMove();
            if(isWon()) {
                printWinningPlayerMessage();
            } else {
                game.switchPlayer();
                run();
            }
        }

    }

    private void updateBoardWithMove() {
        board.updateBoard(move.getValidMove(board.getBoardMap()), game.getPlayer());
    }

    private void printBoard() {
        out.printBoard(board.getBoardMap());
    }

    private void printPlayerMovePrompt(){
        out.printPlayer(game.getPlayer());
    }

    private void printWinningPlayerMessage() {
        printBoard();
        out.printWinningPlayer(game.getPlayer());
        out.print("Game Over");
    }

    private void printDrawMessage() {
        out.printDraw();
        out.print("Game Over");
    }

    private boolean isWon() {
        return victory.check(board.getBoardArray());
    }
}
