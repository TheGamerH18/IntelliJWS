package _20211112.Zinsrechner;

import java.text.DecimalFormat;
import java.text.NumberFormat;
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
        // get local capital
        double kapital = this.kapital;
        ArrayList<double[]> doubles = new ArrayList<>();
        // Calculate every year
        for(int i = 0; i < laufzeit; i ++) {
            // Create new Array
            double[] data = new double[2];
            // round the interests
            data[0] = (double) Math.round(kapital * zinssatz*100)/100;
            // add the interests to the capital
            kapital += data[0];
            data[1] = kapital;
            // Add Array to List
            doubles.add(data);
        }

        // Format output String
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
            NumberFormat formatter = NumberFormat.getCurrencyInstance();
            String laufzeit = Integer.toString(i + 1);
            double temp2 = doubles.get(i)[0];
            String zinsen = formatter.format(temp2);
            String endkapital = formatter.format(doubles.get(i)[1]);

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

    private String cutnumber(String number) {
        int count = checklengthofnumber(number);
        return number.substring(0, number.length()-count);
    }

    private int checklengthofnumber(String number) {
        String[] splitted = number.split("\\.");
        if(splitted.length <= 1) return 0;
        // Ceck if the number is too long (rounding error)
        if(splitted[1].length() > 2) {
            // return the length, that needs to be cut off
            return splitted[1].length() -2;
        }
        // return 0 numbers need to be cut off
        return 0;
    }

    private int getlongest(ArrayList<double[]> doubles, int index) {
        int longest = 0;
        for (double[] aDouble : doubles) {
            String number = cutnumber(Double.toString(aDouble[index]));
            if(number.length() > longest) {
                longest = (number + " EUR").length();
            }
        }
        return longest;
    }
}
