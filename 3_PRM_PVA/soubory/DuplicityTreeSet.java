package soubory;

import java.io.*;
import java.util.*;

public class DuplicityTreeSet {
    public static void main(String[] args) throws IOException {
        long time1 = System.currentTimeMillis();

        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/soubory/slovnik.txt"));

        HashSet<String> slovnikCheck = new HashSet<>();

        String s;
        while ((s = bufferedReader.readLine()) != null){
            if (!slovnikCheck.contains(s)){
                slovnikCheck.add(s);
            }
        }

        long time2 = System.currentTimeMillis();

        System.out.println(slovnikCheck);
        System.out.println(time2-time1);

        bufferedReader.close();
    }
}