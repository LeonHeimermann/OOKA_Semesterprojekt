package org.ooka.msauxiliarysystems;

public class Algorithm extends Thread {

    public void run() {
        try {
            System.out.println("Algorithm started");
            int duration = (int) (Math.random()*3000)+1500; // random duration between 1.5 and 4.5 seconds
            Thread.sleep(duration);

            boolean algorithmSucceeded = Math.random() <= 0.7; // simulate errors in calculation
            if (algorithmSucceeded) {
                System.out.println("Algorithm completed");
                // send message with kafka that algorithm completed
            } else {
                System.out.println("Algorithm failed");
                // send message with kafka that algorithm failed
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
