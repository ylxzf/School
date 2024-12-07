package kaktus;


public class Sklenice extends Nadoba {

    boolean ucho;

    public Sklenice(int objem, boolean ucho){
        super(objem);
        this.ucho = ucho;
    }

    public String getUcho() {
        return (this.ucho?"Yes":"No");
    }

    public void setUcho(boolean ucho) {
        this.ucho = ucho;
    }

    public static void main(String[] args){
        Sklenice sklenice = new Sklenice(1, false);
        System.out.println(sklenice.getUcho());
    }
}
