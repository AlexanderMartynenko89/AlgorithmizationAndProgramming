package AlgoTasks.t03_sorting2.zadanie31;

import AlgoTasks.t02_sorting.Sorting;
import java.util.List;

public class CountingSort implements Sorting<Integer> {

    @Override
    public void sort(List<Integer> nums) {
        int[] temp = new int[128];

        for (int num : nums) {
            temp[num]++;
        }

        int index = 0;
        for (int number = 0; number < temp.length; number++) {
            while (temp[number] > 0) {
                nums.set(index, number);
                index++;
                temp[number]--;
            }
        }
    }
}