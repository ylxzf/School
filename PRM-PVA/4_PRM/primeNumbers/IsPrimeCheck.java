package primeNumbers;

import java.util.ArrayList;
import java.util.Arrays;


public class IsPrimeCheck {

    public ArrayList<Integer> sieveOfEratosthenesArrayList(int n) {
        ArrayList<Integer> nums = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            nums.add(i);
        }
        for (int i = 1; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                if (nums.get(j) % nums.get(i) == 0) {
                    nums.remove(j);
                }
            }
        }

        return nums;
    }

    public boolean[] sieveOfEratosthenesBooleans(int n) {
        boolean[] nums = new boolean[n];
        Arrays.fill(nums, true);
        nums[0] = nums[1] = false;

        for (int i = 2; i < nums.length; i++) {
            for (int j = 2; j < nums.length; j++) {
                if (j % i == 0 && j!=i) {
                    nums[j] = false;
                }
            }
        }

        return nums;
    }

    public boolean isPrimeUsingSieveOfEratosthenesBooleans(int n) {
        return sieveOfEratosthenesBooleans(n+1)[n];
    }

    public boolean isPrime(int input) {
        for (int i = 2; i < Math.sqrt(input); i++) {
            if(input % i == 0){
                return false;
            }
        }
        return true;
    }

}
