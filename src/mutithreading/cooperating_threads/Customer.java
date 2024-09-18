package mutithreading.cooperating_threads;

public class Customer implements Runnable {
    private static int number = 1000;
    private int id;
    private TakeANumber takeANumber;
    public Customer(TakeANumber gadget) {
        id = ++number;
        takeANumber = gadget;
    }
    public void run() {
        try {
            Thread.sleep((int) (Math.random() * 1000));
            System.out.println("Customer " + id + " takes ticket " + takeANumber.nextNumber());
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
