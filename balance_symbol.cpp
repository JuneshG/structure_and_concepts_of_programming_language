#include <iostream>
#include <stack>
#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

// Class to handle symbol balancing for Pascal and C++
class BracketChecker {
private:
    string expression;
    const unordered_map<string, string> matchingPairs = {
        {"(", ")"}, {"{", "}"}, {"[", "]"}, {"begin", "end"}, {"/*", "*/"}
    };

public:
    BracketChecker(const string &expr) : expression(expr) {}

    // Unified method to tokenize expressions
    vector<string> tokenize(bool isPascal) {
        vector<string> tokens;
        size_t index = 0;

        while (index < expression.size()) {
            if (isPascal && expression.substr(index, 5) == "begin") { tokens.push_back("begin"); index += 5; }
            else if (isPascal && expression.substr(index, 3) == "end") { tokens.push_back("end"); index += 3; }
            else if (expression.substr(index, 2) == "/*") { tokens.push_back("/*"); index += 2; }
            else if (expression.substr(index, 2) == "*/") { tokens.push_back("*/"); index += 2; }
            else if (string("({[)}]").find(expression[index]) != string::npos) { tokens.push_back(string(1, expression[index])); index++; }
            else index++;
        }
        return tokens;
    }

    // Check if symbols are balanced
    string checkBalanced(const vector<string> &tokens) {
        stack<string> symStack;
        for (const auto &sym : tokens) {
            if (matchingPairs.count(sym)) symStack.push(sym); // Opening symbol
            else if (symStack.empty() || matchingPairs.at(symStack.top()) != sym) return "Unbalanced";
            else symStack.pop(); // Matching closing symbol
        }
        return symStack.empty() ? "Balanced" : "Unbalanced";
    }
};

int main() {
    char choice;
    string expression;

    cout << "Enter 'P' for Pascal or 'C' for C++: ";
    cin >> choice;
    cin.ignore(); // Clear input buffer
    cout << "Enter the expression to check: ";
    getline(cin, expression);

    BracketChecker checker(expression);
    vector<string> tokens = checker.tokenize(toupper(choice) == 'P');
    cout << "Result: " << checker.checkBalanced(tokens) << endl;

    return 0;
}
