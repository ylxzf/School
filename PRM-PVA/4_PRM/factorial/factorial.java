package factorial;

public class factorial {
    public static long f(long n) {
        if(n > 1) {
            return n*f(n-1);
        }
        else {
            return n;
        }
    }

    public static void main(String[] args) {
        System.out.println(f(24));
    }
}
