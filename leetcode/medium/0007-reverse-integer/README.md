# Reverse Integer

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a signed 32-bit integer `x`, return `x` *with its digits reversed*. If reversing `x` causes the value to go outside the signed 32-bit integer range `[-231, 231 - 1]`, then return `0`.

 **Assume the environment does not allow you to store 64-bit integers (signed or unsigned).** 

 

 **Example 1:** 

```
Input: x = 123
Output: 321

```

 **Example 2:** 

```
Input: x = -123
Output: -321

```

 **Example 3:** 

```
Input: x = 120
Output: 21

```

 

 **Constraints:** 

- -231 <= x <= 231 - 1

## Solution

**Language:** Java  
**Runtime:** 1 ms (beats 99.96%)  
**Memory:** 42.5 MB (beats 79.55%)  
**Submitted:** 2026-10-07T04:27:24.405Z  

```java
class Solution {
    public int reverse(int x) {
       int reverse=0;
       while(x!=0){
        int d=x%10;
        if(reverse > Integer.MAX_VALUE / 10 || (reverse == Integer.MAX_VALUE / 10 && d > 7)) {
            return 0;
        }
        if (reverse < Integer.MIN_VALUE / 10 || (reverse == Integer.MIN_VALUE / 10 && d < -8)) {
            return 0;
        }
        reverse=reverse*10+d;
        x/=10;
       }
       return reverse;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int x= sc.nextInt();
        Solution sol = new Solution();      
        int result = sol.reverse(x); 
        System.out.println(result);
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/reverse-integer/)