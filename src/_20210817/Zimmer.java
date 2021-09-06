package _20210817;

public class Zimmer {
    private final String raumnummer;
    private final int ettage;
    private final int bettenzahl;
    private int[] gaeste;

    public Zimmer(int bettenzahl, int ettage, String raumnummer) {
        gaeste = new int[bettenzahl];
        this.bettenzahl = bettenzahl;
        this.ettage = ettage;
        this.raumnummer = raumnummer;
    }

    public int freiebetten() {
        return bettenzahl - gaeste.length;
    }

    public boolean addguest(int gastid) {
        if(freiebetten() > 0) {
            gaeste[bettenzahl - freiebetten()] = gastid;
            return true;
        }
        return false;
    }

    public String getRaumnummer() {
        return raumnummer;
    }

    public int getEttage() {
        return ettage;
    }
}
