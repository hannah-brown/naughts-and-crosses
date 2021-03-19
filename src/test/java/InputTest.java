import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class InputTest {

    @Test
    public void shouldReadString(){
        Input in = new Input();
        String input = "abc";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        String actualString = in.readString("test");

        assertThat(actualString).isEqualTo("abc");
    }
}