package pisemky.pisemka5;

import java.util.Random;

public class Kvadr extends Obdelnik {
    int z;

    public Kvadr(){
        this(0, 0, 0);
    }

    public Kvadr(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public int getObjem(){
        return super.getX() * super.getY() * getZ();
    }

    @Override
    public String toString(){
        return "Strana x: " + super.getX() + ", Strana y: " + super.getY() + ", Strana z: " + getZ() + ", Objem: " + getObjem();
    }

    public static void main(String[] args) {
        Random random = new Random();
        Kvadr demo1 = new Kvadr(random.nextInt(10) + 1,random.nextInt(10) + 1,random.nextInt(10) + 1);

        System.out.println(demo1.toString());

        demo1.setX(2);
        demo1.setY(3);
        demo1.setZ(4);

        System.out.println(demo1.toString());
    }
}
