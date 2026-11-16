package AlgoTasks.t04_FindMin.zadanie41;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MinStackImpl stack = new MinStackImpl();

        while (scanner.hasNext()) {
            String command = scanner.next();

            switch (command) {
                case "push":
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    stack.pop();
                    break;
                case "top":
                    Integer topVal = stack.top();
                    if (topVal != null) System.out.println(topVal);
                    break;
                case "min":
                    Integer minVal = stack.min();
                    if (minVal != null) System.out.println(minVal);
                    break;
            }
        }
        scanner.close();
    }
}