package mutithreading.cooperating_threads;

public class TakeANumber {
    private int next = 0;
    private int serving = 0;

    public synchronized int nextNumber(int custId) {
        ++next;
        System.out.println("Customer " + custId + " takes ticket " + next);
        return next;
    }
    public synchronized int nextCustomer() {
        ++serving;
        System.out.println("    Clerk serving ticket " + serving);
        return serving;
    }
    public synchronized boolean customerWaiting() {
        return next > serving;
    }
}
