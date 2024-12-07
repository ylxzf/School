package intellistack;

public class IntelliStackArrayApp {
    public static void main(String[] args) {
        IntelliStackArray wellwellwell = new IntelliStackArray();

        for (int i = 0; i < 60; i++) {
            wellwellwell.push(i);
            System.out.println("Adding " + i + ".");
            System.out.println(wellwellwell.toString());
            System.out.println();
        }

        System.out.println();

        while (!wellwellwell.isEmpty()){
            System.out.println(wellwellwell.pop());
        }

        System.out.println();

        System.out.println(wellwellwell.capacity());
    }
}
