package by.it.kglushchenko.jd01_12;

import java.util.Scanner;
import java.util.Stack;

public class TaskC3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String inputString;

        BracketsValidator validator = new BracketsValidator();

        while (!(inputString = scanner.next()).equals("end")) {
            String sentence = inputString;
            boolean correct = validator.validate(inputString);
            System.out.println("Скобки расставлены " + (correct ? "" : "не") + "правильно");
        }

    }


    public static class BracketsValidator {
        private Stack<Character> stack = new Stack<Character>();

        private boolean isOpeningBracket(char bracket) {
            return "({[".indexOf(bracket) != -1;
        }

        private boolean isClosingBracket(char bracket) {
            return ")}]".indexOf(bracket) != -1;
        }

        private boolean isPair(char opening, char closing) {
            return opening == '(' && closing == ')' || opening == '['
                    && closing == ']' || opening == '{' && closing == '}';
        }

        public boolean validate(String input) {
            for (char c : input.toCharArray()) {
                if (isClosingBracket(c) && stack.isEmpty()) {
                    return false;
                }
                if (isOpeningBracket(c)) {
                    stack.push(c);
                }
                if (isClosingBracket(c)) {
                    if (isPair(stack.peek(), c)) {
                        stack.pop();
                    }
                    else
                        return false; // если внутри скобок появилась не парная
                }
            }
            return stack.isEmpty();
        }

    }
}
