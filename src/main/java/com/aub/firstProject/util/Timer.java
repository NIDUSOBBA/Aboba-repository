package com.aub.firstProject.util;

import java.time.LocalDateTime;

public class Timer {

    public static void timerFiveSeconds(){
        LocalDateTime targetTime = LocalDateTime.now().plusSeconds(5);
        while (LocalDateTime.now().isBefore(targetTime)) {
        }
        System.out.println("Пять секунд прошло!");
    }
}
