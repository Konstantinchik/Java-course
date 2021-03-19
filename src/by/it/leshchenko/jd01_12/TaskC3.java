package by.it.leshchenko.jd01_12;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        Matcher matcher = Pattern.compile("[()\\[\\]{}]").matcher(s);
        ArrayDeque<String> deque = new ArrayDeque<>();
        boolean result = true;
        while (matcher.find()) {
            String b = matcher.group();

            if (b.equals("(") || b.equals("[") || b.equals("{")) {
                deque.add(b);
            } else if (!((!deque.isEmpty() && (b.equals("]") && deque.pollLast().equals("["))) ||
                    ((!deque.isEmpty() && (b.equals(")") && deque.pollLast().equals("(")))) ||
                    (!deque.isEmpty() && (b.equals("}") && deque.pollLast().equals("{"))))) {
                result = false;
                break;
            }
        }
        System.out.println(result);
    }
}
