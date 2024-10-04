package main

import (
    "fmt"
)

func main() {
    n := 1
    c := 'a'
    f := 3.8
    str1 := "Hello"
    str2 := "World"

    fmt.Printf("int: %d + float: %f = %f\n", n, f, float64(n)+f)
    fmt.Printf("char: %c + int: %d = %d\n", c, n, int(c)+n)
    fmt.Printf("string: %s + string: %s = %s\n", str1, str2, str1+str2)
}