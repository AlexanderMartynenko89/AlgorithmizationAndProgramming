package AlgoTasks.t02_sorting.zadanie23;

import AlgoTasks.t02_sorting.Sorting;
import java.util.ArrayList;
import java.util.List;

public class StudentSort implements Sorting<Student> {

    @Override
    public void sort(List<Student> students) {
        slice(students, 0, students.size() - 1);
    }

    private void slice(List<Student> students, int start, int end) {
        if (start >= end) return;
        int middle = (start + end) / 2;
        slice(students, start, middle);
        slice(students, middle + 1, end);
        merge(students, start, middle, end);
    }

    private void merge(List<Student> students, int start, int middle, int end) {
        List<Student> temp = new ArrayList<>();
        int left = start;
        int right = middle + 1;

        while (left <= middle && right <= end) {
            if (Compare(students.get(left), students.get(right))) {
                temp.add(students.get(left));
                left++;
            } else {
                temp.add(students.get(right));
                right++;
            }
        }

        while (left <= middle) {
            temp.add(students.get(left));
            left++;
        }
        while (right <= end) {
            temp.add(students.get(right));
            right++;
        }

        for (int i = 0; i < temp.size(); i++) {
            students.set(start + i, temp.get(i));
        }
    }

    private boolean Compare(Student s1, Student s2) {
        if (s1.getAge() < s2.getAge()) {
            return true;
        } else if (s1.getAge() > s2.getAge()) {
            return false;
        } else {
            return s1.getName().compareTo(s2.getName()) <= 0;
        }
    }
}