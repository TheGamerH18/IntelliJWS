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
}
