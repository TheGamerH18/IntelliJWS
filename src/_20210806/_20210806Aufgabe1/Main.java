package _20210806._20210806Aufgabe1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int inputnumber = scan.nextInt();

        if(inputnumber < 10) print("kleiner zehn");
        else if(inputnumber < 20) print("zwischen 10 und 20");
        else if(inputnumber < 100) print("zwischen 10 und 99");
        else print("größer 100");
    }

    public static void print(String text) {
        System.out.println(text);
    }
}
