package apollon.hwang.junit;

import org.junit.*;

public class ExecutionSequenceTest {

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

    @Test
    public void testImport() {
        System.out.println("testImport");
    }

    @Ignore
    @Test
    public void testValidate() {
        System.out.println("testValidate");
    }

    @Test
    public void testExport() {
        System.out.println("testExport");
    }
}
