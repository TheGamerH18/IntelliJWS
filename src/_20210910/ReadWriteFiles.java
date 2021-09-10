package _20210910;

import tools.Tools;

public class ReadWriteFiles {
    public static void main(String[] args) {
        Tools tools = new Tools();

        // Define Keywords
        String[] keyword = {"Waffen", "Drogen"};

        // Read files
        String file1 = tools.readfromfile("C:\\Users\\PCMR-Portable\\Desktop\\Hamburg.txt", true)[0];
        String file2 = tools.readfromfile("C:\\Users\\PCMR-Portable\\Desktop\\Frankfurt.txt", true)[0];

        // Search in Hamburg.txt
        tools.print("Hamburg.txt");
        for (String s : keyword) {
            tools.find(file1, s);
        }

        // Search in Frankfurt.txt
        tools.print("Frankfurt.txt");
        for (String s : keyword) {
            tools.find(file2, s);
        }
    }
}
