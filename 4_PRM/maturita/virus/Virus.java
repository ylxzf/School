package maturita.virus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Virus {
    String path;
    String input;

    public Virus(String path) throws IOException {
        this.path = path;
        input = getFileString();
    }

    public String getFileString() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

        StringBuilder s = new StringBuilder();

        while (bufferedReader.ready()) {
            s.append(bufferedReader.readLine());
        }

        return s.toString();
    }

    public Boolean containsVirus(String virus) {
        Pattern pattern = Pattern.compile(virus);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }

    public void getVirusResults() {
        System.out.println(containsVirus("AAA\\|TAA") ? "Has Virus 1" : "Does not have Virus 1");
        System.out.println(containsVirus("CCC\\|TAT\\|CCC") ? "Has Virus 2" : "Does not have Virus 2");
        System.out.println(containsVirus("GTA\\|GTA\\|GTA\\|GTA\\|GTA") ? "Has Virus 3" : "Does not have Virus 3");
        System.out.println(containsVirus("ACT\\|A.A\\|CCG") ? "Has Virus 4" : "Does not have Virus 4");
        System.out.println(containsVirus(".CT\\|ATC\\|C.G") ? "Has Virus 5" : "Does not have Virus 5");
    }

    public static void main(String[] args) throws IOException {
        Virus panNahoda = new Virus("src/maturita/virus/panNahoda.txt");
        Virus paniWolframova = new Virus("src/maturita/virus/paniWolframova.txt");

        System.out.println("Pan Nahoda");
        panNahoda.getVirusResults();

        System.out.println("\nPani Wolframova");
        paniWolframova.getVirusResults();
    }
}
