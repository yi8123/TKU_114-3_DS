import java.util.Stack;

public class BracketValidationSystem {

    private boolean isPair(char left, char right) {
        return (left == '(' && right == ')') ||
               (left == '[' && right == ']') ||
               (left == '{' && right == '}');
    }

    private boolean isLeftBracket(char ch) {
        return ch == '(' || ch == '[' || ch == '{';
    }

    private boolean isRightBracket(char ch) {
        return ch == ')' || ch == ']' || ch == '}';
    }

    public boolean validate(String expression) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (isLeftBracket(ch)) {
                stack.push(ch);
            } else if (isRightBracket(ch)) {
                if (stack.isEmpty()) {
                    return false;
                }
                char left = stack.pop();
                if (!isPair(left, ch)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        BracketValidationSystem validator = new BracketValidationSystem();

        String[] testCases = {
            "a * (b + c) - {d / [e - f]}",
            "((a + b)",
            "a + b)",
            "([a + b)]",
            "",
            "{[()]}"
        };

        for (String expression : testCases) {
            System.out.println("表達式: \"" + expression + "\" -> 驗證結果: " + validator.validate(expression));
        }
    }
}