package _20210820;

import tools.Tools;

public class MultiDimensionalArray {

    Tools tools = new Tools();

    String[][] kalender = new String[31][24];

    public MultiDimensionalArray() {
        kalender = tools.setallvalues(kalender, "Nichts");
        for (int i = 0; i < 200; i++) {
            int day = tools.getrandom(31);
            int hour = tools.getrandom(24);
            addactivity(day, hour, "aktivität");
        }
        tools.print(kalender);
    }

    private void addactivity(int day, int hour,String text) {
        kalender[day][hour] = text;
    }

    public static void main(String[] args) {
        MultiDimensionalArray obj = new MultiDimensionalArray();
    }
}
