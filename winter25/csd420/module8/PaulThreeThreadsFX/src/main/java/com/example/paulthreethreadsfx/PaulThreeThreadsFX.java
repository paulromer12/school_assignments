package com.example.paulthreethreadsfx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PaulThreeThreadsFX extends Application {
    private static final int COUNT = 10001;
    private TextArea textArea;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        textArea = new TextArea();
        textArea.setEditable(false);

        // Create a VBox and allow the TextArea to grow to fill available space.
        VBox root = new VBox(textArea);
        VBox.setVgrow(textArea, Priority.ALWAYS);

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("Thread Output");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Create and start threads.
        WorkerThread letterThread = new WorkerThread('L');
        WorkerThread numberThread = new WorkerThread('N');
        WorkerThread specialThread = new WorkerThread('S');

        letterThread.setName("LetterThread");
        numberThread.setName("NumberThread");
        specialThread.setName("SpecialThread");

        letterThread.start();
        numberThread.start();
        specialThread.start();
    }

    // Inner class for our worker threads.
    private class WorkerThread extends Thread {
        private char type;

        public WorkerThread(char type) {
            this.type = type;
        }

        @Override
        public void run() {
            switch (type) {
                case 'L': // Letters
                    for (int i = 0; i < COUNT; i++) {
                        char c = (char)(Math.random() * 26 + 'a');
                        final String output = Thread.currentThread().getName() + i + ": " + c + "\n";
                        Platform.runLater(() -> textArea.appendText(output));
                    }
                    break;

                case 'N': // Numbers
                    for (int i = 0; i < COUNT; i++) {
                        int n = (int)(Math.random() * 10);
                        final String output = Thread.currentThread().getName() + i + ": " + n + "\n";
                        Platform.runLater(() -> textArea.appendText(output));
                    }
                    break;

                case 'S': // Special characters
                    char[] specialChars = {'!', '@', '#', '$', '%', '&', '*'};
                    for (int i = 0; i < COUNT; i++) {
                        char sc = specialChars[(int)(Math.random() * specialChars.length)];
                        final String output = Thread.currentThread().getName() + i + ": " + sc + "\n";
                        Platform.runLater(() -> textArea.appendText(output));
                    }
                    break;
            }
        }
    }
}