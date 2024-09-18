package mutithreading.cooperating_threads;

public class Clerk implements Runnable {
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
