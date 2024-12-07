package srandicka;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Sirky2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int matches = random.nextInt(11);
        matches += 15;

        ArrayList<Character> matchesOnBoard = new ArrayList<>();
        ArrayList<String> playerNames = new ArrayList<>();

        int players;
        do {
            System.out.print("Enter amount of players: ");
            players = scanner.nextInt();
            if(players<=1){
                System.out.println("You cannot play on your own");
            }
            else{
                break;
            }

        } while (true);

        for (int i = 0; i < players; i++) {
            int newPlayer = i+1;
            System.out.println("Enter player "+newPlayer+"'s name");
            String playerName = scanner.next();
            playerNames.add(playerName);
        }

        for (int i = 1; i <= players; i++) {
            String currentPlayer = playerNames.get(i-1);
            System.out.println("It is player " + currentPlayer + "'s turn to play");
            for (int k = 0; k < matches; k++) {
                matchesOnBoard.add('i');
            }
            for (char c : matchesOnBoard) {
                System.out.print(c);
            }
            System.out.print(" ("+matches+" matches left)");
            matchesOnBoard.clear();
            System.out.println();
            if(matches==3){
                System.out.println("How many matches would you like to take? (1-2)");
            }
            else if(matches==2){
                System.out.println("How many matches would you like to take? (1)");
            }
            else{
                System.out.println("How many matches would you like to take? (1-3)");
            }
            int takenMatches;
            do {
                takenMatches = scanner.nextInt();
                if (takenMatches > 3 || takenMatches < 1) {
                    System.out.println("Invalid amount of matches taken");
                } else {
                    break;
                }
            } while (true);
            if(matches == 3 && takenMatches == 3){
                System.out.println("Player "+currentPlayer+" took all the remaining matches and lost");
                break;
            }
            else if(matches == 2 && takenMatches == 3){
                System.out.println("Player "+currentPlayer+" took all the remaining matches and lost");
                break;
            }
            matches -= takenMatches;
            String nextPlayer;
            if(i==players){
                nextPlayer = playerNames.get(0);
            }
            else{
                nextPlayer = playerNames.get(i);
            }
            if(matches==1||matches<1){
                System.out.println("Player "+nextPlayer+" takes the last match and loses");
                break;
            }
            else if(i==players){
                i=0;
            }
            System.out.println();
        }
    }
}
