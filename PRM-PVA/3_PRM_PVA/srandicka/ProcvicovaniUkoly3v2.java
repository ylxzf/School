package srandicka;

import java.util.ArrayList;
class ProcvicovaniUkoly3v2 {
    public static void main(String[] args) {
        ArrayList<String> result = new ArrayList<>();

        int gum1 = 3;
        int gum2 = 5;
        int gumTotal = 501;

        for (int gum1amount = 0; gum1amount * gum1 <= gumTotal; gum1amount++) {
            for (int gum2amount = 0; gum2amount * gum2 <= gumTotal; gum2amount++) {
                int costTotal = gum1amount * gum1 + gum2amount * gum2;
                if (costTotal == gumTotal) {
                    String resultStr = gum1amount + " of " + gum1 + " Kč gum , " + gum2amount + " of " + gum2 + " Kč gum";
                    result.add(resultStr);
                }
            }
        }

        for (String r : result) {
            System.out.println(r);
        }
    }
}
