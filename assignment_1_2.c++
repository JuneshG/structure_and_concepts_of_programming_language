#include <iostream>
#include <stack>
#include <string>

using namespace std;

bool isBalanced(const string &expression) {
    stack<string> s;
    
    for (size_t i = 0; i < expression.length(); i++) {
        // Handle multi-character symbols
        if (i + 1 < expression.length() && expression.substr(i, 2) == "/*") {
            s.push("/*");
            i++;
        } else if (i + 2 < expression.length() && expression.substr(i, 3) == "end") {
            if (s.empty() || s.top() != "begin") {
                return false;
            }
            s.pop();
            i += 2;
        } else if (i + 4 < expression.length() && expression.substr(i, 5) == "begin") {
            s.push("begin");
            i += 4;
        } else if (i + 1 < expression.length() && expression.substr(i, 2) == "*/") {
            if (s.empty() || s.top() != "/*") {
                return false;
            }
            s.pop();
            i++;
        } else if (expression[i] == '(' || expression[i] == '{' || expression[i] == '[') {
            s.push(string(1, expression[i]));
        } else if (expression[i] == ')' || expression[i] == '}' || expression[i] == ']') {
            if (s.empty()) return false;
            char top = s.top()[0];
            if ((expression[i] == ')' && top != '(') || 
                (expression[i] == '}' && top != '{') || 
                (expression[i] == ']' && top != '[')) {
                return false;
            }
            s.pop();
        }
    }
    
    return s.empty();
}

int main() {
    cout << (isBalanced("([]{})") ? "Balanced" : "Unbalanced") << endl;
    cout << (isBalanced("([)]") ? "Balanced" : "Unbalanced") << endl;
    cout << (isBalanced("/* begin */") ? "Balanced" : "Unbalanced") << endl;
    cout << (isBalanced("/* begin ]") ? "Balanced" : "Unbalanced") << endl;
}
