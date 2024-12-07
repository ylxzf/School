package numerics;

public class NewtonSecantMethodApp {
    public static void main(String[] args) {
        NewtonSecantMethod demo = new NewtonSecantMethod(1, 0.0001);

        demo.newtonSecant();
    }
}
