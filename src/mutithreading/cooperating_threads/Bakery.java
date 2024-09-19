package mutithreading.cooperating_threads;

class TakeANumber {
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
class Customer implements Runnable {
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
            takeANumber.nextNumber(id);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
class Clerk implements Runnable {
    private TakeANumber takeANumber;
    public Clerk(TakeANumber gadget) {
        takeANumber = gadget;
    }
    public void run() {
        while (true) {
            try {
                Thread.sleep((int)(Math.random() * 50));
                if(takeANumber.customerWaiting()) {
                    takeANumber.nextCustomer();
                }
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

public class Bakery {
    public static void main(String[] args) {
        System.out.println("Starting clerk and customer threads");
        TakeANumber gadget = new TakeANumber();
        Thread clerk = new Thread(new Clerk(gadget));
        clerk.start();
        for(int k=0; k<5; k++) {
            Thread customer = new Thread(new Customer(gadget));
            customer.start();
        }
    }
}
