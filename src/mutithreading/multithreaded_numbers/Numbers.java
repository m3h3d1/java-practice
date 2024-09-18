package mutithreading.multithreaded_numbers;

public class Numbers {
    public static void main(String[] args) {
        // using thread class
//        for(int i=1;i<=5;++i) {
//            NumberThread number = new NumberThread(i);
//            number.start();
//        }

        // using runnable interface
        for(int i=1;i<=5;i++) {
            Thread number = new Thread(new NumberPrinter(i));
            number.start();
        }
    }
}

class NumberThread extends Thread {
    int num;
    public NumberThread(int n) {
        num = n;
    }
    public void run() {
        for(int i=0;i<20;++i) {
            System.out.print(num);
        }
    }
}

class NumberPrinter implements Runnable {
    private int num;
    public NumberPrinter(int n) {
        num = n;
    }
    public void run() {
        for (int i=0; i<20; i++) {
            System.out.print(num);
        }
    }
}
