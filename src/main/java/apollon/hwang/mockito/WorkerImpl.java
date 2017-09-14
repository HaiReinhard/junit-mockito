package apollon.hwang.mockito;

public class WorkerImpl implements Worker {
    @Override
    public String work(String str, int... ids) {
        System.out.println("work runs");
        throw new UnsupportedOperationException("Work");
    }

    @Override
    public String process(double weight) {
        System.out.println("process runs");
        return "Weight:  " + weight;
    }
}
