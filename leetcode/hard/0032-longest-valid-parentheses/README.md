# Longest Valid Parentheses

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Given a string containing just the characters `'('` and `')'`, return  *the length of the longest valid (well-formed) parentheses **substring*.

 

 **Example 1:** 

```
Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".

```

 **Example 2:** 

```
Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".

```

 **Example 3:** 

```
Input: s = ""
Output: 0

```

 

 **Constraints:** 

- 0 <= s.length <= 3 * 104
- s[i] is '(', or ')'.

## Solution

**Language:** Java  
**Runtime:** 5 ms (beats 72.99%)  
**Memory:** 46.4 MB (beats 53.99%)  
**Submitted:** 2026-10-07T04:33:23.220Z  

```java
class Solution {
    public int longestValidParentheses(String s) {
        int m=0;
        Stack<Integer> stack=new Stack<>();
        stack.push(-1);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            }else{
                stack.pop();
            if(stack.isEmpty()){
                stack.push(i);
            }
            else{
                m=Math.max(m,i-stack.peek());
            }
            }
        }
         return m;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/longest-valid-parentheses/)