package sololearn;

import java.util.Scanner;
import java.util.StringJoiner;

public class PigLatin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringJoiner stringJoiner = new StringJoiner(" ");

        String input = scanner.nextLine();

        String[] words = input.split(" ");

        for (String e: words) {
            stringJoiner.add(e.substring(1) + e.charAt(0) + "ay");
        }

        System.out.println(stringJoiner.toString());
    }
}
