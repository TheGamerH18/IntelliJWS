package _20211112.Zinsrechner;

import java.util.ArrayList;

public class Zinser {

    private String Year = "Jahr";
    private String interest = "Zinsen";
    private String indcapital = "Endkapital";

    private int laufzeit;
    private double zinssatz;
    private long kapital;

    public Zinser(int laufzeit, double zinssatz, long kapital) {
        this.laufzeit = laufzeit;
        this.zinssatz = zinssatz;
        this.kapital = kapital;
    }

    protected ArrayList<String> calculate() {
        long kapital = this.kapital;
        ArrayList<double[]> doubles = new ArrayList<>();
        for(int i = 0; i < laufzeit; i ++) {
            double[] data = new double[2];
            data[0] = (double) Math.round(kapital * zinssatz*100)/100;
            kapital += data[0];
            data[1] = kapital;
            doubles.add(data);
        }
        ArrayList<String> output = new ArrayList<>();
        int longest1 = getlongest(doubles, 0);
        int longest2 = getlongest(doubles, 1);
        int longest = Integer.toString(laufzeit).length();

        if(longest < Year.length()) longest = Year.length()+1;
        if(longest1 < interest.length()) longest1 = interest.length()+1;
        if(longest2 < indcapital.length()) longest2 = indcapital.length()+1;

        // Create first line of output
        String line = Year +
                " ".repeat(longest - Year.length()) +
                interest +
                " ".repeat(longest1 - interest.length()) +
                indcapital +
                " ".repeat(longest2 - indcapital.length());

        // Add first line to output
        output.add(line);

        line = "-".repeat(longest + longest1 + longest2);
        output.add(line);

        for(int i = 0; i < laufzeit; i ++) {
            String laufzeit = Integer.toString(i + 1);
            String zinsen = Double.toString(doubles.get(i)[0]);
            String endkapital = Double.toString(doubles.get(i)[1]);

            line = laufzeit +
                    " ".repeat(longest - laufzeit.length()) +
                    zinsen +
                    " ".repeat(longest1 - zinsen.length()) +
                    endkapital +
                    " ".repeat(longest2 - endkapital.length());

            output.add(line);
        }

        return output;
    }

    private int getlongest(ArrayList<double[]> doubles, int index) {
        int longest = 0;
        for (double[] aDouble : doubles) {
            if(Double.toString(aDouble[index]).length() > longest) {
                longest = (aDouble[index] + " EUR").length();
            }
        }
        return longest;
    }
}
