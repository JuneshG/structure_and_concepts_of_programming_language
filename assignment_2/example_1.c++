#include<iostream>
using namespace std;

// void add(int a, int b)
// {
//     cout << a + b << endl;
// }

// int main()
// {
//     add(5, 10); //Correct, both parameters are integers
//     add("5", 10); // Compilation error, "5" is a string, not an integer
// }


// int x = 10;
// int &y = x;  // y is a reference (alias) to x

int main() {
    int a = 5;
    int *p1 = &a;
    int *p2 = p1;

    *p2 = 10;  // This modifies the value of a because p2 is an alias to p1
    printf("%d", a);  // Outputs 10
}