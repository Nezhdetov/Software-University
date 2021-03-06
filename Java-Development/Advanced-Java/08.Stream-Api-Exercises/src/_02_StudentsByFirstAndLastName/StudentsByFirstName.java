package _02_StudentsByFirstAndLastName;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentsByFirstName {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Student> students = new ArrayList<>();
        String line;
        while (!(line = scanner.nextLine()).equals("END")) {
            String[] data = line.split(" ");
            String firstName = data[0];
            String lastName = data[1];
            Student student = new Student(firstName, lastName);
            students.add(student);
        }

        students.stream()
                .filter(s -> s.getFirstName().compareTo(s.getLastName()) < 0)
                .forEach(System.out::println);
    }
}

class Student {

    private String firstName;
    private String lastName;

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return String.format("%s %s", firstName, lastName);
    }
}
