import java.util.*;

class Student {
    int id;
    String name;
    List<Course> courses = new ArrayList<>();

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    void enrollCourse(Course c) {
        courses.add(c);
        System.out.println(name + " enrolled in " + c.courseName);
    }

    void showCourses() {
        System.out.println("Courses for " + name + ":");
        for (Course c : courses) {
            System.out.println("- " + c.courseName);
        }
    }
}

class Course {
    int courseId;
    String courseName;

    Course(int id, String name) {
        this.courseId = id;
        this.courseName = name;
    }
}

public class StudentCourseManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> students = new ArrayList<>();
        List<Course> courses = new ArrayList<>();

        courses.add(new Course(101, "Mathematics"));
        courses.add(new Course(102, "Physics"));
        courses.add(new Course(103, "Computer Science"));

        while (true) {
            System.out.println("\n--- Student Course Management ---");
            System.out.println("1. Add Student");
            System.out.println("2. Enroll Student in Course");
            System.out.println("3. Show Student Courses");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();
                    students.add(new Student(id, name));
                    System.out.println("Student added successfully.");
                    break;

                case 2:
                    System.out.print("Enter Student ID: ");
                    int sid = sc.nextInt();
                    Student s = null;
                    for (Student st : students) {
                        if (st.id == sid) s = st;
                    }
                    if (s == null) {
                        System.out.println("Student not found.");
                        break;
                    }
                    System.out.println("Available Courses:");
                    for (Course c : courses) {
                        System.out.println(c.courseId + " - " + c.courseName);
                    }
                    System.out.print("Enter Course ID: ");
                    int cid = sc.nextInt();
                    Course selected = null;
                    for (Course c : courses) {
                        if (c.courseId == cid) selected = c;
                    }
                    if (selected != null) {
                        s.enrollCourse(selected);
                    } else {
                        System.out.println("Invalid course ID.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Student ID: ");
                    int sid2 = sc.nextInt();
                    Student s2 = null;
                    for (Student st : students) {
                        if (st.id == sid2) s2 = st;
                    }
                    if (s2 != null) {
                        s2.showCourses();
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting... Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
