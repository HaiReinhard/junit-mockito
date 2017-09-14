package apollon.hwang.mockito;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class MatchersTest {

    private Worker worker;

    @Before
    public void setUp() {
        worker = mock(Worker.class);
    }

    @Test
    public void testAnyVararg() {
        doReturn("correct").when(worker).work("correct", anyVararg());
        // doReturn("correct").when(worker).work(eq("correct"), anyVararg());

        System.out.println(worker.work("correct", 1, 2));
        System.out.println(worker.work("correct", 1, 2, 3, 4));
        System.out.println(worker.work("wrong", 1, 2));
        System.out.println(worker.work("any", 1, 2, 3, 4));
    }

    @Test
    public void testDoubleThat() {
        doReturn("correct").when(worker).process(doubleThat(Matchers.lessThan(5d)));

        System.out.println(worker.process(3d));
        System.out.println(worker.process(7d));
    }

    @Test
    public void testIsNull() {
        doReturn("correct").when(worker).work(isNull(String.class), anyVararg());

        System.out.println(worker.work(null, 1, 2));
        System.out.println(worker.work("correct", 1, 2, 3, 4));
    }
}
