import java.util.*;

class SymbolChecker {
    private String expression;
    private static final Map<String, String> matchingPairs = Map.of(
        "(", ")", "{", "}", "[", "]", "begin", "end", "/*", "*/"
    );

    public SymbolChecker(String expr) { this.expression = expr; }

    // Tokenize Pascal expressions
    public List<String> tokenizePascal() {
        List<String> tokens = new ArrayList<>(Arrays.asList(expression.split("\\s+")));
        tokens.removeIf(token -> !matchingPairs.containsKey(token) && !matchingPairs.containsValue(token));
        return tokens;
    }

    // Tokenize C++ expressions
    public List<String> tokenizeCpp() {
        List<String> tokens = new ArrayList<>();
        for (int i = 0; i < expression.length();) {
            if (expression.startsWith("/*", i)) { tokens.add("/*"); i += 2; }
            else if (expression.startsWith("*/", i)) { tokens.add("*/"); i += 2; }
            else if ("({[)}]".indexOf(expression.charAt(i)) != -1) tokens.add(String.valueOf(expression.charAt(i++)));
            else i++;
        }
        return tokens;
    }

    // Check if symbols are balanced
    public String checkBalance(List<String> tokens) {
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            if (matchingPairs.containsKey(token)) stack.push(token); // Opening symbol
            else if (stack.isEmpty() || !matchingPairs.get(stack.pop()).equals(token)) return "Unbalanced"; // Mismatch
        }
        return stack.isEmpty() ? "Balanced" : "Unbalanced";
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        try {
            System.out.println("Enter 'P' for Pascal or 'C' for C++: ");
            char choice = scanner.next().toUpperCase().charAt(0);
            scanner.nextLine(); // Clear the newline character

            System.out.println("Enter the expression to check for balancing symbols: ");
            String expression = scanner.nextLine();

            SymbolChecker checker = new SymbolChecker(expression);
            List<String> tokens = (choice == 'P') ? checker.tokenizePascal() : checker.tokenizeCpp();
            System.out.println("Result: " + checker.checkBalance(tokens));

        } finally {
            scanner.close();  // Close the scanner in a finally block
        }
    }
}
