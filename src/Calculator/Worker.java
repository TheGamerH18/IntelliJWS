package Calculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Worker {


    private final HashMap<Runner, Character> availableoperators = new HashMap<>();
    private final ArrayList<Integer> numbers = new ArrayList<>();
    private final ArrayList<Integer> operator = new ArrayList<>();
    private String currentinput = "";
    private String output = "";

    public String getOutput() {
        return output;
    }

    /**
     * Add a number to the current input
     *
     * @param value number to add as int
     * @return String made by {@link #setTextfield()} / representation of calculation as String
     */
    public String inputnumber(int value) {
        currentinput += String.valueOf(value);
        return output = setTextfield();
    }

    /**
     * Adds Operator to List and validates and saves last number that was inputed
     *
     * @param operator operator to add as char
     * @return String made by {@link #setTextfield()} / representation of calculation as String
     */
    public String setOperator(char operator) {
        System.out.println(operator);
        validatecurrentinput();
        this.operator.add((int) operator);
        return output = setTextfield();
    }

    /**
     * Creates Output String based on numbers and operators in Arraylists list
     *
     * @return created String
     */
    private String setTextfield() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numbers.size(); i++) {
            stringBuilder.append(numbers.get(i));
            if (i < operator.size()) stringBuilder.append((char) (int) operator.get(i));
        }
        if (!currentinput.equalsIgnoreCase("")) {
            stringBuilder.append(currentinput);
        }
        return stringBuilder.toString();
    }

    private void validatecurrentinput() {
        int currentnumber = (!currentinput.equalsIgnoreCase("")) ? Integer.parseInt(currentinput) : 0;
        numbers.add(currentnumber);
        currentinput = "";
    }

    public void addOperator(char character, Runner method) {
        availableoperators.put(method, character);
    }

    /**
     * Calculates the result of the calculation
     *
     * @return String representation of the result
     */
    public String calc() {
        try {
            validatecurrentinput();
            AtomicInteger value = new AtomicInteger(numbers.get(0));
            for (int i = 1; i < numbers.size(); i++) {
                int usevalue = numbers.get(i);
                if (i - 1 < operator.size()) {
                    int finalI = i;
                    availableoperators.forEach((runnable, character) -> {
                        if ((char) character == operator.get(finalI - 1)) {
                            value.set(runnable.run(value.get(), usevalue));
                        }
                    });
                    System.out.println(value.get());
                }
            }
            output = String.valueOf(value.get());
        } finally {
            numbers.clear();
            operator.clear();
            currentinput = "";
        }
        return output;
    }

    public interface Runner {
        int run(int value, int othervalue);
    }
}
