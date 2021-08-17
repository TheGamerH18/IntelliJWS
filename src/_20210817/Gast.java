package _20210817;

public class Gast {
    private final int id;
    long eincheckzeit;
    int raumnummer;
    private final String name;

    public Gast(int gastid, String name) {
        eincheckzeit = System.currentTimeMillis();
        id = gastid;
        this.name = name;
    }

    public void setRaumnummer(int raumnummer) {
        this.raumnummer = raumnummer;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
