package mutithreading.practice1;

class MyThread extends Thread {
    public MyThread() {
        super();
    }

    @Override
    public void run() {
        for(int i=1;i<=10;i++) {
            System.out.println("MyThread" +" => "+i);
            try {
                Thread.sleep(100000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
public class Main {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        for(int i=1;i<=10;i++) {
            System.out.println("Main" + " => "+i);
            try {
                Thread.sleep(100000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
