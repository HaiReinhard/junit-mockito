package apollon.hwang.junit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public abstract class TestBase {

    @BeforeClass
    public static void setUpClass() {
        System.out.println("setUpClass");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("tearDownClass");
    }

    @Before
    public void setUp() {
        System.out.println("setUp");
    }

    @After
    public void tearDown() {
        System.out.println("tearDown");
    }
}
