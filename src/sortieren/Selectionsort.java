package sortieren;

import java.util.Arrays;

public class Selectionsort {
    public static void main(String[] args) {
        int[] array = new int[]{13, 4, 6, 2, 11};

        int hoechterIndex = array.length-1;
        int pasteindex = 0;

        do {
            int minposition = pasteindex;
            for(int idx = pasteindex+1; idx <= hoechterIndex; idx ++){
                if(array[idx] < array[minposition]){
                    minposition=idx;
                }
            }
            int value = array[minposition];
            array[minposition] = array[pasteindex];
            array[pasteindex] = value;

            pasteindex ++;
        } while (pasteindex < hoechterIndex);
        System.out.println(Arrays.toString(array));
    }
}
