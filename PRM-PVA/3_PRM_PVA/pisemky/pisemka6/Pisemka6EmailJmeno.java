package pisemky.pisemka6;

import java.util.HashMap;
import java.util.Map;

public class Pisemka6EmailJmeno {
    private final Map<String, String> names;
    private final Map<String, String> emails;
    public Pisemka6EmailJmeno() {
        this.names = new HashMap<>();
        this.emails = new HashMap<>();
    }

    public HashMap<String, String> getNames() {
        return (HashMap<String, String>) names;
    }

    public HashMap<String, String> getEmails() {
        return (HashMap<String, String>) emails;
    }

    //pridani jmena a emailu
    public void add(String name, String email){
        getNames().put(name, email);
        getEmails().put(email, name);
    }


    //hledani emailu podle jmena
    public void findEmailByName(String name){
        System.out.println(getNames().getOrDefault(name, "Jmeno neexistuje"));
    }

    //hledani jmena podle emailu
    public void findNameByEmail(String email){
        System.out.println(getEmails().getOrDefault(email, "Email neexistuje"));
    }

    public static void main(String[] args) {
        Pisemka6EmailJmeno test = new Pisemka6EmailJmeno();

        test.add("Filip Hajek", "L20210034");
        test.add("Ondrej Vondra", "L20210060");
        test.add("Tomas Chalupa", "L20210039");
        test.add("Radim Homola", "L20210037");
        test.add("Ondrej Chovanec", "L20210040");

        test.findNameByEmail("L20210034");

        System.out.println();

        //je ve strukture
        test.findEmailByName("Ondrej Vondra");
        //neni ve strukture
        test.findEmailByName("Petr Mikyska");

        System.out.println();

        //je ve strukture
        test.findNameByEmail("L20210039");
        //neni ve strukture
        test.findNameByEmail("L20210043");
    }
}
