package intelliQueue;

public class IntelliQueueDDSApp {
    public static void main(String[] args) {
        IntelliQueueDDS fr = new IntelliQueueDDS();

        System.out.println(fr.isEmpty());

        fr.add(7);
        fr.add(13);

        System.out.println(fr.isEmpty());

        while (!fr.isEmpty()) {
            System.out.println(fr.remove());
        }
    }
}
