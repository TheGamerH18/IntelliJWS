package _20211104;

public class Leistungen {
    private int Klassenarbeit1;
    private int Klassenarbeit2;
    private int Mundlich;

    /**
     * Konstruktor für die Leistung eines Schülers zum weiteren analysieren
     * @param klassenarbeit1 Note in der 1. Klassenarbeit
     * @param klassenarbeit2 Note in der 2. Klassenarbeit
     * @param mundlich Mundliche Note
     */
    public Leistungen(int klassenarbeit1, int klassenarbeit2, int mundlich) {
        Klassenarbeit1 = klassenarbeit1;
        Klassenarbeit2 = klassenarbeit2;
        Mundlich = mundlich;
    }

    public double berechnedurchschnitt() {
        return (( (double) (Klassenarbeit2 + Klassenarbeit1) / 2) * 0.45 + Mundlich * 0.55);
    }

    public String einschatzung() {
        String[] notentext = {"sehr gut", "gut", "befriedigend", "ausreichend", "mangelhaft", "ungenügend"};
        int note = (int) Math.round(berechnedurchschnitt());
        return notentext[note - 1];
    }
}
