package AlgoTasks.t04_FindMin.zadanie42;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PriorityQueueImpl queue = new PriorityQueueImpl();

        while (scanner.hasNext()) {
            String command = scanner.next();
            switch (command) {
                case "enqueue":
                    queue.enqueue(scanner.nextInt());
                    break;
                case "dequeue-max":
                    Integer max = queue.dequeueMax();
                    if (max == null) {
                        System.out.println("*");
                    } else {
                        System.out.println(queue.getLastDequeuedId() + " " + max);
                    }
                    break;
                case "inc":
                    long op = scanner.nextLong();
                    int add = scanner.nextInt();
                    queue.increment(op, add);
                    break;
            }
        }
        scanner.close();
    }
}