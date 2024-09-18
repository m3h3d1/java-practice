package mutithreading.multithreaded_numbers;

public class PrintOddEven {
    public static void main(String args[]) {
        Thread number1 = new Thread(new PrintOdds(30));
        number1.start();
        Thread number2 = new Thread(new PrintEvens(30));
        number2.start();
    }
}

class PrintOdds implements Runnable {
    private int bound;

    public PrintOdds(int b) {
        bound = b;
    }

    public void run() {
        for (int k = 1; k <= bound; k += 2)
            System.out.print(k + " ");
    }
}

class PrintEvens implements Runnable {
    private int bound;

    public PrintEvens(int b) {
        bound = b;
    }

    public void run() {
        for (int k = 2; k <= bound; k += 2)
            System.out.print(k + " ");
    }
}
