package apollon.hwang.mockito;

public class FileReader implements Reader{

    @Override
    public String read() {
        return "File Content.";
    }
}
