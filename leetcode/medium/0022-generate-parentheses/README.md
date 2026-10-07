# Generate Parentheses

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given `n` pairs of parentheses, write a function to  *generate all combinations of well-formed parentheses*.

 

 **Example 1:** 

```
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

```

 **Example 2:** 

```
Input: n = 1
Output: ["()"]

```

 

 **Constraints:** 

- 1 <= n <= 8

## Solution

**Language:** Java  
**Runtime:** 0 ms (beats 100.00%)  
**Memory:** 44.3 MB (beats 85.89%)  
**Submitted:** 2026-10-07T04:31:12.463Z  

```java
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans= new ArrayList<>();
        char[] arr=new char[2*n];
        backtrack(ans,arr,0,0,0,n);
        return ans;
    }
    void backtrack(List<String>ans,char[] arr,int index, int open,int close,int n){
        if(index==2*n){
            ans.add(new String(arr));
            return;
        }
        if(open<n){
            arr[index]='(';
            backtrack(ans,arr,index+1,open+1,close,n);
        }
        if(close<open){
            arr[index]=')';
            backtrack(ans,arr,index+1,open,close+1,n);
        }
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/generate-parentheses/)