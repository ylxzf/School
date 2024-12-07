public class EmployeeApp {
    public static void main(String[] args) {
        Department realEmployees = new Department("too real");

        Employee employee1 = new Employee("Real", "CEO", 80000);
        Employee employee2 = new Employee("Fake", "Programmer", 50000);

        realEmployees.addEmployee(employee1);
        realEmployees.addEmployee(employee2);

        System.out.println();
        realEmployees.getDepartmentInfo();

        employee1.getEmployeeInfo();
        employee2.getEmployeeInfo();

        System.out.println("Average pay: " + realEmployees.getAveragePay());

    }
}
