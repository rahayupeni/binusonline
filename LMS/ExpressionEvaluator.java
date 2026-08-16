import java.util.*;

public class ExpressionEvaluator {

    // Konversi infix menjadi postfix
    public String infixToPostfix(String exp) {

        StringBuilder postfix = new StringBuilder();

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < exp.length(); i++) {

            char token = exp.charAt(i);

            // Abaikan spasi
            if (Character.isWhitespace(token)) {
                continue;
            }

            // Jika operand
            if (Character.isLetterOrDigit(token)) {
                postfix.append(token);
            }

            // Jika '('
            else if (token == '(') {
                stack.push(token);
            }

            // Jika ')'
            else if (token == ')') {

                while (!stack.isEmpty()
                        && stack.peek() != '(') {

                    postfix.append(stack.pop());
                }

                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }
            }

            // Jika operator
            else if (isOperator(token)) {

                while (!stack.isEmpty()
                        && stack.peek() != '('
                        && precedence(stack.peek()) >= precedence(token)) {

                    postfix.append(stack.pop());
                }

                stack.push(token);
            }
        }

        // Pop semua operator yang tersisa
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    // Menentukan apakah karakter merupakan operator
    private boolean isOperator(char token) {

        return token == '+'
                || token == '-'
                || token == '*'
                || token == '/';
    }

    // Menentukan precedence operator
    private int precedence(char operator) {

        switch (operator) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            default:
                return 0;
        }
    }

    // Evaluasi ekspresi postfix
    public int evaluatePostfix(String exp) {

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < exp.length(); i++) {

            char token = exp.charAt(i);

            if (Character.isWhitespace(token)) {
                continue;
            }

            // Jika operand berupa angka
            if (Character.isDigit(token)) {

                stack.push(token - '0');
            }

            // Jika operator
            else if (isOperator(token)) {

                int right = stack.pop();
                int left = stack.pop();

                int result = calculate(left, right, token);

                stack.push(result);
            }
        }

        return stack.pop();
    }

    // Melakukan operasi matematika
    private int calculate(int left, int right, char operator) {

        switch (operator) {

            case '+':
                return left + right;

            case '-':
                return left - right;

            case '*':
                return left * right;

            case '/':
                return left / right;

            default:
                throw new IllegalArgumentException(
                        "Operator tidak valid: " + operator
                );
        }
    }
}