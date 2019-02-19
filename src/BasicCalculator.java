import java.util.Stack;

public class BasicCalculator {
    public int calculate(String s) {
        int result = 0;
        int number = 0; // use "number" variable to save current number
        int sign = 1;

        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                number = 10 * number + (int)(c - '0');
            }
            else if (c == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            }
            else if (c == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            }
            else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                //reset the sign and result for the value in the parenthesis
                sign = 1;
                result = 0;
            }
            else if (c == ')') {
                result += sign * number;
                number = 0;

                result *= stack.pop(); //stack.pop() is the sign before the parenthesis
                result += stack.pop(); //stack.pop() now is the result calculated before the parenthesis
            }
        }

        if (number != 0) {
            result += sign * number;
        }

        return result;
    }
}
