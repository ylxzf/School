package pisemky.pisemka5;

import java.util.Random;

public class Obdelnik {

    int x;
    int y;
    public Obdelnik(){
        this(0, 0);
    }

    public Obdelnik(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getObsah(){
        return getX()*getY();
    }

    @Override
    public String toString(){
        return "Strana x: " + getX() + ", Strana y: " + getY() + ", Obsah: " + getObsah();
    }

    public static void main(String[] args) {
        Random random = new Random();
        Obdelnik demo0 = new Obdelnik(random.nextInt(10) + 1, random.nextInt(10) + 1);

        System.out.println(demo0.toString());

        demo0.setX(2);
        demo0.setY(3);

        System.out.println(demo0.toString());
    }
}
