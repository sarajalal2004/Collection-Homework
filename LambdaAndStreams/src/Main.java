import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.DoubleAccumulator;
import java.util.stream.Collectors;

public class Main {

    private List<Employee> employees = Arrays.asList(
            new Employee("Bezos, Jeff", LocalDate.of(2004, 4, 2), 68_109.00, "Male"),
            new Employee("Sheryl Sandberg", LocalDate.of(2014, 7, 1), 87_846.00, "Female"),
            new Employee("Buffet, Warren", LocalDate.of(2011, 7, 23), 95_035.00, "Male"),
            new Employee("Susan Wojcick", LocalDate.of(2015, 6, 1), 37_210.00, "Female"),
            new Employee("Zuckerberg, Mark", LocalDate.of(2016, 5, 12), 48_450.00, "Male"),
            new Employee("Brin, Sergey", LocalDate.of(2016, 8, 5), 74_416.00, "Male")
    );

    private <E> void printList(List<E> list) {
        // TODO Print out all the elements in the supplied list:
        list.forEach(System.out::println);

    }

    public void getEmployeesOver50k() {
        // TODO Print a list of all employees that earn $50,000 or more
        List<Employee> employees = this.employees.stream().filter( employee -> employee.getSalary()>= 50000).toList();
        printList(employees);
    }

    public void getEmployeeNamesHiredAfter2012() {
        // TODO Print a list of the names (not the Employee instances) of all employees who were hired on or after Jan. 1, 2012:
        // HINT: look it up for "LocalDate.of"
        List<String> employees = this.employees.stream().filter(employee -> !employee.getHireDate().isBefore(LocalDate.of(2012, 1, 1))).map(Employee::getName).toList();
        printList(employees);

    }

    public void getMaxSalary() {
        // TODO Print the maximum salary of all employees...
        double max = this.employees.stream().mapToDouble(Employee::getSalary).max().orElse(0);
        System.out.println("Max:" + max);
    }

    public void getMinSalary() {
        // TODO Print the minimum salary of all employees...
        double min = this.employees.stream().mapToDouble(Employee::getSalary).min().orElse(0);
        System.out.println("Min: " + min);
    }

    public void getAverageSalaries() {
        // TODO print the average salary of all Female and Male employees:
        double averageFemale = this.employees.stream().filter(employee -> employee.getGender().equals("Female")).mapToDouble(Employee::getSalary).average().orElse(0);
        double averageMale = this.employees.stream().filter(employee -> employee.getGender().equals("Male")).mapToDouble(Employee::getSalary).average().orElse(0);

        System.out.println("Averages: Female: " + averageFemale);
        System.out.println("Averages: Male: " + averageMale);
    }

    public void getMaximumPaidEmployee() {
        // TODO use the reduce() operation to find the Employee instance of the employees list with the highest salary:
        Employee highest = this.employees.stream().reduce((first, second) -> first.getSalary() > second.getSalary() ? first : second).orElse(null);
        System.out.println(highest);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.printList(main.employees);
        main.getEmployeesOver50k();
        main.getEmployeeNamesHiredAfter2012();
        main.getMaxSalary();
        main.getAverageSalaries();
        main.getMaximumPaidEmployee();
    }
}