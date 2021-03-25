import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;


public class BoardStateTest {

    @Test
    public void updateBoardWithX() {
        BoardState board = new BoardState();
        Map<String, String> expectedBoard = new HashMap<>(){{
            put("A1", "X");put("A2", "");put("A3", "");
            put("B1", "");put("B2", "");put("B3", "");
            put("C1", "");put("C2", "");put("C3", "");
        }};

        board.updateBoard("A1", 1);
        assertEquals(board.getBoardMap(), expectedBoard);
    }

    @Test
    public void updateBoardWithXInCentre() {
        BoardState board = new BoardState();
        Map<String, String> expectedBoard = new HashMap<>(){{
            put("A1", "");put("A2", "");put("A3", "");
            put("B1", "");put("B2", "X");put("B3", "");
            put("C1", "");put("C2", "");put("C3", "");
        }};

        board.updateBoard("B2", 1);
        assertEquals(board.getBoardMap(), expectedBoard);
    }

    @Test
    public void updateBoardWithOInCentre() {
        BoardState board = new BoardState();
        Map<String, String> expectedBoard = new HashMap<>(){{
            put("A1", "");put("A2", "");put("A3", "");
            put("B1", "");put("B2", "O");put("B3", "");
            put("C1", "");put("C2", "");put("C3", "");
        }};

        board.updateBoard("B2", 2);
        assertEquals(board.getBoardMap(), expectedBoard);
    }

    @Test
    public void updateBoardWithXAndO() {
        BoardState board = new BoardState();
        Map<String, String> expectedBoard = new HashMap<>(){{
            put("A1", "X");put("A2", "");put("A3", "");
            put("B1", "");put("B2", "O");put("B3", "");
            put("C1", "");put("C2", "");put("C3", "");
        }};

        board.updateBoard("A1", 1);
        board.updateBoard("B2", 2);
        assertEquals(board.getBoardMap(), expectedBoard);
    }

    @Test
    public void toArray() {
        BoardState board = new BoardState();
        board.updateBoard("A1", 1);
        board.updateBoard("B2", 2);
        board.updateBoard("C3", 1);

        String[][] expectedBoardArray = {{"X", "", ""}, {"", "O", ""}, {"", "", "X"}};

        assertThat(board.getBoardArray()).isEqualTo(expectedBoardArray);
    }

    @Test
    public void shouldReturnTrueWhenBoardIsFull() {
        BoardState board = new BoardState();
        board.updateBoard("A1", 1);
        board.updateBoard("A2", 1);
        board.updateBoard("A3", 1);
        board.updateBoard("B1", 1);
        board.updateBoard("B2", 1);
        board.updateBoard("B3", 1);
        board.updateBoard("C1", 1);
        board.updateBoard("C2", 1);
        board.updateBoard("C3", 1);

        assertThat(board.isFull()).isTrue();
    }

    @Test
    public void shouldReturnFalseWhenBoardIsNotFull() {
        BoardState board = new BoardState();
        board.updateBoard("A1", 1);
        board.updateBoard("A2", 1);
        board.updateBoard("A3", 1);
        board.updateBoard("B1", 1);
        board.updateBoard("B2", 1);
        board.updateBoard("B3", 1);
        board.updateBoard("C1", 1);
        board.updateBoard("C2", 1);

        assertThat(board.isFull()).isFalse();
    }

    @Test
    public void shouldReturnFalseWhenBoardIsEmpty() {
        BoardState board = new BoardState();

        assertThat(board.isFull()).isFalse();
    }
}