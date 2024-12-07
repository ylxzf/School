package kaktus;

class Nadoba {

    int objem;
    public Nadoba(int objem){
        this.objem = objem;
    }
    @Override
    public String toString(){
        return super.toString() + " Objem je: " + getObjem();
    }
    public int getObjem() {
        return objem;
    }
    public void setObjem(int i) {
        objem = i;
    }
    public void addObjem(int oKolik) {
        objem += oKolik;
    }

    public static void main(String[] args) {

        Nadoba tuplak = new Nadoba(1);
        Nadoba kybl = new Nadoba(8);

        kybl.setObjem(9);
        tuplak.addObjem(4);

//        System.out.println(tuplak.getObjem() + ", " + kybl.getObjem());
        System.out.println(tuplak.getObjem() + kybl.getObjem());

        System.out.println(tuplak.toString());
    }

}
