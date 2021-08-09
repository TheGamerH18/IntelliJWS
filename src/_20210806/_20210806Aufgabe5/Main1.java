package _20210806._20210806Aufgabe5;

import _20210806._20210806Aufgabe1.Main;

import java.time.LocalDateTime;

public class Main1 {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        double x = 0;
        double max = 1.79*Math.pow(10, 308);
        for(double i = 4.9*Math.pow(10, -324); i < max; i ++) x = i;
        Main.print(String.valueOf(x));
        LocalDateTime end = LocalDateTime.now();
    }
}
