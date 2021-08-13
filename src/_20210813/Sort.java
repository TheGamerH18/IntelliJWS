package _20210813;

import tools.Tools;

import java.util.Arrays;

public class Sort {

    public Sort() {
        Tools tools = new Tools();
        int[] randomArray = getRandomArray();
        tools.print(">> BubbleSort");
        int[] bubbleSort = tools.BubbleSort(randomArray);
        tools.print("[BubbleSort] >> \n"
                + Arrays.toString(bubbleSort));
        tools.print(">> InsertionSort");
        int[] insertionSort = tools.InsertionSort(randomArray);
        tools.print("[InsertionSort] >> \n"
                + Arrays.toString(insertionSort));
    }

    private int[] getRandomArray() {
        int[] zahlenFeld = new int[(int)(Math.random()*100+1)];
        for(int i = 0; i != zahlenFeld.length; i++) {
            zahlenFeld[i]  = (int)(Math.random()*100);
        }
        return zahlenFeld;
    }

    public static void main(String[] args) {
        Sort obj = new Sort();
    }
}
