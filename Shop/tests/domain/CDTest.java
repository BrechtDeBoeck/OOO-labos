package tests.domain;

import domain.CD;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import static org.junit.Assert.*;

public class CDTest {
    String validName = "";

    @Before
    public void setUp() throws Exception {
        validName = "CDTitle";
    }

    @Test
    public void test_CD_MetGeldigeParameter_MaaktCDAan() {
        new CD(validName);
    }
}