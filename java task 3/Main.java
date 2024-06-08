import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner scanner = new Scanner(System.in);
        manager.loadFromFile("students.dat");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add a new student");
            System.out.println("2. Remove a student by ID");
            System.out.println("3. Update student details by ID");
            System.out.println("4. Search for a student by ID");
            System.out.println("5. Display all students");
            System.out.println("6. Exit and save data");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter ID:");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.println("Enter name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter age:");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.println("Enter grade:");
                    String grade = scanner.nextLine();
                    System.out.println("Enter address:");
                    String address = scanner.nextLine();
                    manager.addStudent(new Student(id, name, age, grade, address));
                    break;
                case 2:
                    System.out.println("Enter ID:");
                    id = scanner.nextInt();
                    manager.removeStudent(id);
                    break;
                case 3:
                    System.out.println("Enter ID:");
                    id = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.println("Enter name:");
                    name = scanner.nextLine();
                    System.out.println("Enter age:");
                    age = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.println("Enter grade:");
                    grade = scanner.nextLine();
                    System.out.println("Enter address:");
                    address = scanner.nextLine();
                    manager.updateStudent(id, name, age, grade, address);
                    break;
                case 4:
                    System.out.println("Enter ID:");
                    id = scanner.nextInt();
                    Student student = manager.searchStudent(id);
                    if (student != null) {
                        System.out.println(student);
                    } else {
                        System.out.println("Student with ID " + id + " not found.");
                    }
                    break;
                case 5:
                    manager.displayAllStudents();
                    break;
                case 6:
                    manager.saveToFile("students.dat");
                    System.out.println("Data saved. Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
