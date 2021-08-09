package _20210806._20210806Aufgabe4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        testAufAuswahl(new Scanner(System.in).nextInt());
    }

    private static void testAufAuswahl(int i) {
        if(i > 1000) {
            _20210806._20210806Aufgabe1.Main.print("So große Zahlen kann ich nicht");
            return;
        }
        switch (i) {
            case 0 -> _20210806._20210806Aufgabe1.Main.print("0");
            case 1 -> _20210806._20210806Aufgabe1.Main.print("1");
            default -> _20210806._20210806Aufgabe1.Main.print("2 bis 999");
        }
    }
}
