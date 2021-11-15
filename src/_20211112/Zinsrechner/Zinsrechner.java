package _20211112.Zinsrechner;

import tools.Tools;

import java.util.ArrayList;

import static _20210806._20210806Aufgabe1.Main.print;

public class Zinsrechner {
    public static void main(String[] args) {
        Zinser zinser = new Zinser(6, 0.025, 1000);
        ArrayList<String> list = zinser.calculate();
        for (String s : list) {
            print(s);
        }
    }
}
