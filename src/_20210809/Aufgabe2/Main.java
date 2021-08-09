package _20210809.Aufgabe2;

import java.util.Arrays;
import java.util.Random;

public class Main {

    private int[] lottoListe;

    public Main() {
        lottozahlenerzeugen();
        while(checkfordoubles(lottoListe)) {
            print("renew");
            lottozahlenerzeugen();
        }
        print(Arrays.toString(lottoListe));
    }

    /**
     * Generiert die Liste und füllt diese mit zufallszahlen
     */
    private void lottozahlenerzeugen() {
        // Random Generator erstellen
        Random rand = new Random();
        // List Initialisieren
        lottoListe = new int[6];
        // Liste füllen
        for(int i = 0; i < lottoListe.length; i ++)
            lottoListe[i] = rand.nextInt(48)+1;
    }

    private boolean checkfordoubles(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int i1 = 0; i1 < array.length; i1++) {
                if(i1 == i) continue;
                if(array[i] == array[i1]) return true;
            }
        }
        print("text");
        return false;
    }

    private void print(String text) {
        System.out.println(text);
    }

    public static void main(String[] args) {
        Main main = new Main();
    }
}
