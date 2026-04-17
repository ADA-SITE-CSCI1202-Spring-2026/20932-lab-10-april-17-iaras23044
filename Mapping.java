import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Mapping {
    static class Employee {
        String firstName;
        String lastName;
        double salary;

        public Employee(String firstName, String lastName, double salary) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.salary = salary;
        }
        public String getFirstName(){
            return firstName;
        }
        public String getLastName(){
            return lastName;
        }
        public double getSalary(){
            return salary;
        }
    }
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Ali", "Mammadov", 1200));
        employees.add(new Employee("Veli", "Aliyev", 900));
        employees.add(new Employee("Aysel", "Huseynova", 1500));

        Function<Employee, String> formatCard = e -> "Name: " + e.getFirstName() + ", " + e.getLastName() + " - Salary: $" + e.getSalary();

        Function<Employee, Double> salaryPicker = Employee::getSalary;
        for (Employee e : employees) {
            System.out.println(formatCard.apply(e));
            System.out.println("Salary only: $" + salaryPicker.apply(e));
            System.out.println();
        }
    }
}
