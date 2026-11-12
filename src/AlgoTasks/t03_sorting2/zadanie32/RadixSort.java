package AlgoTasks.t03_sorting2.zadanie32;

import AlgoTasks.t02_sorting.Sorting;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RadixSort implements Sorting<BigInteger> {

    @Override
    public void sort(List<BigInteger> nums) {
        if (nums.size() == 0) return;

        for (int position = 0; position < 20; position++) {
            countingSortByDigit(nums, position);
        }
    }

    private int getDigit(BigInteger num, int position) {
        BigInteger ten = BigInteger.valueOf(10);
        BigInteger shifted = num.divide(ten.pow(position));
        return shifted.mod(ten).intValue();
    }

    private void countingSortByDigit(List<BigInteger> nums, int position) {
        int n = nums.size();
        List<BigInteger> output = new ArrayList<>(Collections.nCopies(n, BigInteger.ZERO));
        int[] count = new int[10];

        for (int i = 0; i < n; i++) {
            int digit = getDigit(nums.get(i), position);
            count[digit]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int digit = getDigit(nums.get(i), position);
            output.set(count[digit] - 1, nums.get(i));
            count[digit]--;
        }

        for (int i = 0; i < n; i++) {
            nums.set(i, output.get(i));
        }
    }
}