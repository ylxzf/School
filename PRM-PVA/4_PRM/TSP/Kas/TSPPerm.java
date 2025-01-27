package TSP.Kas;

import java.util.*;

public class TSPPerm {

  public static int[][] graf = { // 1. index -- radky; 2. index -- sloupce
    {0, 212, 120, 250, 306, 89, 129, 110, 378, 189},
    {212, 0, 93, 295, 95, 294, 145, 266, 168, 401},
    {120, 93, 0, 196, 181, 216, 90, 214, 253, 329},
    {250, 295, 196, 0, 412, 231, 279, 346, 485, 400},
    {306, 95, 181, 412, 0, 390, 204, 330, 125, 497},
    {89, 294, 216, 231, 390, 0, 217, 206, 463, 131},
    {129, 145, 90, 279, 204, 217, 0, 123, 238, 594},
    {110, 266, 214, 346, 330, 206, 123, 0, 339,305},
    {378, 168, 253, 485, 125, 463, 238, 339, 0, 597},
    {189, 401, 329, 400, 497, 131, 594, 305, 597, 0}
  };
  
  public static void main(String[] args) { 
      ArrayList<String> aPoleS = permutation("0123456789");
      int prubezneMin = Integer.MAX_VALUE;
      String prubezneMinString = "";

      int prubeznyMax = Integer.MIN_VALUE;
      String prubeznyMaxString = "";

      for (String s : aPoleS) { //globalni cyklus programu
          String mestaZpet = s + s.substring(0, 1);

          int soucet = 0;
          for (int i = 0; i < s.length(); i++) {
              String dvojString = mestaZpet.substring(i, i + 2);

              int x = Integer.parseInt(dvojString.substring(0, 1));
              int y = Integer.parseInt(dvojString.substring(1, 2));

              soucet += graf[x][y];
//              System.out.printf("[%d;%d] ", x, y);

          }
          if (soucet <= prubezneMin) {
//              System.out.println(mestaZpet + " -> " + soucet);
              prubezneMin = soucet;
              prubezneMinString = s;
          }

          if (soucet >= prubeznyMax) {
              prubeznyMax = soucet;
              prubeznyMaxString = s;
          }
      }

      System.out.println(prubezneMinString + " -> " + prubezneMin);
      System.out.println(prubeznyMaxString + " -> " + prubeznyMax);
  }


  public static ArrayList<String> permutation(String s) {
    // The result
    ArrayList<String> vysl = new ArrayList<String>();
    // If input string's length is 1, return {s}
    if (s.length() == 1) {
        vysl.add(s);
    } else if (s.length() > 1) {
        int lastIndex = s.length() - 1;
        // Find out the last character
        String last = s.substring(lastIndex);
        // Rest of the string
        String rest = s.substring(0, lastIndex);
        // Perform permutation on the rest string and
        // merge with the last character
        vysl = merge(permutation(rest), last);
    }
    return vysl;
  }


  public static ArrayList<String> merge(ArrayList<String> list, String c) {
    ArrayList<String> tmp = new ArrayList<>();
    // Loop through all the string in the list
    for (String s : list) {
        // For each string, insert the last character to all possible positions
        // and add them to the new list
        for (int i = 0; i <= s.length(); ++i) {
            String ps = new StringBuffer(s).insert(i, c).toString();
            tmp.add(ps);
        }
    }
    return tmp;
  }
}
