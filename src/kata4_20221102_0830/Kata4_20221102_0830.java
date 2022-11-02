package kata4_20221102_0830;

public class Kata4_20221102_0830 {

    public static void main(String[] args) {
        Iterable<String> items = new EmailLoader(new FileLoader("email.txt")).items();
        Histogram<String> hist = new Histogram<String>();
        for (String item : items) {
            hist.increment(item);
        }
        HistogramDisplay histogramDisplay = new HistogramDisplay(hist,"Histogram Display...");
        histogramDisplay.execute();
    }
    
}
