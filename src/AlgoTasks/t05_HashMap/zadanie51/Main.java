package AlgoTasks.t05_HashMap.zadanie51;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMapImpl<String> map = new HashMapImpl<>();

        while (scanner.hasNext()) {
            String command = scanner.next();
            switch (command) {
                case "put":
                    String keyPut = scanner.next();
                    String valuePut = scanner.next();
                    map.put(keyPut, valuePut);
                    break;
                case "get":
                    String keyGet = scanner.next();
                    String result = map.getValue(keyGet);
                    if (result == null) {
                        System.out.println("null");
                    } else {
                        System.out.println(result);
                    }
                    break;
                case "delete":
                    String keyDel = scanner.next();
                    map.delete(keyDel);
                    break;
            }
        }
        scanner.close();
    }
}