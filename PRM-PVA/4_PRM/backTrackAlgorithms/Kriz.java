package backTrackAlgorithms;

public class Kriz {
   static int[] cross = new int[5];
   static int level = -1;
   static int kolik,testu;

   static public void bt(){    //backtrack
        level++;

        for (int i = 1; i <= 8; i++){
            cross[level] = i;
            testu++;
            if(test() ){
                bt();
            }
        }
            
        

        level--;
   }

   static boolean test(){
    switch (level){
        case 0: return true;
        case 1: return (cross[0]+cross[1] == 10);
        case 2: return (cross[0]>cross[2]);
        case 3: return (cross[0]-cross[3] > 2);
        case 4: if(cross[0]*cross[4] > 20){ 

                for(int i=0; i<5; i++){
                    
                System.out.print(cross[i] + " ");}
                System.out.println();
                kolik ++;
                }
                return false;
            }
    return true;
   }

   public static void main(String[] args) {
        bt(); //spustí backtrack
        System.out.println(kolik);
        System.out.println(testu);
   }
}



