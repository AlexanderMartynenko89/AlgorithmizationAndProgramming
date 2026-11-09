package AlgoTasks.t02_sorting.zadanie23;

import AlgoTasks.t02_sorting.Sorting;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = scanner.next();
            int age = scanner.nextInt();
            students.add(new Student(name, age));
        }

        Sorting<Student> sorter = new StudentSort();
        sorter.sort(students);

        for (Student s : students) {
            System.out.println(s.getName() + " " + s.getAge());
        }

        scanner.close();
    }
}