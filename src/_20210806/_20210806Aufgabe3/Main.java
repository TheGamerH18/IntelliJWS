package _20210806._20210806Aufgabe3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int modus = 1;
        if(modus == 0) bis55();
        if(modus == 1) namen();

    }

    private static void bis55(){
        int i = 0;
        while (i <= 55) {
            _20210806._20210806Aufgabe1.Main.print(String.valueOf(i));
            i ++;
        }
    }

    private static void namen() {
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        int number = scan.nextInt();
        if(number >= 500) _20210806._20210806Aufgabe1.Main.print("Maximal 500");
        else{
            int i = 0;
            while(i < number) {
                _20210806._20210806Aufgabe1.Main.print(name);
                i ++;
            }
        }
    }
}
