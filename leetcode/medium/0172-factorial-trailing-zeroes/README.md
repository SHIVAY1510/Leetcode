# Factorial Trailing Zeroes

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an integer `n`, return  *the number of trailing zeroes in* `n!`.

Note that `n! = n  *(n - 1)*  (n - 2)  *...*  3  *2*  1`.

 

 **Example 1:** 

```
Input: n = 3
Output: 0
Explanation: 3! = 6, no trailing zero.

```

 **Example 2:** 

```
Input: n = 5
Output: 1
Explanation: 5! = 120, one trailing zero.

```

 **Example 3:** 

```
Input: n = 0
Output: 0

```

 

 **Constraints:** 

- 0 <= n <= 104

 

 **Follow up:**  Could you write a solution that works in logarithmic time complexity?

## Solution

**Language:** Java  
**Runtime:** 0 ms (beats 100.00%)  
**Memory:** 42.1 MB (beats 85.23%)  
**Submitted:** 2026-10-07T04:49:46.489Z  

```java
class Solution {
    public int trailingZeroes(int n) {
        int c=0;
        while(n!=0){
            n=n/5;
            c+=n;
        }
        return c;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/factorial-trailing-zeroes/)