import java.util.Map;

public class Output {

    public void print(String prompt) {
        System.out.println(prompt);
    }

    public void printBoard(Map<String,String> board) {
        System.out.println("    1  2  3");
        System.out.printf("A   %S | %S | %S\n", board.get("A1"), board.get("A2"),board.get("A3"));
        System.out.println("   ---------");
        System.out.printf("B   %S | %S | %S\n", board.get("B1"), board.get("B2"),board.get("B3"));
        System.out.println("   ---------");
        System.out.printf("C   %S | %S | %S\n", board.get("C1"), board.get("C2"),board.get("C3"));
    }

    public void printPlayer(int player) {
        System.out.println("Player " + player + "'s move");
    }

    public void printWinningPlayer(int player) {
        System.out.println("Player " + player + " wins");
    }

    public void printDraw() {
        print("Draw");
    }
}
