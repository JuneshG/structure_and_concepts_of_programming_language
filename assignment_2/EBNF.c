#include<stdio.h>

int main(){
    switch (x) {
        case 1:
            doSomething();
            break;
        default:
            doDefault();
    }
}


union Data {
    int i;
    float f;
    char c;
};