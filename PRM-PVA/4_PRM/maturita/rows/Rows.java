package maturita.rows;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringJoiner;

public class RowsApp {

    HashMap<String, ArrayList<Double>> data = new HashMap();
    HashMap<String, ArrayList<Double>> dataAverage = new HashMap();


    public void gatherInformation() throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("maturita/rows/data.txt"));

        while (bufferedReader.ready()) {
            String line = bufferedReader.readLine();
            String[] lineData = line.split(";");
            String city = lineData[0];
            String temperature = lineData[1].replace(",", ".");

            data.putIfAbsent(city, new ArrayList<>());
            data.get(city).add(Double.parseDouble(temperature));
        }

        bufferedReader.close();
    }

    public void printInformation() {
        for (String city : data.keySet()) {
            System.out.println(city + "; " + data.get(city));
        }
    }

    public void createFinal() {
        for (String city : data.keySet()) {
            dataAverage.putIfAbsent(city, new ArrayList<>());
            dataAverage.get(city).add(getMinimumTemperature(data.get(city)));
            dataAverage.get(city).add(getAverageTemperature(data.get(city)));
            dataAverage.get(city).add(getMaximumTemperature(data.get(city)));
        }
    }

    public void printFinal() {
        StringJoiner stringJoiner = new StringJoiner(", ");

        for (String city : dataAverage.keySet()) {
            stringJoiner.add(city + "=" + dataAverage.get(city).get(0) + "/" + dataAverage.get(city).get(1) + "/" + dataAverage.get(city).get(2));
        }

        System.out.println(stringJoiner.toString());
    }

    private double getAverageTemperature(ArrayList<Double> temps) {
        Double sum = 0.0;

        for (Double temp : temps) {
            sum += temp;
        }

        return Math.round((sum / temps.size()) * 10.0) / 10.0 ;
    }

    private double getMinimumTemperature(ArrayList<Double> temps) {
        return Collections.min(temps);
    }

    private double getMaximumTemperature(ArrayList<Double> temps) {
        return Collections.max(temps);
    }

    public static void main(String[] args) throws Exception {

        RowsApp demo = new RowsApp();

        demo.gatherInformation();
        demo.printInformation();

        demo.createFinal();
        demo.printFinal();
    }
}
