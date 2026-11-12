package AlgoTasks.t03_sorting2.zadanie33;

import AlgoTasks.t02_sorting.Sorting;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Main {

    private static <T extends Comparable<? super T>> void test(String title, List<T> items) {
        Sorting<T> sorter = new MergeSort<>();
        sorter.sort(items);

        System.out.println(title + ":");
        for (T item : items) {
            System.out.println(item);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>(List.of(1, -177, 0, 99));
        test("Integer", ints);

        List<String> strings = new ArrayList<>(List.of("asd", "sdf", "afg", "ghj"));
        test("String", strings);

        List<LocalDateTime> dates = new ArrayList<>(List.of(
                LocalDateTime.of(2026, 11, 13, 23, 59),
                LocalDateTime.of(1993, 7, 17, 17, 17),
                LocalDateTime.of(2007, 1, 28, 15, 19),
                LocalDateTime.of(2007, 5, 18, 6, 0)
        ));
        test("LocalDateTime", dates);

        List<UUID> uuids = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            uuids.add(UUID.randomUUID());
        }
        test("UUID", uuids);

        List<Student> students = new ArrayList<>(List.of(
                new Student("Vasya", 21),
                new Student("Vasya", 19),
                new Student("Anton", 22),
                new Student("Antonio", 23)
        ));
        test("Student", students);
    }
}