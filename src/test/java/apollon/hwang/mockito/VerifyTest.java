package apollon.hwang.mockito;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import static org.mockito.Matchers.anyDouble;
import static org.mockito.Mockito.*;

public class VerifyTest {

    private Worker worker;

    @Before
    public void setUp() {
        worker = mock(Worker.class);
    }

    @Test
    public void testVerify() {
        worker.process(1d);

        verify(worker).process(anyDouble());
    }

    @Test
    public void testNever() {
        //worker.process(1d);

        verify(worker, never()).process(anyDouble());
    }

    @Test
    public void testInOrder() {
        worker.process(1d);
        worker.process(2d);

        final InOrder inOrder = inOrder(worker);

        inOrder.verify(worker).process(1d);
        inOrder.verify(worker).process(2d);
    }
}
