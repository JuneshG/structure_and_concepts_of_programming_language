class Stack:
    def __init__(self):
        self.stack = []
    
    def push(self, item):
        self.stack.append(item)
    
    def pop(self):
        if not self.is_empty():
            return self.stack.pop()
        return None
    
    def is_empty(self):
        return len(self.stack) == 0

def is_balanced(expression):
    stack = Stack()
    # Dictionary of matching pairs
    matching_pairs = {
        ')': '(',
        ']': '[',
        '}': '{',
        'end': 'begin',
        '*/': '/*'
    }
    
    i = 0
    while i < len(expression):
        if expression[i:i+2] == '/*':
            stack.push('/*')
            i += 2
        elif expression[i:i+3] == 'end':
            if stack.pop() != 'begin':
                return "Unbalanced"
            i += 3
        elif expression[i:i+5] == 'begin':
            stack.push('begin')
            i += 5
        elif expression[i:i+2] == '*/':
            if stack.pop() != '/*':
                return "Unbalanced"
            i += 2
        elif expression[i] in '({[':
            stack.push(expression[i])
            i += 1
        elif expression[i] in ')}]':
            if stack.pop() != matching_pairs[expression[i]]:
                return "Unbalanced"
            i += 1
        else:
            i += 1  # Ignore any non-symbol characters
    
    return "Balanced" if stack.is_empty() else "Unbalanced"

# Test cases
print(is_balanced("([]{})"))      # Balanced
print(is_balanced("([)]"))        # Unbalanced
print(is_balanced("/* begin */")) # Balanced
print(is_balanced("/* begin ]"))  # Unbalanced
