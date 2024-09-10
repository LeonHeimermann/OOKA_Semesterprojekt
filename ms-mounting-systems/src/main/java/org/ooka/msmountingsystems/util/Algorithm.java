package org.ooka.msmountingsystems.util;

import lombok.Getter;

@Getter
public class Algorithm {

    private String result;

    public void run() {
        try {
            System.out.println("Algorithm started");
            int duration = (int) (Math.random()*3000)+1500; // random duration between 1.5 and 4.5 seconds
            Thread.sleep(duration);

            boolean algorithmSucceeded = Math.random() <= 0.7; // simulate errors in calculation
            if (algorithmSucceeded) {
                System.out.println("Algorithm completed");
                result = "success";
            } else {
                System.out.println("Algorithm failed");
                result = "failed";
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
