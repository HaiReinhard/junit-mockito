package apollon.hwang.junit;

import org.junit.Ignore;
import org.junit.Test;

public class AnnotationParamTest {

    @Ignore ("any reasons")
    @Test
    public void testIgnore() {
        System.out.println("test");
    }

    @Test(expected = IllegalStateException.class)
    public void testException() {
        System.out.println("testing...");
        // throw new IllegalStateException("wrong state");
    }

    @Test(timeout = 1000)
    public void testTimeout() {
        while (true);
    }
}
