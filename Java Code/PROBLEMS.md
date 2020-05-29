# Problem statements:

## Problem statement 1: Infix to Postfix conversion

Create a Java program to accept an infix expression and convert it to postfix. Assume that the operands are single digit numerals and the expression input is without braces.
Feel free to use as many classes and constructors as you like.

**Solution Files:** InfixApp.java and InfixAppToPost.java

Main method: 'void main()' from InfixApp.java

Concepts used:
1. loops
2. Classes and objects
3. Data structures: stack
4. Inheritance
5. Constructors

## Problem Statement 2: 

You are given an array of integers of length n and an integer m. Calculate the number of m-countdowns in the array.

**m-countdowns:** a set of numbers is said to be am m-countdown when it contains the numbers {m, m-1, m-2, ... 3, 2, 1} in this specific order (decreasing order).

#### Sample I/O:

**INPUT:** 
12 3

1 2 3 7 9 3 2 1 8 3 2 1

**OUTPUT:** 2

**EXPLANATION:** n = 12, m = 3

1, 2, 3, 7, 9, *3, 2, 1*, 8, *3, 2, 1*

There are 2 sub-arrays where the numbers {3, 2, 1} are present in that order.

**Solution files:** mCountdowns.java
