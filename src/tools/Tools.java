package tools;

public class Tools {

    /**
     * Text in der Konsole ausgeben
     * @param text auszugebener Text
     */
    public void print(String text) {
        System.out.println(text);
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
     * Werte werden nacheinander ausgesucht. Danach wird das Array von vorne bis hinten durchsucht, nach der Korrekten
     * position für den Wert.
     * @param list zu Sortierende Liste
     * @return Sortierte Liste
     */
    public int[] InsertionSort(int[] list) {
        for (int i = 0; i < list.length; i++) {
            int wert = list[i];
            int j = i;
            while ((j > 0) && list[j-1] > wert) {
                list[j] = list[j -1];
                j = j - 1;
            }
        }
        return list;
    }
}
