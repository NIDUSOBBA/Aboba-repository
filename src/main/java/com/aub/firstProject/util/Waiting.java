package com.aub.firstProject.util;

public class Waiting {

    public static void waitFiveSeconds() {
        // поменяй на тред слип
        try {
            Thread.sleep(5000);
            System.out.println("Пять секунд прошло!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // 5 4 3 2 1
}
