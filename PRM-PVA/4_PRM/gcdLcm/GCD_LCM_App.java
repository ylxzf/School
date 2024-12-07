package gcdLcm;

public class GCD_LCM_App {
    public static void main(String[] args) {
        GCD_LCM gcdLcm = new GCD_LCM(4, 7);
        System.out.printf("GCD(%d, %d) = %d\n", gcdLcm.getNum1(), gcdLcm.getNum2(), gcdLcm.getGCD());
        System.out.printf("LCM(%d, %d) = %d\n", gcdLcm.getNum1(), gcdLcm.getNum2(), gcdLcm.getLCM());
    }
}