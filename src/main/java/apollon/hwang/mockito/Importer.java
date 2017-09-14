package apollon.hwang.mockito;

public class Importer {

    private Reader reader;

    private Validator validator;

    public Importer() {
        reader = new FileReader();
        validator = new Validator();
    }

    public String importText() {
        final String text = reader.read();
        if (validator.validate(text)) {
            return text;
        } else {
            throw new IllegalStateException("Invalid text.");
        }
    }

    public String importAndTrim() {
        return importText().trim();
    }
}
