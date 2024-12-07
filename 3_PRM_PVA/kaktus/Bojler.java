package kaktus;

public class Bojler extends Nadoba {
    int teplota;
    public Bojler(){
        this(0,0);
    }
    public Bojler(int objem){
        this(objem, 0);
    }
    public Bojler(int objem, int tep) {
        super(objem);
        this.teplota = tep;
    }

    @Override
    public String toString(){
        return String.format("Ahoj, mam %dl, teplotu %d stupnu.", getObjem(), getTeplota());
    }

    public int getTeplota(){
        return this.teplota;
    }

    public void setTeplota(int teplota){
        this.teplota = teplota;
    }

    public void setTeplota(){
        setTeplota(0);
    }

    public static void main(String[] args) {
        Bojler b52 = new Bojler(50, 20);

        System.out.println(b52.toString());
        b52.setTeplota(75);
        System.out.println(b52.toString());
        b52.setTeplota();
        System.out.println(b52.toString());
    }
}
