package primeNumbers;

import java.util.ArrayList;
import java.util.Arrays;

public class IsPrimeCheckApp {
    public static void main(String[] args) {
        IsPrimeCheck primeCheck = new IsPrimeCheck();

//        System.out.println(primeCheck.isPrime(30029));
//        System.out.println(Arrays.toString(new ArrayList[]{primeCheck.sieveOfEratosthenesArrayList(20000)}));

        System.out.println(primeCheck.isPrimeUsingSieveOfEratosthenesBooleans(30028));
    }
}