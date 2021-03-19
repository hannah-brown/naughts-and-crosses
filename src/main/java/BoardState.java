import java.util.HashMap;
import java.util.Map;

public class BoardState {
    // a1 a2 a3
    // b1 b2 b3
    // c1 c2 c3

    Map<String, String> board = new HashMap<>(){{
        put("A1", "");put("A2", "");put("A3", "");
        put("B1", "");put("B2", "");put("B3", "");
        put("C1", "");put("C2", "");put("C3", "");
    }};

    public Map<String, String> getBoard() {
        return board;
    }

    public String[][] getBoardArray() {
        return new String[][]{
                {board.get("A1"), board.get("A2"), board.get("A3")},
                {board.get("B1"), board.get("B2"), board.get("B3")},
                {board.get("C1"), board.get("C2"), board.get("C3")}
        };
    }

    public void updateBoard(String move, int i) {
        if(i == 1){
            board.put(move, "X");
        }else{
            board.put(move, "O");
        }

    }

}
