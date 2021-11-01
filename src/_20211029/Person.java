package _20211029;

public class Person {

    private String FirstName;
    private String LastName;
    private int Weight;
    private int Height;

    private int BMI;

    public int calcBMI() {
        this.BMI = Weight / (Height * Height);
        return this.BMI;
    }

    public String evaluation() {
        if(this.BMI < 19) return "Underweight";
        if(this.BMI < 26) return "Normalweight";
        if(this.BMI < 30) return "Overweight";
        return "Extreme overweight";
    }

    public Person(String firstName, String lastName, int weight, int height) {
        FirstName = firstName;
        LastName = lastName;
        Weight = weight;
        Height = height;
    }

    public String getName() {
        return FirstName + " " + LastName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setWeight(int weight) {
        Weight = weight;
    }

    public void setHeight(int height) {
        Height = height;
    }
}