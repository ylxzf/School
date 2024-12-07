package sololearn;

import java.util.StringJoiner;

public class fizzBuzzLizz {
    public static void main(String[] args) {

        StringJoiner stringJoiner = new StringJoiner(", ");

//        for (int i = 1; i <= 200; i++) {
//            if (i % 105 == 0){
//                stringJoiner.add("FizzBuzzLizz");
//            } else if (i % 15 == 0) {
//                stringJoiner.add("FizzBuzz");
//            } else if (i % 21 == 0) {
//                stringJoiner.add("FizzLizz");
//            } else if (i % 35 == 0) {
//                stringJoiner.add("BuzzLizz");
//            } else if (i % 7 == 0) {
//                stringJoiner.add("Lizz");
//            } else if (i % 5 == 0) {
//                stringJoiner.add("Buzz");
//            } else if (i % 3 == 0) {
//                stringJoiner.add("Fizz");
//            } else {
//                stringJoiner.add(String.valueOf(i));
//            }
//        }



        for (int i = 1; i <= 200; i++) {
            String result = "";
            if (i % 3 == 0){
                result += "Fizz";
            }
            if (i % 5 == 0){
                result += "Buzz";
            }
            if (i % 7 == 0){
                result += "Lizz";
            }
            if (result.isEmpty()){
                result += String.valueOf(i);
            }
            stringJoiner.add(result);
        }
        System.out.println(stringJoiner.toString());
    }
}
