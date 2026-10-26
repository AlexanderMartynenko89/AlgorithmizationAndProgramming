package AlgoTasks.t01_base;

import java.util.ArrayDeque;
import java.util.Deque;

public class zadanie11 {

    public boolean TrueFalseCheck(String str) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char bracket : str.toCharArray()) {
            if (bracket == '{' || bracket == '(' || bracket == '[') {
                stack.push(bracket);
            }
            else {
                if (stack.isEmpty()) {
                    return false;
                }

                char peak = stack.pop();

                if (bracket == '}' && peak != '{') return false;
                if (bracket == ')' && peak != '(') return false;
                if (bracket == ']' && peak != '[') return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        zadanie11 test = new zadanie11();

        System.out.println(test.TrueFalseCheck("[]"));
        System.out.println(test.TrueFalseCheck("[](){}"));
        System.out.println(test.TrueFalseCheck("[({})]"));
        System.out.println(test.TrueFalseCheck("[({}()){}]"));
        System.out.println(test.TrueFalseCheck("{]"));
        System.out.println(test.TrueFalseCheck("({)}"));
    }
}