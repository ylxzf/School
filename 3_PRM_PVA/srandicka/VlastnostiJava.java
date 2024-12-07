package srandicka;

class VlastnostiJava {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("----------------------------------");
        System.out.println();

        System.out.println("Zobecnění přiřazovacího příkazu: ");
        System.out.println();

        int x = 0;

        x = x+2;
        System.out.println("x = x + 2: " + x);

        x=0;

        x += 2;
        System.out.println("x += 2"  + x);

        System.out.println();
        System.out.println("----------------------------------");
        System.out.println();

        int a = 7;
        int b = a++;

        System.out.println("a++ příklad: ");
        System.out.println();
        System.out.println("a = 7, b = a++");
        System.out.println("b = " + b);
        System.out.println("a = " + a);


        System.out.println("++a příklad: ");
        System.out.println();
        System.out.println("a = 7, b = ++a");
        a = 7;
        b = ++a;

        System.out.println("b = " + b);
        System.out.println("a = " + a);


        System.out.println();
        System.out.println("----------------------------------");
        System.out.println();

        System.out.println("Ternární operátor: ");
        System.out.println();

        int k = 1;
        int l = 2;

        int m = 0;

        System.out.println("k = 1, l = 2");
        System.out.println("k>l ? 1 : 2");
        System.out.print("m = ");
        System.out.print(k>l ? 1 : 2);
        System.out.println();
        
        System.out.println();
        System.out.println("----------------------------------");
        System.out.println();
    }
}
