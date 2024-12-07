package soubory;

import java.io.*;
import java.util.StringJoiner;

public class TrenovaciData {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("src/soubory/matcj.txt");
//        StringJoiner stringJoiner = new StringJoiner(", ");
        StringJoiner stringJoiner = new StringJoiner(", ", "inputData={", "}");
        FileWriter fileWriter = new FileWriter("src/soubory/text.txt", true);


        int real;
        int c1, c2;
        while ((real = fileReader.read()) != -1) {

            c1 = real - 48;
            while ((real = fileReader.read()) != ';'){
                c1 = c1 * 10 + (real - 48);
            }

            c2 = 0;
            while ((real = fileReader.read()) != 13){
                c2 = c2 * 10 + (real - 48);
            }

            stringJoiner.add(String.format("%d -> %d", c1, c2));

            while ((real = fileReader.read()) != 10);
        }

        System.out.println(stringJoiner.toString());
        fileWriter.write(stringJoiner.toString() + "\n");

        fileReader.close();
        fileWriter.close();
    }
}
