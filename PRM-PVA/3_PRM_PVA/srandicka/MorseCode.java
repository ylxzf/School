package srandicka;

import java.util.*;

public class MorseCode {

    public static String morseToText(String text){
        HashMap<String, Character> rmorseCodeMap = new HashMap<>();

        rmorseCodeMap.put(".-", 'A');
        rmorseCodeMap.put("-...", 'B');
        rmorseCodeMap.put("-.-.", 'C');
        rmorseCodeMap.put("-..", 'D');
        rmorseCodeMap.put(".", 'E');
        rmorseCodeMap.put("..-.", 'F');
        rmorseCodeMap.put("--.", 'G');
        rmorseCodeMap.put("....", 'H');
        rmorseCodeMap.put("..", 'I');
        rmorseCodeMap.put(".---", 'J');
        rmorseCodeMap.put("-.-", 'K');
        rmorseCodeMap.put(".-..", 'L');
        rmorseCodeMap.put("--", 'M');
        rmorseCodeMap.put("-.", 'N');
        rmorseCodeMap.put("---", 'O');
        rmorseCodeMap.put(".--.", 'P');
        rmorseCodeMap.put("--.-", 'Q');
        rmorseCodeMap.put(".-.", 'R');
        rmorseCodeMap.put("...", 'S');
        rmorseCodeMap.put("-", 'T');
        rmorseCodeMap.put("..-", 'U') ;
        rmorseCodeMap.put("...-", 'V');
        rmorseCodeMap.put(".--", 'W');
        rmorseCodeMap.put("-..-", 'X');
        rmorseCodeMap.put("-.--", 'Y');
        rmorseCodeMap.put("--..", 'Z');
        rmorseCodeMap.put("-----", '0');
        rmorseCodeMap.put(".----", '1');
        rmorseCodeMap.put("..---", '2');
        rmorseCodeMap.put("...--", '3');
        rmorseCodeMap.put("....-", '4');
        rmorseCodeMap.put(".....", '5');
        rmorseCodeMap.put("-....", '6');
        rmorseCodeMap.put("--...", '7');
        rmorseCodeMap.put("---..", '8');
        rmorseCodeMap.put("----.", '9');

        String[] morseWords = text.split("//");

        StringJoiner stringJoinerChars = new StringJoiner("");
        StringJoiner stringJoinerWords = new StringJoiner(" ");

        for (int i = 0; i < morseWords.length; i++) {
            String[] morseChars = morseWords[i].split("/");
            for (int j = 0; j < morseChars.length; j++) {
                stringJoinerChars.add(String.valueOf(rmorseCodeMap.get(morseChars[j])));
            }
            stringJoinerWords.add(stringJoinerChars.toString());
            stringJoinerChars = new StringJoiner("");
        }
        return stringJoinerWords.toString();
    }
    public static String textToMorse(String text){
        HashMap<Character, String> morseCodeMap = new HashMap<>();

        morseCodeMap.put('A', ".-");
        morseCodeMap.put('B', "-...");
        morseCodeMap.put('C', "-.-.");
        morseCodeMap.put('D', "-..");
        morseCodeMap.put('E', ".");
        morseCodeMap.put('F', "..-.");
        morseCodeMap.put('G', "--.");
        morseCodeMap.put('H', "....");
        morseCodeMap.put('I', "..");
        morseCodeMap.put('J', ".---");
        morseCodeMap.put('K', "-.-");
        morseCodeMap.put('L', ".-..");
        morseCodeMap.put('M', "--");
        morseCodeMap.put('N', "-.");
        morseCodeMap.put('O', "---");
        morseCodeMap.put('P', ".--.");
        morseCodeMap.put('Q', "--.-");
        morseCodeMap.put('R', ".-.");
        morseCodeMap.put('S', "...");
        morseCodeMap.put('T', "-");
        morseCodeMap.put('U', "..-");
        morseCodeMap.put('V', "...-");
        morseCodeMap.put('W', ".--");
        morseCodeMap.put('X', "-..-");
        morseCodeMap.put('Y', "-.--");
        morseCodeMap.put('Z', "--..");
        morseCodeMap.put('0', "-----");
        morseCodeMap.put('1', ".----");
        morseCodeMap.put('2', "..---");
        morseCodeMap.put('3', "...--");
        morseCodeMap.put('4', "....-");
        morseCodeMap.put('5', ".....");
        morseCodeMap.put('6', "-....");
        morseCodeMap.put('7', "--...");
        morseCodeMap.put('8', "---..");
        morseCodeMap.put('9', "----.");

        String newText = text.toUpperCase();

        String[] words = newText.split(" ");

        StringJoiner stringJoinerChars = new StringJoiner("/");
        StringJoiner stringJoinerWords = new StringJoiner("//");

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                stringJoinerChars.add(morseCodeMap.get(words[i].charAt(j)));
            }
            stringJoinerWords.add(stringJoinerChars.toString());
            stringJoinerChars = new StringJoiner("/");
        }

        return stringJoinerWords.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
//        System.out.println(textToMorse(text));
        System.out.println(morseToText(text));
    }
}
