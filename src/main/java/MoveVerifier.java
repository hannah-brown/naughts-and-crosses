public class MoveVerifier {

    private final Input in;
    private final BoardState board;

    public MoveVerifier(Input in, BoardState board){
        this.in = in;
        this.board = board;
    }

    public String getValidMove(){
        String move = in.readString("Please Enter Move").toUpperCase();

        if(board.getBoard().get(move) == null){
            return getValidMove();
        }
        if(!board.getBoard().get(move).equals("")){
            System.out.println("Move has been taken");
            return  getValidMove();
        }
        return move;
    }
}
