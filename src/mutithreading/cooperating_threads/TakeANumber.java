package mutithreading.cooperating_threads;

public class TakeANumber {
    private int next = 0;
    private int serving = 0;

    public synchronized int nextNumber() {
        ++next;
        return next;
    }
    public int nextCustomer() {
        ++serving;
        return serving;
    }
    public boolean customerWaiting() {
        return next > serving;
    }
}
