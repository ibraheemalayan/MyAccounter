package tasks;

public class Counter implements Runnable {
    private int id, from, to, sleep;
    private ProgressReporter reporter;

    public Counter( int from, int to, int sleep, ProgressReporter reporter) {
        this.from = from;
        this.to = to;
        this.sleep = sleep;
        this.reporter = reporter;

        System.out.println(" started delay=" + sleep);
    }

    @Override
    public void run() {
        for (int i = from; i < to ; i++) {
            try {
                Thread.sleep(sleep);
                reporter.accumulateProgress(1); // this will fire an update to listeners
            } catch (InterruptedException e){

            }
        }

        System.out.println("Thread #" + id + " is completed");
    }
}