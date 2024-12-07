package maturita.bigText;

import java.io.*;
import java.util.StringJoiner;
import java.util.HashMap;

public class BigText {
    final String path;
    final String readFile;
    final String writeFile;
    final String wordCountFile;
    final String characterCountFile;

    HashMap<String, Integer> wordCount = new HashMap<>();
    HashMap<Character, Integer> characterCount = new HashMap<>();

    public BigText(String path, String readFile, String writeFile, String wordCountFile, String characterCountFile) {
        this.path = path;
        this.readFile = readFile;
        this.writeFile = writeFile;
        this.wordCountFile = wordCountFile;
        this.characterCountFile = characterCountFile;
    }

    public void textUpdater() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path + "/" + readFile));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path + "/" + writeFile, false));
        int counter = -1;
        while (bufferedReader.ready()) {
            counter++;
            bufferedWriter.write(updateText(bufferedReader.readLine(), counter) + "\n");
        }

        BufferedWriter bufferedWriterWord = new BufferedWriter(new FileWriter(path + "/" + wordCountFile, false));
        wordCount.forEach((key, value) -> {
            try {
                bufferedWriterWord.write(key + ": " + value + "\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
//            System.out.println(key + ": " + value);
        });

        BufferedWriter bufferedWriterCharacter = new BufferedWriter(new FileWriter(path + "/" + characterCountFile, false));
        characterCount.forEach((key, value) -> {
            try {
                bufferedWriterCharacter.write(key + ": " + value + "\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
//            System.out.println(key + ": " + value);
        });

        bufferedReader.close();
        bufferedWriter.close();
        bufferedWriterCharacter.close();
        bufferedWriterWord.close();
    }

    public void HashMapWriter(String file) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(this.path + "/" + file));
    }

    public String updateText(String text, int counter) {
        text = text.trim();

        String[] tempArray = text.split(" ");
        StringJoiner spaceFixer = new StringJoiner(" ");

        for (int i = 0; i < text.length(); i++) {
            if (!characterCount.containsKey(text.charAt(i))) {
                characterCount.put(text.charAt(i), 1);
            }
            else {
                characterCount.put(text.charAt(i), characterCount.get(text.charAt(i)) + 1);
            }
        }
        
        for (String e : tempArray) {
            if (!e.isEmpty()) {
                spaceFixer.add(e);
                String temp = e.replaceAll("[\\(\\)\\<\\>\\{\\}\\<\\>\\.\\,\\/\\;\\'\\#\\!\\=\\_\\-\\:\\*\"\\?\\[\\]\\  \\$\\£]", "");
                temp = temp.toUpperCase();
                if (temp.length() > 1) {
//                if (wordLetterChecker(e) && e.length() > 1) {
                    if (!wordCount.containsKey(temp)) {
                        wordCount.put(temp, 1);
                    }
                    else {
                        wordCount.put(temp, wordCount.get(temp) + 1);
                    }
                }
            }
        }

        return counter + ": " + spaceFixer.toString();
    }

    public boolean wordLetterChecker(String word) {
        word.toLowerCase();
        for (int i = 0; i < word.length(); i++) {
            if ((int) word.charAt(i) < 65 || (int)word.charAt(i) > 90) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BigText demo = new BigText("maturita/bigText", "big.txt", "newBig.txt", "wordCount.txt", "characterCount.txt");

        demo.textUpdater();
    }
}
