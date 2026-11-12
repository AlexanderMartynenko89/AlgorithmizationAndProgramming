package AlgoTasks.t03_sorting2.zadanie33;

import AlgoTasks.t02_sorting.Sorting;
import java.util.ArrayList;
import java.util.List;

public class MergeSort<T extends Comparable<? super T>> implements Sorting<T> {

    @Override
    public void sort(List<T> nums) {
        if (nums.size() <= 1) return;
        slice(nums, 0, nums.size() - 1);
    }

    private void slice(List<T> nums, int start, int end) {
        if (start >= end) return;
        int middle = (start + end) / 2;
        slice(nums, start, middle);
        slice(nums, middle + 1, end);
        merge(nums, start, middle, end);
    }

    private void merge(List<T> nums, int start, int middle, int end) {
        List<T> left = new ArrayList<>(nums.subList(start, middle + 1));
        List<T> right = new ArrayList<>(nums.subList(middle + 1, end + 1));

        int i = 0, j = 0, k = start;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).compareTo(right.get(j)) <= 0) {
                nums.set(k, left.get(i));
                i++;
            } else {
                nums.set(k, right.get(j));
                j++;
            }
            k++;
        }

        while (i < left.size()) {
            nums.set(k, left.get(i));
            i++; k++;
        }
        while (j < right.size()) {
            nums.set(k, right.get(j));
            j++; k++;
        }
    }
}