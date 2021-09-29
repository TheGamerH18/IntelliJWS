package _20210924;

import tools.Tools;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class ReadMP3 {
    Tools tools = new Tools();

    byte[] TAG = new byte[3];
    byte[] Title, Interpret, CDTitle, Comment = new byte[30];
    byte[] Realeseyear = new byte[4];
    byte[] Genre = new byte[1];

    ReadMP3() {
        FileInputStream file = tools.readfromfile("C:\\Folder\\hot_dogs_for_breakfast.mp3");
        tools.print(tools.readmp3Tags(file));
    }

    public static void main(String[] args) {
        new ReadMP3();
    }
}
