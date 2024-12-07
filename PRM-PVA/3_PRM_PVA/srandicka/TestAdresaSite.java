package srandicka;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringJoiner;

public class TestAdresaSite {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputAddress = scanner.next();
        int inputMask = scanner.nextInt();


        String[] inputAddressArrayString = inputAddress.split("\\.");
        int[] maskArray = new int[32];
        String[] maskArrayFinal = new String[4];
        int[] maskArrayDeciaml = new int[4];
        String[] negatedMaskFinal = new String[4];
        int[] negatedMaskDecimal = new int[4];

        for (int i = 0; i < inputMask; i++) {
            maskArray[i] = 1;
        }

        for (int i = 0; i < 8; i++) {
            if (i==0){
                maskArrayFinal[0] = String.valueOf(maskArray[i]);
                maskArrayFinal[1] = String.valueOf(maskArray[i+8]);
                maskArrayFinal[2] = String.valueOf(maskArray[i+16]);
                maskArrayFinal[3] = String.valueOf(maskArray[i+24]);
            }
            else {
                maskArrayFinal[0] += String.valueOf(maskArray[i]);
                maskArrayFinal[1] += String.valueOf(maskArray[i+8]);
                maskArrayFinal[2] += String.valueOf(maskArray[i+16]);
                maskArrayFinal[3] += String.valueOf(maskArray[i+24]);
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 8; j++) {
                maskArrayDeciaml[i] += (int) (Integer.parseInt(String.valueOf(maskArrayFinal[i].charAt(j)))*Math.pow(2, 7-j));
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 8; j++) {
                if (j==0){
                    if (maskArrayFinal[i].charAt(j)=='0'){
                        negatedMaskFinal[i] = String.valueOf( '1');
                    }
                    else if (maskArrayFinal[i].charAt(j)=='1') {
                        negatedMaskFinal[i] = String.valueOf('0');
                    }
                }
                else {
                    if (maskArrayFinal[i].charAt(j)=='0'){
                        negatedMaskFinal[i] += '1';
                    }
                    else if (maskArrayFinal[i].charAt(j)=='1') {
                        negatedMaskFinal[i] += '0';
                    }
                }

            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 8; j++) {
                negatedMaskDecimal[i] += (int) (Integer.parseInt(String.valueOf(negatedMaskFinal[i].charAt(j)))*Math.pow(2, 7-j));
            }
        }

        StringJoiner maskJoiner = new StringJoiner(".");
        for (int e : maskArrayDeciaml) {
            maskJoiner.add(String.valueOf(e));
        }
        System.out.println("Default mask: " + maskJoiner.toString());

        StringJoiner negatedMaskJoiner = new StringJoiner(".");
        for (int e : negatedMaskDecimal) {
            negatedMaskJoiner.add(String.valueOf(e));
        }
        System.out.println("Negated mask: " + negatedMaskJoiner.toString());

        StringJoiner originalIPAddress = new StringJoiner(".");
        for (String e : inputAddressArrayString) {
            originalIPAddress.add(String.valueOf(e));
        }
        System.out.println("Original IP Address: " + originalIPAddress.toString());

        StringJoiner networkAddress = new StringJoiner(".");
        int[] networkAddressArray = new int[4];
        for (int i = 0; i < 4; i++) {
            networkAddressArray[i] = Integer.parseInt(inputAddressArrayString[i]) & maskArrayDeciaml[i];
        }
        for (int e : networkAddressArray) {
            networkAddress.add(String.valueOf(e));
        }
        System.out.println("Network Address: " + networkAddress.toString());


        StringJoiner broadcastAddress = new StringJoiner(".");
        int[] broadcastAddressArray = new int[4];
        for (int i = 0; i < 4; i++) {
            broadcastAddressArray[i] = Integer.parseInt(inputAddressArrayString[i]) | negatedMaskDecimal[i];
        }
        for (int e : broadcastAddressArray) {
            broadcastAddress.add(String.valueOf(e));
        }
        System.out.println("Broadcast Address: " + broadcastAddress.toString());
    }
}
