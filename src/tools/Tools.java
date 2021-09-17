package tools;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Tools {

    /**
     * Text in der Konsole ausgeben
     * @param text auszugebener Text
     */
    public void print(String text) {
        System.out.println(text);
    }

    public void print(String text, boolean nextline) {
        if(nextline) System.out.println(text);
        else System.out.print(text);
    }

    public void print(Object[][] array) {
        for (Object[] objects : array) {
            print(Arrays.toString(objects));
        }
    }

    /**
     * Überprüft Array von Integern auf Doppelte Werte
     * @param array Zu überprüfendes Array
     * @return true, wenn Werte doppelt sind
     */
    public boolean checkfordoubles(int[] array) {
        for (int i = 0; i < array.length; i++)
            for (int i1 = 0; i1 < array.length; i1++) {
                if (i1 == i) continue;
                if (array[i] == array[i1]) return true;
            }
        print("text");
        return false;
    }

    public int[] BubbleSort(int[] list) {
        for(int i = 0; i < list.length; ++i) {
            for(int j = 0; j < list.length; ++j) {
                if(i == j) continue;
                int i1 = list[i], j1 = list[j];
                list[i] = Math.max(j1, i1);
                list[j] = Math.min(j1, i1);
            }
        }
        return list;
    }

    /**
     * Werte werden nacheinander ausgesucht. Danach wird das Array von hinten bis vorne durchsucht, nach der Korrekten
     * position für den Wert.
     * @param list zu Sortierende Liste
     * @return Sortierte Liste
     */
    public int[] InsertionSort(int[] list) {
        // Jede Position soll einmal gewählt werde
        for (int i = 0; i < list.length; i++) {
            // Aktueller Wert wird gespeichert
            int wert = list[i];
            // Starten an der Aktuellen Position im Array
            int j = i;
            // So lange der vorhergehende Wert im Array Größer ist, wird weiter gesucht
            while (j > 0 && list[j-1] > wert) {
                // Zuletzt überprüfter Wert wird verschoben
                list[j] = list[j -1];
                j = j - 1;
            }
        }
        return list;
    }

    /**
     *
     * @param array zu Sortierendes Array
     * @return Sortiertes Array
     */
    public int[] selectionsort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int i1 = 0; i1 < array.length; i1++) {
                if(array[i] < array[i1]) {
                    int temp = array[i];
                    array[i] = array[i1];
                    array[i1] = temp;
                }
            }
        }
        return array;
    }

    public String[][] setallvalues(String[][] array, String text) {
        for (String[] strings : array) {
            Arrays.fill(strings, text);
        }
        return array;
    }

    public int getrandom(int maxvalue) {
        Random random = new Random();
        return random.nextInt(maxvalue);
    }


    /**
     * Search for a specified String in another String
     * @param text Main string
     * @param keyword String to find in other String
     */
    public boolean find(String text, String keyword) {
        boolean found = false;

        int n = text.length();
        int m = keyword.length();
        for(int i = 0; i < n - m + 1; i++) {
            boolean match = true;
            for(int j = 0; j < m; j++)
                match &= (text.charAt(i + j) == keyword.charAt(j));
            if(match) {
                print("Gefunden an Position " + (i + 1));
                found = true;
            }
        }
        return found;
    }

    /**
     * Reads Specified File and creates Array. Each index contains one line from the file
     * @param path Path to File
     * @param onelineoutput if true, every line seperate in Array. false = everything in one index ( 0 )
     * @return Array containing every line from the file
     */
    public String[] readfromfile(String path, boolean onelineoutput) {
        ArrayList<String> arrayList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();

            while (line != null) {
                if (!onelineoutput) arrayList.add(line);
                else {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                }
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(onelineoutput) arrayList.add(sb.toString());
        return arrayList.toArray(new String[0]);
    }
}
