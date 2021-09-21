package _20210920;

import tools.Tools;

import java.util.*;

public class CopyDelete {
    Tools tools = new Tools();
    ArrayList<String[]> array = new ArrayList<>();
    Scanner scan;

    CopyDelete() {
        tools.print("Initialize");
        String text = tools.readfromfile("C:\\Folder\\log.txt", true)[0];
        String[] textar = text.split(System.lineSeparator());
        for (String s : textar) {
            array.add(s.split(";"));
        }
        tools.writetofile("C:\\Folder\\CopyLog.txt", text);
        //tools.writetofile("C:\\Folder\\log.txt", "");
        tools.print("Done");
        search();
    }

    private void search() {
        scan = new Scanner(System.in);
        String input = "";
        while(!input.equals("end")) {
            tools.print("command");
            input = scan.next();
            switch (input.toLowerCase()) {
                case "location" -> findbylocation();
                case "nickname" -> findbynickname();
                case "name" -> findbyname();
                default -> tools.print("invalid");
            }
        }
    }

    private void findbylocation() {
        int index = 2;

        tools.print("Location");
        String input = scan.next().toLowerCase();
        print(searchinarrayindex(input, index));
    }

    private void findbynickname() {
        int index = 1;

        tools.print("Nickname");
        String input = scan.next().toLowerCase();
        print(searchinarrayindex(input, index));
    }

    private void findbyname() {
        int index = 0;

        tools.print("Name");
        String input = scan.next().toLowerCase();
        print(searchinarrayindex(input, index));
    }

    private ArrayList<String[]> searchinarrayindex(String key, int index) {
        ArrayList<String[]> arrayList = new ArrayList<>();

        for (String[] strings : array) {
            if(Objects.equals(strings[index], key)) arrayList.add(strings);
        }

        return arrayList;
    }

    private void print(ArrayList<String[]> arrayList) {
        for (String[] strings : arrayList) {
            print(strings[0], strings[1], strings[2]);
        }
    }

    private void print(String Name, String Nickname, String Ort) {
        tools.print("Name: " + Name + "\nNickname: " + Nickname + "\nLocation: " + Ort + "\n");
    }

    public static void main(String[] args) {
        CopyDelete copyDelete = new CopyDelete();
    }
}
