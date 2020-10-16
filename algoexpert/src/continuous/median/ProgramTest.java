package src.continuous.median;


class ProgramTest {

    public static void main(String[] args) {
        Program.ContinuousMedianHandler handler = new Program.ContinuousMedianHandler();
        handler.insert(5);
        handler.insert(10);
        System.out.println(handler.getMedian());
        handler.insert(100);
        System.out.println(handler.getMedian());

    }
}