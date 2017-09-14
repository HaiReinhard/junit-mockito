package apollon.hwang.mockito;

import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

public class MockTest {

    private Reader reader;

    @Before
    public void setUp() {
        reader = mock(Reader.class);
    }

    @Test
    public void testThenAnswer() {
        when(reader.read()).thenAnswer(new Answer<String>() {
            @Override
            public String answer(InvocationOnMock invocationOnMock) throws Throwable {
                System.out.println(Arrays.toString(invocationOnMock.getArguments()));
                System.out.println(invocationOnMock.getMethod().getName());
                System.out.println(invocationOnMock.getMock().toString());
                return "answered";
            }
        });

        reader.read();
    }

    @Test
    public void testDoAnswerList() {
        final List<String> list = mock(List.class);
        doAnswer(invocationOnMock -> {
            final int index = (int)invocationOnMock.getArguments()[0];
            return index % 2 == 0 ? "good" : "bad";
        }).when(list).get(anyInt());
        doReturn(5).when(list).size();

        for (int i = 0; i < list.size(); i ++) {
            System.out.println(list.get(i));
        }
    }

    @Test
    public void testThenChain() {
        //reader = mock(FileReader.class);
        when(reader.read()).thenReturn("1", "2").thenThrow(new NullPointerException("3"))
                .thenCallRealMethod().thenReturn("4", "5");
        for (int i = 0; i < 8; i ++) {
            try {
                System.out.println(reader.read());
            } catch (NullPointerException e) {
                System.out.println(e.toString());
            }
        }
    }
}
