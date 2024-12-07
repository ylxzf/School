package srandicka;

import java.util.*;
import java.io.*;

public class BracketsRadim {
    byte jedna = 0;
    byte dva = 0;

    public static void main(String[] args) {
        String input = "";

        double readstarttime = System.currentTimeMillis();

        try (BufferedReader br = new BufferedReader(new FileReader("srandicka/zavorky2.txt"))) {
            input = br.readLine();
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        double readendtime = System.currentTimeMillis();

        System.out.println("READ COMPLETED IN: " + (readendtime - readstarttime) / 1000 + " seconds");

        double starttime = System.currentTimeMillis();

        // Přímo vytvoření ArrayListu z filtrovaného řetězce
        List<Character> bracketsList = new ArrayList<>();
        for (char c : input.toCharArray()) {
            if ("()[]{}<>".indexOf(c) >= 0) {
                bracketsList.add(c);
            }
        }
        System.out.println();

        // Výpis hodnot v ArrayListu
        while (!bracketsList.isEmpty()) {
            for (int i = 0; i < bracketsList.size(); i++) {
                if (bracketsList.get(i).equals('(') && (bracketsList.get(i + 1).equals(')'))) {
                    bracketsList.remove(i);
                    bracketsList.remove(i);
                    i--;
                } else if (bracketsList.get(i).equals('{') && (bracketsList.get(i + 1).equals('}'))) {
                    bracketsList.remove(i);
                    bracketsList.remove(i);
                    i--;
                } else if (bracketsList.get(i).equals('[') && (bracketsList.get(i + 1).equals(']'))) {
                    bracketsList.remove(i);
                    bracketsList.remove(i);
                    i--;
                } else if (bracketsList.get(i).equals('<') && (bracketsList.get(i + 1).equals('>'))) {
                    bracketsList.remove(i);
                    bracketsList.remove(i);
                    i--;
                }
            }
        }

        double endtime = System.currentTimeMillis();

        System.out.println(
                "CHECK COMPLETED IN: " + (endtime - starttime) / 1000 + " seconds");
    }
}
