package _20210817;

import tools.Tools;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Rezeption {

    Tools tools = new Tools();

    int gastid = 0;
    Zimmer[] zimmer = new Zimmer[30];
    ArrayList<Gast> gaeste = new ArrayList<>();

    public Rezeption(){
        Random random = new Random();
        for (int i = 0; i < zimmer.length; i++) {
            int ettage = (i > 15) ? 1 : 2;
            zimmer[i] = new Zimmer(random.nextInt(10) + 1, ettage, String.valueOf(ettage) + String.valueOf(i));
        }
    }

    public void command(String command) {
        String[] befehl = command.split(" ");
        switch (befehl[0]) {
            case "neuergast" -> neuergast(befehl[1]);
            case "einchecken" -> einchecken(befehl[1]);
        }
    }

    private void neuergast(String name) {
        gaeste.add(new Gast(gastid, name));
    }

    private void einchecken(String Gastname) {
        Gast gast = getGastbyName(Gastname);
        Zimmer raum = getfreienraum();
        int id;
        if(gast != null && raum != null) id = gast.getId();
        else return;
        if(raum.addguest(id)) tools.print(">> " + Gastname + " eingecheckt in raum nummer");
    }

    private Zimmer getfreienraum() {
        for (Zimmer zimmer1 : zimmer) {
            if(zimmer1.freiebetten()>0) return zimmer1;
        }
        return null;
    }

    private Gast getGastbyName(String Gastname) {
        for (Gast gast : gaeste) {
            if(gast.getName().equals(Gastname)) return gast;
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Rezeption obj = new Rezeption();
        while(true) {
            obj.command(scanner.nextLine());
        }
    }
}
