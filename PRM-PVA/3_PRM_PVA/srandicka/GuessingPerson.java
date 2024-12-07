package srandicka;

import java.util.Random;
import java.util.Scanner;

class GuessingPerson {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int randomNumber = random.nextInt(3000) + 1;
        int guessedNumber = 0;

        System.out.println(randomNumber);
        System.out.println();
        int tryAmount = 0;

        while (guessedNumber != randomNumber) {
            System.out.print("Enter a number to guess: ");
            guessedNumber = scanner.nextInt();

            tryAmount++;

            if (guessedNumber == randomNumber){
                System.out.print("Congratulations! You've guessed the number on your " + tryAmount);
                if (tryAmount % 10 == 1 && tryAmount > 20){
                    System.out.print("st try.");
                } else if (tryAmount % 10 == 2 && tryAmount > 20) {
                    System.out.print("nd.");
                } else if (tryAmount % 10 == 3 && tryAmount > 20) {
                    System.out.print("rd try.");
                } else {
                    System.out.print("th try.");
                }
            }
            else if (guessedNumber > randomNumber) {
                System.out.println("The number is smaller.");
            }
            else if (guessedNumber < randomNumber) {
                System.out.println("The number is bigger.");
            }

            System.out.println();
        }
        scanner.close();
    }
}
