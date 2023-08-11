package demo;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Employees> employees;
    private static Scanner scanner;
    private static int id = 0;

    public static void main(String[] args) {

        employees = new ArrayList<>();
        System.out.println("Welcome");
        showInitialOption();
    }

    private static void showInitialOption() {
        System.out.println("Please select one " +
                "\n\t1. Manage Employees" +
                "\n\t2. Quit");
        scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                showManageContact();
                break;
            default:
                break;
        }
    }

    private static void showManageContact() {
        System.out.println("Please select one" +
                "\n\t1. Show all employees" +
                "\n\t2. Search for an employee" +
                "\n\t3. Add employee" +
                "\n\t4. Delete an employee record" +
                "\n\t5. Go back");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                showAllContact();
                break;
            case 2:
                searchContact();
                break;
            case 3:
                AddNewContact();
                break;
            case 4:
                showDeleteContact();
                break;
            default:
                showInitialOption();
                break;
        }
    }

    private static void showDeleteContact() {
        System.out.println("Enter employee name to delete");
        String name = scanner.next();

        if (name.equals("")) {
            System.out.println("Please fill the empty field");
            showDeleteContact();
        } else {
            boolean doesExist = false;
            for (Employees c : employees) {
                if (c.getName().equalsIgnoreCase(name)) {
                    doesExist = true;
                    employees.remove(c);
                }
            }
            if (!doesExist) {
                System.out.println("There is no such record.");
            }
        }
        showInitialOption();
    }

    private static void AddNewContact() {
        System.out.print("Adding new employee..." +
                "\nName: ");
        String name = scanner.next();
//        scanner.nextLine();
        System.out.print("ID: ");
        String id = scanner.next();
//        scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.next();
//        scanner.nextLine();

        if (name.equals("") || id.equals("") || email.equals("")) {
            System.out.println("Please don't leave the field blank!");
            AddNewContact();
        } else {
            boolean doesExist = false;
            for (Employees c : employees) {
                if (name.equalsIgnoreCase(c.getName())) {
                    doesExist = true;
                }
            }
            if (doesExist) {
                System.out.println("The name " + name + " already exist!.");
                AddNewContact();
            } else {
                Employees contact = new Employees(name, id, email);
                employees.add(contact);
                System.out.println("Employee has been added successfully");
            }
        }
        showInitialOption();
    }

    private static void showAllContact() {
        if (employees.size() > 0) {
            for (Employees c : employees) {
                c.getDetails();
                System.out.println("*********************************");
            }
        } else {
            System.out.println("No record found!");
        }
        showInitialOption();
    }

    private static void searchContact() {
        System.out.print("Enter the employee name: ");
        String name = scanner.next();

        if (name.equals("")) {
            System.out.println("Please enter the employee name");
            searchContact();
        } else {
            boolean doesExist = false;
            for (Employees c : employees) {
                if (name.equalsIgnoreCase(c.getName())) {
                    doesExist = true;
                    c.getDetails();
                }
            }
            if (!doesExist) {
                System.out.println("There is no such record.");
            }
        }
        showInitialOption();
    }

}
