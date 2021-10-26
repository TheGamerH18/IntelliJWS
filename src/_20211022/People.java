package _20211022;

import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class People {

    ArrayList<String[]> People = new ArrayList<>();
    Scanner scan = new Scanner(System.in);

    People(){
        System.out.print("Input / I or Output / O?");
        String mode = scan.next();
        switch (mode.toLowerCase()) {
            case ("o") -> output();
            case ("i") -> {
                boolean next = true;
                while (next) {
                    String[] info = getinfo();
                    People.add(info);
                    System.out.print("Add one more? [yes / no]");
                    String input = scan.next();
                    next = input.toLowerCase(Locale.ROOT).equals("yes");
                }
                try {
                    save();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            default -> {
                System.out.println("Unknown Command");
                try {
                    save();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    void output() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("data.txt"))) {
            String line = bufferedReader.readLine();
            while(line != null) {
                outputformated(line.split(";"));
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void outputformated(String[] array) {
        System.out.println("Vorname " + array[0]);
        System.out.println("Nachname " + array[1]);
        System.out.println("Geburtsjahr " + array[2]);
        System.out.println("Imatrikulationsnummer " + array[3]);
        System.out.println();
    }

    void save() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("data.txt"));
        StringBuilder builder = new StringBuilder();
        for (String[] person : People) {
            for (String s : person) {
                builder.append(s);
                builder.append(";");
            }
            builder.append("\n");
        }
        System.out.print(builder);
        bufferedWriter.write(builder.toString());
        bufferedWriter.close();
    }

    String[] getinfo() {
        String[] array = new String[4];
        System.out.print("Vorname");
        array[0] = scan.next();
        System.out.print("Nachname");
        array[1] = scan.next();
        System.out.print("Geburtsjahr");
        array[2] = scan.next();
        System.out.print("Imatrikulationsnummer");
        array[3] = scan.next();
        return array;
    }

    public static void main(String[] args) {
        new People();
    }
}
