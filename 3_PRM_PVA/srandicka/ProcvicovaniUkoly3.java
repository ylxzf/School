package srandicka;

import java.util.ArrayList;
import java.util.List;

    class ProcvicovaniUkoly3 {
        public static void main(String[] args) {
            List<String> result = findResult(3, 5, 501);

                for (String r : result) {
                    System.out.println(r);
                }
        }

        public static List<String> findResult(int gum1, int gum2, int gumTotal) {
            List<String> result = new ArrayList<>();

            for (int gum1amount = 0; gum1amount * gum1 <= gumTotal; gum1amount++) {
                for (int gum2amount = 0; gum2amount * gum2 <= gumTotal; gum2amount++) {
                    int costTotal = gum1amount * gum1 + gum2amount * gum2;
                    if (costTotal == gumTotal) {
                        String resultStr = gum1amount + " pieces for " + gum1 + " Kč, " + gum2amount + " pieces for " + gum2 + " Kč";
                        result.add(resultStr);
                    }
                }
            }
            return result;
        }
    }


