package apollon.hwang.mockito;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class ImporterUniTest {

    @Spy
    @InjectMocks
    private Importer classUnderTest;

    @Mock
    private Reader reader;

    @Mock
    private Validator validator;

    @Test
    public void testImport_success() {
        doReturn("success").when(reader).read();
        doReturn(true).when(validator).validate(anyString());

        String result = classUnderTest.importText();

        assertThat("Wrong imported text.", result, Matchers.is("success"));
    }

    @Test(expected = IllegalStateException.class)
    public void testImport_invalid() {
        doReturn(false).when(validator).validate(anyString());

        classUnderTest.importText();
    }

    @Test
    public void testImportAndTrim() {
        doReturn("   text  ").when(classUnderTest).importText();

        String result = classUnderTest.importAndTrim();

        assertThat("The text should be trimmed.", result, Matchers.is("text"));
    }
}
