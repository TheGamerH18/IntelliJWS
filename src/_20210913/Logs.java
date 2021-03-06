package _20210913;

import tools.Tools;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Logs {
    Tools tools = new Tools();
    Scanner scan = new Scanner(System.in);
    ArrayList<String[]> array = new ArrayList<>();

    Logs() {
        String[] txt = tools.readfromfile("C:\\Users\\PCMR-Portable\\Desktop\\log.txt", false);
        for (String s : txt) {
            // Anschlussnummer;Anrufnummer;Datum;Startzeit;Datum;Endzeit;
            array.add(s.split(";"));
        }
        System.out.print("Zu Suchende Nummer");
        String inputnumber = scan.next();
        ArrayList<String[]> result = searchbynumber(inputnumber);
        for (String[] strings : result) {
            tools.print("Ausgehende Nummer: ", false);
            tools.print(strings[0], true);
            tools.print("Eingehende Nummer: ", false);
            tools.print(strings[1], true);
            tools.print("Startzeit: ", false);
            tools.print(strings[2] + " " + strings[3], true);
            tools.print("Endzeit: ", false);
            tools.print(strings[4] + " " + strings[5], true);
            tools.print("Dauer: " + getelapsedtime(strings[2], strings[3], strings[4], strings[5]));
            tools.print("", true);
        }
    }

    private String getelapsedtime(String startdate, String starttime, String enddate, String endtime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyyHH:mm:ss");
        LocalDateTime start = LocalDateTime.parse(startdate + starttime, formatter);
        LocalDateTime end = LocalDateTime.parse(enddate+endtime, formatter);

        long hours = start.until(end, ChronoUnit.HOURS);
        start = start.plusHours(hours);
        long minutes = start.until(end, ChronoUnit.MINUTES);
        start = start.plusMinutes(minutes);
        long seconds = start.until(end, ChronoUnit.SECONDS);

        return hours + "h " + minutes + "m " + seconds + "s";
    }

    private ArrayList<String[]> searchbynumber(String number) {
        ArrayList<String[]> arrayList = new ArrayList<>();

        for (String[] strings : array) {
            if(Objects.equals(strings[0], number)) arrayList.add(strings);
            else if (Objects.equals(strings[1], number)) arrayList.add(strings);
        }

        return arrayList;
    }

    public static void main(String[] args) {
        Logs logs = new Logs();
    }

}
