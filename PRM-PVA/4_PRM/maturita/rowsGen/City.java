package maturita.rowsGen;

import java.text.DecimalFormat;
import java.util.Random;

public class City {
    private double temp;
    private String name;

    Random rand = new Random();

    public City(String name, double temp) {
        this.name = name;
        this.temp = temp;
    }

    public double getTemp() {
        return temp;
    }

    public String getName() {
        return name;
    }

    public String stringExtensionCity() {
        return this.name + ": ";
    }
}
