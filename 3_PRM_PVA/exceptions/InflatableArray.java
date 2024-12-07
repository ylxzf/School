package exceptions;

public class InflatableArray {
    public static void main(String[] args) {
        int n = 10;
        int[] pole = new int[n];

        for (int i = 0; i < 50; i++) {
            try{
                pole[i] = 2*i;
            }
            catch (ArrayIndexOutOfBoundsException e){
                int[] newPole = new int[pole.length + 5];
                System.arraycopy(pole, 0, newPole, 0, pole.length);
                newPole[i] = 2*i;
                pole = newPole;
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

        for (int e: pole
             ) {
            System.out.print(e + ", ");
        }
    }
}
