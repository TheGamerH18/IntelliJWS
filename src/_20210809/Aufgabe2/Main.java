package _20210809.Aufgabe2;

import tools.Tools;

import java.util.Arrays;
import java.util.Random;

public class Main {
    Tools tools = new Tools();

    private int[] lottoListe;

    public Main() {
        lottozahlenerzeugen();
        while(tools.checkfordoubles(lottoListe)) {
            tools.print("renew");
            lottozahlenerzeugen();
        }
        tools.print(Arrays.toString(lottoListe));
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

    public static void main(String[] args) {
        Main main = new Main();
    }
}
