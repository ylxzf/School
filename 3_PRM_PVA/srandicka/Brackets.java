package srandicka;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Brackets {
    public static void main(String[] args) {



        Stack<Character> stack = new Stack<Character>();
        Scanner scanner = new Scanner(System.in);

        String input = "";
//        System.out.println("Enter Brackets");
//        String input = scanner.nextLine();

//        System.out.println((int)input.charAt(0));

        double readstarttime = System.currentTimeMillis();

        try (BufferedReader br = new BufferedReader(new FileReader("srandicka/zavorky.txt"))) {
            input = br.readLine();
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        double readendtime = System.currentTimeMillis();

        System.out.println("READ COMPLETED IN: " + (readendtime - readstarttime) / 1000 + " seconds");

        double starttime = System.currentTimeMillis();

        char[] leftBrackets = {'(', '[', '{', '<'};
        char[] rightBrackets = {')', ']', '}', '>'};

        try {
            for (int i = 0; i < input.length(); i++) {

                if (Arrays.asList(leftBrackets).contains(input.charAt(i))) {
                    stack.push(input.charAt(i));
                }
                else if (Arrays.asList(rightBrackets).contains(input.charAt(i))) {
                    if (Arrays.asList(leftBrackets).indexOf(stack.peek()) == Arrays.asList(rightBrackets).indexOf(input.charAt(i))) {
                        stack.pop();
                    }
                }
            }
        }
        catch (Exception e){
            System.out.println("Brackets ARE NOT correct");
            return;
        }


        if (!stack.empty()){
            System.out.println("Brackets ARE NOT correct");
        }
        else {
            System.out.println("Brackets ARE correct");
        }

        double endtime = System.currentTimeMillis();

        System.out.println(
                "CHECK COMPLETED IN: " + (endtime - starttime) / 1000 + " seconds");
    }
}
