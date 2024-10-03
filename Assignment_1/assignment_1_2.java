import java.util.Stack;

public class BalancedSymbols {
    public static boolean isBalanced(String expression) {
        Stack<String> stack = new Stack<>();
        
        for (int i = 0; i < expression.length(); i++) {
            // Handle multi-character symbols
            if (i + 1 < expression.length() && expression.substring(i, i + 2).equals("/*")) {
                stack.push("/*");
                i++;
            } else if (i + 2 < expression.length() && expression.substring(i, i + 3).equals("end")) {
                if (stack.isEmpty() || !stack.pop().equals("begin")) {
                    return false;
                }
                i += 2;
            } else if (i + 4 < expression.length() && expression.substring(i, i + 5).equals("begin")) {
                stack.push("begin");
                i += 4;
            } else if (i + 1 < expression.length() && expression.substring(i, i + 2).equals("*/")) {
                if (stack.isEmpty() || !stack.pop().equals("/*")) {
                    return false;
                }
                i++;
            } else if (expression.charAt(i) == '(' || expression.charAt(i) == '{' || expression.charAt(i) == '[') {
                stack.push(String.valueOf(expression.charAt(i)));
            } else if (expression.charAt(i) == ')' || expression.charAt(i) == '}' || expression.charAt(i) == ']') {
                if (stack.isEmpty()) return false;
                char top = stack.pop().charAt(0);
                if ((expression.charAt(i) == ')' && top != '(') || 
                    (expression.charAt(i) == '}' && top != '{') || 
                    (expression.charAt(i) == ']' && top != '[')) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isBalanced("([]{})") ? "Balanced" : "Unbalanced");
        System.out.println(isBalanced("([)]") ? "Balanced" : "Unbalanced");
        System.out.println(isBalanced("/* begin */") ? "Balanced" : "Unbalanced");
        System.out.println(isBalanced("/* begin ]") ? "Balanced" : "Unbalanced");
    }
}
