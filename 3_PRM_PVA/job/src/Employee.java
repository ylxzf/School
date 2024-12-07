public class Employee {

    static int numOfEmployees = 0;
    String name;
    String position;
    int pay;
    public Employee(String name, String position, int pay){
        this.name = name;
        this.position = position;
        this.pay = pay;
        numOfEmployees++;
    }

    public String getEmployeeName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public int getPay() {
        return pay;
    }

    public static int getNumOfEmployees() {
        return numOfEmployees;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void getEmployeeInfo(){
        System.out.println("Name: " + getEmployeeName());
        System.out.println("Position: " + getPosition());
        System.out.println("Pay: " + getPay());
        System.out.println();
    }
}
