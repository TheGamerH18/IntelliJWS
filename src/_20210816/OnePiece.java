package _20210816;

import tools.Tools;

import java.util.Objects;

public class OnePiece {

    String[] signs1 = { "F", "DO", "MOS", "MOS", "MOS", "MOS", "WES" };
    String[] signs2 = { "F", "DO", "MOS", "MOS", "WES", "MOS", "MOS" };

    public OnePiece() {
        Tools tools = new Tools();
        boolean signs1 = isProbablyApproaching(this.signs1);
        boolean signs2 = isProbablyApproaching(this.signs2);
        tools.print(String.valueOf(signs1));
        tools.print(String.valueOf(signs2));
    }

    private boolean isProbablyApproaching(String[] array) {
        for (int i = 0; i < array.length; i++) {
            try {
                if (Objects.equals(array[i], array[i + 1])
                        && Objects.equals(array[i], array[i + 2])
                        && Objects.equals(array[i], array[i + 3])) return true;
            } catch (ArrayIndexOutOfBoundsException e){
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        OnePiece obj = new OnePiece();
    }
}
