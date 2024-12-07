import java.util.ArrayList;

public class Department {
    String name;
    ArrayList<Employee> listOfEmployeesInDepartment = new ArrayList<>();
    public Department(String name){
        this.name = name;
    }

    public String getDepartmentName() {
        return name;
    }

    public void addEmployee(Employee employee){
        listOfEmployeesInDepartment.add(employee);
    }

    public ArrayList<String> getListOfEmployeeNames(){
        ArrayList<String> listOfEmployeeNamesInDepartment = new ArrayList<>();
        for (Employee e: listOfEmployeesInDepartment) {
            listOfEmployeeNamesInDepartment.add(e.getEmployeeName());
        }
        return listOfEmployeeNamesInDepartment;
    }

    public void getDepartmentInfo(){
        System.out.println("Department name: " + getDepartmentName());
        System.out.println("Number of employees: " + listOfEmployeesInDepartment.size());
        System.out.println("List of employees: " + getListOfEmployeeNames());
        System.out.println();
    }

    public int getAveragePay(){
        int payTotal = 0;
        for (Employee e: listOfEmployeesInDepartment) {
            payTotal += e.getPay();
        }
        return payTotal/listOfEmployeesInDepartment.size();
    }
}
