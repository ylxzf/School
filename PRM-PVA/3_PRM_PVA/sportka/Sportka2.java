package sportka;

import java.util.*;

class Sportka2 {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<Integer> userNumbers = new ArrayList<>();

//        System.out.println("Choose your numbers (1-49)");
//        for (int i = 1; i <= 6; i++) {
//            System.out.print("Number " + i + ": ");
//            int userNumber = scanner.nextInt();
//            while (userNumber>49 || userNumber<0){
//                System.out.print("Incorrect number, try again: ");
//                userNumber = scanner.nextInt();
//            }
//            userNumbers.add(userNumber);
//        }

        int numberCheck;

        for (int i = 0; i < 6; i++) {
            numbers.add(1 + random.nextInt(49));
            if (numbers.size()!=1){
                for (int j = 0; j < numbers.size()-1; j++) {
                    if (Objects.equals(numbers.get(i), numbers.get(j))){
//                        System.out.println(numbers.get(i));
                        numberCheck = numbers.get(i);
//                        System.out.println("replaced");
                        numbers.set(i ,1 + random.nextInt(49));
                        while(numbers.get(i) == numberCheck){
                            numbers.set(i , 1 + random.nextInt(49));
                        }
                        System.out.println(numberCheck + " was replaced by " + numbers.get(i));
                    }
                }
            }
        }
        System.out.println(Arrays.toString(numbers.toArray()));
    }
}
