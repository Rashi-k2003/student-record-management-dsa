import java.util.Scanner;

class Student {
    int id;
    String name;
    int marks;

    Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }
}

public class StudentManagement {
    static Student[] students = new Student[50];
    static int count = 0;

    public static void addStudent(int id, String name, int marks) {
        students[count++] = new Student(id, name, marks);
        System.out.println("Student added successfully!");
    }

    public static void displayStudents() {
        if (count == 0) {
            System.out.println("No records found.");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println(students[i].id + " " +
                               students[i].name + " " +
                               students[i].marks);
        }
    }

    public static void searchStudent(int id) {
        for (int i = 0; i < count; i++) {
            if (students[i].id == id) {
                System.out.println("Student Found:");
                System.out.println(students[i].id + " " +
                                   students[i].name + " " +
                                   students[i].marks);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public static void sortByMarks() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (students[j].marks > students[j + 1].marks) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
        System.out.println("Students sorted by marks.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1.Add Student\n2.Display\n3.Search\n4.Sort\n5.Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Marks: ");
                    int marks = sc.nextInt();
                    addStudent(id, name, marks);
                    break;

                case 2:
                    displayStudents();
                    break;

                case 3:
                    System.out.print("Enter ID to search: ");
                    int searchId = sc.nextInt();
                    searchStudent(searchId);
                    break;

                case 4:
                    sortByMarks();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);

        sc.close();
    }
}
