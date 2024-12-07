package srandicka;

import java.util.Stack;
import java.io.*;

public class BracketsChaloupka {

    private static boolean isMatchingPair(char oteviraci, char zaviraci) {
        return (oteviraci == '(' && zaviraci == ')') ||
                (oteviraci == '[' && zaviraci == ']') ||
                (oteviraci == '{' && zaviraci == '}') ||
                (oteviraci == '<' && zaviraci == '>');
    }

    public static void main(String[] args) {

        // https://www.uschovna.cz/zasilka/PJXTMLAB3LBU2ES6-GLP/

        Stack<Character> stack = new Stack<>();

        String s = "";

        double readstarttime = System.currentTimeMillis();

        try (BufferedReader br = new BufferedReader(new FileReader("srandicka/zavorky.txt"))) {
            s = br.readLine();
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        double readendtime = System.currentTimeMillis();

        System.out.println("READ COMPLETED IN: " + (readendtime - readstarttime) / 1000 + " seconds");

        System.out.println("Počet závorek: " + s.length());

        double starttime = System.currentTimeMillis();

        if (s.length() % 2 != 0) {
            System.out.println("Závorky jsou špatně");
            return;
        }

        for (int i = 0; i < s.length(); i++) {

            char current = s.charAt(i);
            if (current == '(' || current == '[' || current == '{' || current == '<') {
                stack.push(current);
                // System.out.println("pushed: " + current + " >>> " + stack.toString());
            } else if (current == ')' || current == ']' || current == '}' || current == '>') {
                if (stack.isEmpty()) {
                    System.out.println("Závorky jsou špatně");
                    return;
                }

                // System.out.println("stack before pop >>>" + stack.toString());
                char vrchol = stack.pop();

                if (!isMatchingPair(vrchol, current)) {
                    System.out.println("Závorky jsou špatně. Chyba je na pozici " + i);
                    return;
                }
                // System.out.println("stack after pop " + vrchol + " >>> " + stack.toString());
            }
        }
        if (stack.isEmpty()) {
            System.out.println("Závorky jsou správně");
        } else {
            System.out.println("Závorky jsou špatně");
        }
        double endtime = System.currentTimeMillis();

        System.out.println(
                "CHECK COMPLETED IN: " + (endtime - starttime) / 1000 + " seconds");
    }
}
