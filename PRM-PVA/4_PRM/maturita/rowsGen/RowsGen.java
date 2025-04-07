package maturita.rowsGen;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

public class RowsGen {

    BufferedWriter bufferedWriter;

    ArrayList<City> cities;

    Random rand = new Random();

    int numOfLines;

    public RowsGen(String filePath, ArrayList<City> cities, int numOfLines) throws IOException {
        bufferedWriter = new BufferedWriter(new FileWriter(filePath, false));
        this.cities = cities;
        this.numOfLines = numOfLines;

        long time = System.currentTimeMillis();
        generateText();
        System.out.printf("Time taken: %d", System.currentTimeMillis() - time);
    }

    public void generateText() throws IOException {
        for (int i = 0; i < numOfLines; i++) {
            writeText(getRandomCity(), getRandTempDifference());
        }

        bufferedWriter.close();
    }

    public void writeText(City city, double tempDif) throws IOException {
        bufferedWriter.write(String.format("%s%.1f", city.stringExtensionCity(), city.getTemp() + tempDif));
        bufferedWriter.newLine();
    }

    public City getRandomCity() {
        return cities.get(rand.nextInt(cities.size()));
    }

    public double getRandTempDifference() {
        double temp = rand.nextDouble(40) - 20;
        return temp;
    }

}
