package domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import static org.junit.Assert.*;

public class MovieTest {
    String validName = "";

    @Before
    public void setUp() throws Exception {
        validName = "MovieTitle";
    }

    @Test
    public void test_Movie_MetGeldigeParameter_MaaktMovieAan() {
        new Movie(validName);
    }
}