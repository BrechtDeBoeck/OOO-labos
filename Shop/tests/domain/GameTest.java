package domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import static org.junit.Assert.*;

public class GameTest {
    String validName = "";

    @Before
    public void setUp() throws Exception {
        validName = "GameTitel";
    }

    @Test
    public void test_Game_MetGeldigeParameter_MaaktGameAan() {
        new Game(validName);
    }
}