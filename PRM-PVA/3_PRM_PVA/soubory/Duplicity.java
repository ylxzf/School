package soubory;

import java.io.*;
import java.util.ArrayList;

public class Duplicity {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/soubory/slovnik.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/soubory/slovnikWODuplicates"));

        ArrayList<String> slovnikCheck = new ArrayList<String>();

        while (bufferedReader.ready()){
            if (!slovnikCheck.contains(bufferedReader.readLine())){
                slovnikCheck.add(bufferedReader.readLine());
            }
        }

        System.out.println(slovnikCheck);

        for (String e : slovnikCheck) {
            bufferedWriter.write(e + "\n");
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
