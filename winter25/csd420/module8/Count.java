// Count class that extends Thread
class Count extends Thread {
    private int start, end; // Variables to store the start and ending values for counting 

    // Constructor to initialize the counting range
    public Count(int start, int end) {
        this.start = start;
        this.end = end;
    }

    // run() method executes when the thread starts
    @Override
    public void run() {
        for (int i = start; i <= end; i++) { // Loop from start to end
            System.out.println(Thread.currentThread().getName() + ": " + i);
            try {
                Thread.sleep(500); // Pause for 500ms to make output readable
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // Create two threads: one counting 1-10, another counting 111-121
        Count count1 = new Count(1, 10);
        Count count2 = new Count(111, 121);

        // Start both threads to run concurrently
        count1.start();
        count2.start();
    }
}