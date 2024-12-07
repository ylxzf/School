package pisemky;

import java.util.ArrayList;

public class DeliteleCisla {
    private final int num;
    public DeliteleCisla(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public ArrayList<Integer> divisors() {
        ArrayList<Integer> divisors = new ArrayList<>();

        for (int i = 1; i <= num/2; i++) {
            if (num % i == 0) {
                divisors.add(i);
            }
        }

        divisors.add(num);

        return divisors;
    }

    public static void main(String[] args) {
        DeliteleCisla demo = new DeliteleCisla(1801068721);

        System.out.printf("Dělitelé %d: %s", demo.getNum(), demo.divisors());
    }
}
