import java.util.Map;

public class MoveVerifier {

    private final Input in;

    public MoveVerifier(Input in){
        this.in = in;
    }

    public String getValidMove(Map<String, String> board){
        String move = in.readString("Please Enter Move").toUpperCase(); //a2 = ""

        if(board.get(move) == null){
            return getValidMove(board);
        }
        if(!board.get(move).equals("")){
            System.out.println("Move has been taken");
            return  getValidMove(board);
        }
        return move;
    }
}
