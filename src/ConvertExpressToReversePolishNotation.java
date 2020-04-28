import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ConvertExpressToReversePolishNotation {
    public List<String> convertToRPN(String[] expression) {
        if (expression == null || expression.length == 0) {
            return null;
        }

        List<String> result = new ArrayList<>();
        Stack<String> stack = new Stack<>();

        for (String str : expression) {
            if (str.equals("(")) {
                stack.push(str);
            }
            else if (str.equals(")")) {
                while (!stack.peek().equals("(")) {
                    result.add(stack.pop());
                }
                //pop left "("
                stack.pop();
            }
            else if (Character.isDigit(str.charAt(0))) {
                result.add(str);
            }
            else {
                int priority = getPriority(str);
                while(!stack.isEmpty() && getPriority(stack.peek()) >= priority) {
                    result.add(stack.pop());
                }
                stack.push(str);
            }
        }

        while (!stack.empty()) {
            result.add(stack.pop());
        }

        return result;
    }

    private int getPriority(String str) {
        if (str.equals("*") || str.equals("/")) {
            return 3;
        }
        if (str.equals("+") || str.equals("-")) {
            return 2;
        }
        if (str.equals(")")){
            return 1;
        }
        return 0;
    }
}
