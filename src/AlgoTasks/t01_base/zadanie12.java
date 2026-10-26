package AlgoTasks.t01_base;

import java.util.ArrayList;
import java.util.List;

public class zadanie12 {

    public int removeElementInplace(List<Integer> arr, int val) {
        int NoVal = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) != val) {
                arr.set(NoVal, arr.get(i));
                NoVal++;
            }
        }
        return NoVal;
    }

    public static void main(String[] args) {
        zadanie12 test = new zadanie12();

        List<Integer> arr = new ArrayList<>(List.of(0,2,6,6,1,0,4,6));
        int val = 6;

        int NewSize = test.removeElementInplace(arr, val);

        System.out.println("Новая длинв: " + NewSize);
        System.out.print("Новый массив: ");

        for (int i = 0; i < NewSize; i++) {
            System.out.print(arr.get(i) + " ");
        }
    }
}