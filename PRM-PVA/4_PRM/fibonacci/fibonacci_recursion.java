package fibonacci;
    
public class fibonacci_recursion {

    public static long f(int n) {
        if (n<2){
            return n;
        }
        else {
            return f(n-1) + f(n-2);
        }
    }

    public static void main(String[] args) {
        System.out.println(f(10));
    }
}
