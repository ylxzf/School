package TSP.Kas;

public class TSPhlad {
  
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
  
  static String cesta = "";
  static int delka = 2000000000;
  
  public static void main(String[] args) { 
    
    //for (int i=0; i<graf.length; i++ ) { projdiOd(i); }
    projdiOd(0);
  }
  
  static void projdiOd(int mesto) {
    int soucet=0;
    String kudy = "";
    boolean[] uzTamByl = new boolean[graf.length];
    int aktual = mesto;
    kudy = kudy + String.valueOf(aktual);
    
    for(int i=0; i<uzTamByl.length; i++) uzTamByl[i]=false;
    uzTamByl[mesto] = true;
          int kam = -1; // absurdni hodnota
    
    // hlavni cyklus
    for (int i=0; i<uzTamByl.length-1; i++) {
      
      int tmp_min = 200000000;
      for (int j=0; j<uzTamByl.length; j++) {
        if ( !( (j==aktual) || (uzTamByl[j]) ) ) {
          if (tmp_min>graf[aktual][j]) {tmp_min=graf[aktual][j]; kam=j;}
        } // konec if
      } //konec j
      soucet += tmp_min;
      // System.out.println(tmp_min);
      aktual = kam;
      kudy = kudy + String.valueOf(aktual);
      uzTamByl[kam] = true;
           
    } //konec i
    soucet += graf[kam][mesto];
    
    System.out.print(kudy + "  ");
    System.out.println(soucet);
    
  } // konec metody
  

}
