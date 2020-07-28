import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testMain() throws Exception {
        Main main = new Main();
        Main.main(new String[]{"Hola"});
        assertEquals(2,main.getSesion());
    }
}