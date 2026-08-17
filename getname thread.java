class MyThread extends Thread {

    public void run() {
        System.out.println("Thread Name: " + getName());
    }
}

public class Main {
    public static void main(String[] args) {

        MyThread t1 = new MyThread();

        t1.setName("My Thread");
        t1.start();
    }
}