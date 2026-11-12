package AlgoTasks.t03_sorting2.zadanie32;

import AlgoTasks.t02_sorting.Sorting;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        List<BigInteger> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums.add(scanner.nextBigInteger());
        }

        Sorting<BigInteger> sorter = new RadixSort();
        sorter.sort(nums);

        for (BigInteger num : nums) {
            System.out.println(num);
        }

        scanner.close();
    }
}