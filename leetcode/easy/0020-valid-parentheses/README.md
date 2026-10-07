# Valid Parentheses

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given a string `s` containing just the characters `'('`, `')'`, `'{'`, `'}'`, `'['` and `']'`, determine if the input string is valid.

An input string is valid if:

- Open brackets must be closed by the same type of brackets.
- Open brackets must be closed in the correct order.
- Every close bracket has a corresponding open bracket of the same type.

 

 **Example 1:** 

 **Input:**  s = "()"

 **Output:**  true

 **Example 2:** 

 **Input:**  s = "()[]{}"

 **Output:**  true

 **Example 3:** 

 **Input:**  s = "(]"

 **Output:**  false

 **Example 4:** 

 **Input:**  s = "([])"

 **Output:**  true

 **Example 5:** 

 **Input:**  s = "([)]"

 **Output:**  false

 

 **Constraints:** 

- 1 <= s.length <= 104
- s consists of parentheses only '()[]{}'.

## Solution

**Language:** Java  
**Runtime:** 1 ms (beats 99.92%)  
**Memory:** 43.1 MB (beats 84.65%)  
**Submitted:** 2026-10-07T04:30:37.452Z  

```java
class Solution {
    public boolean isValid(String s) {
        char[] stack=new char[s.length()];
        int top=-1;
        for(char c:s.toCharArray()){
            if(c=='('){
                stack[++top]=')';
            }
            else if(c=='{'){
                stack[++top]='}';
            }
            else if(c=='['){
                stack[++top]=']';
            }
            else{
                if(top==-1|| stack[top]!=c){
                    return false;
                }
                top--;
            }
        }
        return top ==-1;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/valid-parentheses/)