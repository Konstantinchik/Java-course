package by.it.plehanova.jd01_12;

import java.util.*;

public class TaskC3 {
    public static void main(String[] args) {
        Deque<Character> bracket = new ArrayDeque<>();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().replaceAll("[^\\[\\]\\(\\)\\{\\}]+", "");

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '[' || ch == '{' || ch == '(') {
                bracket.addLast(ch);
            } else {
                if (bracket.isEmpty()) {
                    System.out.println(false);
                    return;
                } else if (ch == ']' && bracket.getLast() == '[') {
                    bracket.pollLast();
                } else if (ch == ')' && bracket.getLast() == '(') {
                    bracket.pollLast();
                } else if (ch == '}' && bracket.getLast() == '{') {
                    bracket.pollLast();
                } else {
                    System.out.println(false);
                    return;
                }
            }
        }
        System.out.println(bracket.isEmpty());
    }
}
