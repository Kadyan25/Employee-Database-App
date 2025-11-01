package com.example;

1import java.sql.SQLException;
import java.util.Scanner;

public class TestCRUDOperations {
    public static void main(String[] args) {
        InsertEmployee insertEmployee = new InsertEmployee();
        SelectEmployees selectEmployees = new SelectEmployees();
        UpdateEmployee updateEmployee = new UpdateEmployee();
        DeleteEmployee deleteEmployee = new DeleteEmployee();
        Scanner scanner = new Scanner(System.in);

        try {
            boolean exit = false;
            while (!exit) {
                System.out.println("\nEmployee Database Operations:");
                System.out.println("1. Add Employee");
                System.out.println("2. View All Employees");
                System.out.println("3. Update Employee");
                System.out.println("4. Delete Employee");
                System.out.println("5. Exit");
                System.out.print("Enter your choice (1-5): ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter email: ");
                        String email = scanner.nextLine();
                        System.out.print("Enter country: ");
                        String country = scanner.nextLine();
                        System.out.print("Enter salary: ");
                        double salary = scanner.nextDouble();
                        scanner.nextLine();
                        insertEmployee.insertRecord(name, email, country, salary);
                        break;

                    case 2:
                        selectEmployees.selectAllRecords();
                        break;

                    case 3:
                        System.out.print("Enter employee ID to update: ");
                        int updateId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter new name: ");
                        String newName = scanner.nextLine();
                        System.out.print("Enter new email: ");
                        String newEmail = scanner.nextLine();
                        System.out.print("Enter new country: ");
                        String newCountry = scanner.nextLine();
                        System.out.print("Enter new salary: ");
                        double newSalary = scanner.nextDouble();
                        scanner.nextLine();
                        updateEmployee.updateRecord(updateId, newName, newEmail, newCountry, newSalary);
                        break;

                    case 4:
                        System.out.print("Enter employee ID to delete: ");
                        int deleteId = scanner.nextInt();
                        scanner.nextLine();
                        deleteEmployee.deleteRecord(deleteId);
                        break;

                    case 5:
                        exit = true;
                        break;

                    default:
                        System.out.println("Invalid choice. Please enter 1-5.");
                }
            }
            scanner.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

