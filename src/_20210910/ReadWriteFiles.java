package _20210910;

import tools.Tools;

import java.io.*;
import java.util.Scanner;

public class ReadWriteFiles {
    public static void main(String[] args) {
        Tools tools = new Tools();
        try {
            FileReader f = new FileReader("C:\\Users\\PCMR-Portable\\Desktop\\txt.txt");
            FileWriter w = new FileWriter("C:\\Users\\PCMR-Portable\\Desktop\\txt.txt");

            w.write(new Scanner(System.in).next());
            w.close();

            for (int i = f.read(); i != -1; i = f.read()) System.out.print((char) i);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
