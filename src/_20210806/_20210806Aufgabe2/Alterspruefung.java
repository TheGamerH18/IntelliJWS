package _20210806._20210806Aufgabe2;

import _20210806._20210806Aufgabe1.Main;

public class Alterspruefung {
    public static void main(String[] args) {
        Alterspruefung obj = new Alterspruefung();
        obj.alterPruefen(17);
    }

    public void alterPruefen(int alter){
        if(alter < 18) Main.print("Du bist noch nicht volljährig");
        else Main.print("Du bist schon 18");
        if(alter >= 14 && alter <16) Main.print("Du darfst Mofa fahren aber nicht Moped");
        if(alter < 14) Main.print("Du darfst noch nicht Mofa fahren");
        if(alter < 18 && alter >= 16) Main.print("Du darfst Moped fahren aber nicht Auto");
        if(alter >= 18) Main.print("Du darfst endlich Auto fahren");
    }
}
