package _20211029;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Person {

    private final String FirstName;
    private final String LastName;
    private final float Weight;
    private final float Height;

    private float BMI;

    public float calcBMI() {
        this.BMI = Weight / (Height * Height);
        return this.BMI;
    }

    public String evaluation() {
        if(this.BMI < 19) return "Underweight";
        if(this.BMI < 26) return "Normalweight";
        if(this.BMI < 30) return "Overweight";
        return "Extreme overweight";
    }

    public Person(String firstName, String lastName, float weight, float height) {
        FirstName = firstName;
        LastName = lastName;
        Weight = weight;
        Height = height;
    }

    public String getName() {
        return FirstName + " " + LastName;
    }

    public void writetofile() {
        try(FileWriter writer = new FileWriter("data.txt")) {
            writer.write(getName() + " " + Height + " " + Weight + " " + BMI + " " + evaluation());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
