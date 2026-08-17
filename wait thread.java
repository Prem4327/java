class Test {
    public static void main(String[] args) {

        Test obj = new Test();

        synchronized (obj) {
            try {
                System.out.println("Waiting...");
                obj.wait(2000);   // Wait for 2 seconds
                System.out.println("Finished waiting");
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}