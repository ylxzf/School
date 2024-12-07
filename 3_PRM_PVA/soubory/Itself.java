package soubory;

import pisemky.pisemka5.Obdelnik;

import java.io.*;
import java.util.ArrayList;

public class Itself {
    public static void main(String[] args) throws IOException{
        FileReader fileReader = new FileReader("src/soubory/Itself.java");

        int[] characters = new int[128];
        int real;
        while ((real = fileReader.read()) != -1){
            System.out.printf("%c", real);
            characters[real]++;
        }

        for (int e: characters
             ) {
            System.out.print(e + ", ");
        }
        fileReader.close();
    }
}
