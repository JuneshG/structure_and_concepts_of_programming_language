class SymbolChecker:
    def __init__(self, expression):
        self.expression = expression

    # Tokenize Pascal expressions using built-in functions
    def tokenize_pascal(self):
        tokens = self.expression.split()  # Split the expression by spaces and symbols
        cleaned_tokens = [token for token in tokens if token in {"begin", "end", "(", ")", "{", "}", "[", "]"}]
        print(f"Filtered Pascal Tokens: {cleaned_tokens}")  # Display the filtered tokens
        return cleaned_tokens

    # Tokenize C++ expressions using built-in functions
    def tokenize_cpp(self):
        tokens = []
        i = 0
        while i < len(self.expression):
            if self.expression[i:i + 2] == "/*":
                tokens.append("/*")
                i += 2
            elif self.expression[i:i + 2] == "*/":
                tokens.append("*/")
                i += 2
            else:
                tokens.append(self.expression[i])
                i += 1

        # Use built-in filtering to keep only relevant symbols for C++
        cleaned_tokens = [token for token in tokens if token in {"/*", "*/", "(", ")", "{", "}", "[", "]"}]
        print(f"Filtered C++ Tokens: {cleaned_tokens}")  # Display the filtered tokens
        return cleaned_tokens

    # Check if brackets are balanced
    def check_balance(self, tokens):
        stack = []
        matching_pairs = {"(": ")", "{": "}", "[": "]", "begin": "end", "/*": "*/"}

        for char in tokens:
            if char in matching_pairs.keys():
                stack.append(char)
            elif stack and matching_pairs.get(stack[-1]) == char:
                stack.pop()
            else:
                return "Unbalanced"

        return "Balanced" if not stack else "Unbalanced"


def main():
    print("ENTER 'P' TO CHECK SYMBOL BALANCE IN PASCAL LANGUAGE *****")
    print("ENTER 'C' TO CHECK SYMBOL BALANCE IN C++ LANGUAGE ")

    choice = input("Enter your choice (P for Pascal, C for C++): ").strip().upper()

    expression = input("Enter the expression to check for balancing symbols: ")
    checker = SymbolChecker(expression)

    match choice:
        case 'P':  # Pascal
            pascal_tokens = checker.tokenize_pascal()
            result = checker.check_balance(pascal_tokens)
            print(f"Expression: {expression}")
            print(f"Result: {result}")

        case 'C':  # C++
            cpp_tokens = checker.tokenize_cpp()
            result = checker.check_balance(cpp_tokens)
            print(f"Expression: {expression}")
            print(f"Result: {result}")

        case _:
            print("Invalid choice. Please enter 'P' for Pascal or 'C' for C++.")


if __name__ == "__main__":
    main()
