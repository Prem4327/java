class MyThread extends Thread {

    public void run() {
        System.out.println("Thread Priority: " + getPriority());
    }
}

public class Main {
    public static void main(String[] args) {

        MyThread t1 = new MyThread();

        t1.setPriority(8);
        t1.start();
    }
}