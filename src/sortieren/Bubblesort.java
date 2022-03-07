package sortieren;

import java.util.Arrays;

public class Bubblesort {
    public static void main(String[] args) {
        int[] array = new int[]{13, 6, 4, 12, 7, 9};

        for(int n = array.length; n>1; n--){
            for(int i=0; i<n-1; i++){
                if(array[i] > array[i+1]){
                    int value = array[i];
                    array[i] = array[i+1];
                    array[i+1] = value;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
