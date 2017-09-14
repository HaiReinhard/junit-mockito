package apollon.hwang.mockito;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.anyVararg;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

public class SpyTest {

    private Worker worker;

    @Before
    public void setUp() {
        worker = spy(new WorkerImpl());
    }

    @Test
    public void testDoWhen() {
        doReturn("correct").when(worker).work(anyString(), anyVararg());

        System.out.println(worker.work("1", 2));
        System.out.println(worker.process(5d));
    }

    @Test
    public void testWhenThen() {
        when(worker.work(anyString(), anyVararg())).thenReturn("correct");

        System.out.println(worker.work("1", 2));
        System.out.println(worker.process(5d));
    }
}
