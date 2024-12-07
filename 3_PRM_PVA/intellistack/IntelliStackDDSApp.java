package intellistack;

public class IntelliStackDDSApp {
    public static void main(String[] args) {
        IntelliStackDDS temp = new IntelliStackDDS();

        System.out.println(temp.isEmpty());

        temp.push(7);
        System.out.println(temp.isEmpty());
        System.out.println(temp.pop());
        System.out.println(temp.isEmpty());
        temp.pop();
    }
}
