package srandicka;

import java.util.Scanner;

public class Encryption {
    public static int encryptionValue = 3;
    public static int alphabetSize = 26;
    //English alphabet
    public static String encrypt(String s){
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int charValueForEncrypting = convertToEncryption(s.charAt(i));
            if (!(charValueForEncrypting >= 0 && charValueForEncrypting <= alphabetSize-1)){
                output.append('?');
            }
            else{
                output.append(convertToASCII((charValueForEncrypting + encryptionValue) % alphabetSize));
            }
        }
        return output.toString();
    }

    public static String decrypt(String s){
        StringBuilder output = new StringBuilder();
        s = s.toUpperCase();
        for (int i = 0; i < s.length(); i++) {
            int charValueForEncrypting = convertToEncryption(s.charAt(i));
            if (!(charValueForEncrypting >= 0 && charValueForEncrypting <= alphabetSize-1)){
                output.append('?');
            }
            else {
                output.append(convertToASCII((charValueForEncrypting + (alphabetSize - encryptionValue)) % alphabetSize));
            }
        }
        return output.toString();
    }
    public static int convertToEncryption(char c){
        if (c >= (int) 'A' && c <= (int) 'Z'){
            return (int) c - (int) 'A';
        }
        else if (c >= (int) 'a' && c <= (int) 'z') {
            return (int) c - (int) 'a';
        }
//        else if (c == 32) {
//            return 26;
//        }
        return -1;
    }
    public static char convertToASCII(int a){
        return (char) (a + (int) 'A');
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputEncrypt = "PRM JE SUPER";
        String inputDecrypt = "SUP?MH?VXSHU";

//        System.out.println("Enter prompt");
//        String input = scanner.nextLine();

        System.out.println(inputEncrypt);
        System.out.println(encrypt(inputEncrypt));

        System.out.println();

        System.out.println(inputDecrypt);
        System.out.println(decrypt(inputDecrypt));
//        System.out.println(input.length());
//        System.out.println(output.length());
    }
}
