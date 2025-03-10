// Paul Romer, CSD420 Module 8

public class PaulThreeThreads2 extends Thread {
    private char type;
    private static final int COUNT = 10001;

    public PaulThreeThreads2(char type) {
        this.type = type;
    }

    @Override
    public void run() {
        switch (type) {
            case 'L': // Letters
                for (int i = 0; i < COUNT; i++) {
                    System.out.print(Thread.currentThread().getName() + i + ": " + 
                        (char)(Math.random() * 26 + 'a') + " ");
                    System.out.println();
                    // try { 
                    //     Thread.sleep(500);
                    // }
                    // catch(InterruptedException e){
                    //     e.printStackTrace();
                    // }
                }
                break;
                
            case 'N': // Numbers
                for (int i = 0; i < COUNT; i++) {
                    System.out.print(Thread.currentThread().getName() + i + ": " + 
                        (int)(Math.random() * 10) + " ");
                    System.out.println();
                    // try { 
                    //     Thread.sleep(500);
                    // }
                    // catch(InterruptedException e){
                    //     e.printStackTrace();
                    // }
                }
                break;
                
            case 'S': // Special characters
                char[] specialChars = {'!', '@', '#', '$', '%', '&', '*'};
                for (int i = 0; i < COUNT; i++) {
                    System.out.print(Thread.currentThread().getName() + i + ": " +
                        specialChars[(int)(Math.random() * specialChars.length)] + " ");
                    System.out.println();
                    // try { 
                    //     Thread.sleep(500);
                    // }
                    // catch(InterruptedException e){
                    //     e.printStackTrace();
                    // }
                }
                break;
        }
    }

    public static void main(String[] args) {
        // Create three threads for different character types
        PaulThreeThreads2 letterThread = new PaulThreeThreads2('L');
        PaulThreeThreads2 numberThread = new PaulThreeThreads2('N');
        PaulThreeThreads2 specialThread = new PaulThreeThreads2('S');

        // Set thread names for identification
        letterThread.setName("LetterThread");
        numberThread.setName("NumberThread");
        specialThread.setName("SpecialThread");

        // Start all threads
        letterThread.start();
        numberThread.start();
        specialThread.start();
    }
}
