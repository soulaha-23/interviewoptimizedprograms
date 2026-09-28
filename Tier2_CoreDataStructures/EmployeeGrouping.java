import java.util.*;
import java.util.stream.Collectors;

class Employee {

    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name,
                    String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
}

public class EmployeeGrouping {

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee(1, "A", "IT", 50000),
                new Employee(2, "B", "IT", 70000),
                new Employee(3, "C", "HR", 60000),
                new Employee(4, "D", "HR", 80000)
        );

        Map<String, Double> averageSalary =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.averagingDouble(
                                        Employee::getSalary
                                )
                        ));

        System.out.println(averageSalary);

        Map.Entry<String, Double> highest =
                averageSalary.entrySet()
                        .stream()
                        .max(Map.Entry.comparingByValue())
                        .orElse(null);

        System.out.println(highest);
    }
}
