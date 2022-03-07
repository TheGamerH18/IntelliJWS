package sortieren;

import java.util.Arrays;

public class Insertionsprt {
    public static void main(String[] args) {
        int[] array = new int[]{12, 5, 9, 120, 4, 2};
        array = InsertionSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static int[] InsertionSort(int[] list) {

        for (int i = 0; i < list.length; i++) {
            int wert = list[i];
            int j = i;
            while (j > 0 && (list[j-1] > wert)) {
                list[j] = list[j -1];
                j = j - 1;
            }
            list[j] = wert;
        }
        return list;
    }
}
