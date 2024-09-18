package mutithreading.cooperating_threads;

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
