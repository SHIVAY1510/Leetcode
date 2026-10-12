# Java Varargs - Simple Addition

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given a class *Solution* and its *main* method in the editor. <br>Your task is to create the class *Add* and the required methods so that the code prints the *sum of the numbers* passed to the function *add*.  

**Note:** Your *add* method in the *Add* class must print the *sum* as given in the *Sample Output*


**Input Format**

There are six lines of input, each containing an integer.

**Output Format**

There will be only four lines of output. Each line contains the sum of the *integers* passed as the parameters to *add* in the *main* method.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-12T19:58:28.993Z  

```java
import java.io.*;
import java.util.*;

class Add{
    void add(int a, int b){
        int sum=a+b;
        System.out.println(a+"+"+b+"="+sum);
    }
    void add(int a,int b,int c){
        int sum=a+b+c;
        System.out.println(a+"+"+b+"+"+c+"="+sum);
    }
    void add(int a,int b,int c,int d,int e){
        int sum=a+b+c+d+e;
        System.out.println(a+"+"+b+"+"+c+"+"+d+"+"+e+"="+sum);
    }
    void add(int a,int b,int c,int d,int e,int f){
        int sum=a+b+c+d+e+f;
        System.out.println(a+"+"+b+"+"+c+"+"+d+"+"+e+"+"+f+"="+sum);
    }
}
public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc= new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();
        int d=sc.nextInt();
        int e=sc.nextInt();
        int f=sc.nextInt();
        Add ob=new Add();
        ob.add(a,b);
        ob.add(a, b,c);
        ob.add(a, b,c,d,e);
        ob.add(a, b,c,d,e,f);
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/simple-addition-varargs/problem)