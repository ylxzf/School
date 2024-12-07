package gcdLcm;

public class GCD_LCM {
    private final long num1;
    private final long num2;

    public GCD_LCM(long num1, long num2) {
        if (num1 == num2){
            this.num1 = num1;
            this.num2 = num2;
        }
        else {
            this.num1 = Math.max(num1, num2);
            this.num2 = Math.min(num1, num2);
        }
    }

    public long getNum1() {
        return num1;
    }

    public long getNum2() {
        return num2;
    }

    private long GCD(long num1, long num2) {
        if (num2 != 0) {
            return GCD(num2, num1 % num2);
        }
        else {
            return num1;
        }
    }

    public long getGCD(){
        return GCD(num1,num2);
    }

    public long getLCM(){
        return (num1*num2)/(GCD(num1,num2));
    }
}
