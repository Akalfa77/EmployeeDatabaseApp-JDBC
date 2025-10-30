import model.Employee;
import service.EmployeeService;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeService service = new EmployeeService();
        int choice;

        do {
            System.out.println("Employee Database App");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Salary");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter name: ");
                    String name = sc.next();
                    System.out.print("Enter department: ");
                    String dept = sc.next();
                    System.out.print("Enter salary: ");
                    double sal = sc.nextDouble();
                    service.addEmployee(new Employee(name, dept, sal));
                }
                case 2 -> {
                    System.out.println("\n--- Employee List ---");
                    service.viewEmployees().forEach(System.out::println);
                }
                case 3 -> {
                    System.out.print("Enter employee ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter new salary: ");
                    double sal = sc.nextDouble();
                    service.updateEmployee(id, sal);
                }
                case 4 -> {
                    System.out.print("Enter employee ID: ");
                    int id = sc.nextInt();
                    service.deleteEmployee(id);
                }
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 5);

        sc.close();
    }
}
