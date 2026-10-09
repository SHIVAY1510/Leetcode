# Remove Invalid Parentheses

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Given a string `s` that contains parentheses and letters, remove the minimum number of invalid parentheses to make the input string valid.

Return  *a list of  **unique strings**  that are valid with the minimum number of removals*. You may return the answer in  **any order**.

 

 **Example 1:** 

```
Input: s = "()())()"
Output: ["(())()","()()()"]

```

 **Example 2:** 

```
Input: s = "(a)())()"
Output: ["(a())()","(a)()()"]

```

 **Example 3:** 

```
Input: s = ")("
Output: [""]

```

 

 **Constraints:** 

- 1 <= s.length <= 25
- s consists of lowercase English letters and parentheses '(' and ')'.
- There will be at most 20 parentheses in s.

## Solution

**Language:** Java  
**Runtime:** 2 ms (beats 79.35%)  
**Memory:** 43.5 MB (beats 97.61%)  
**Submitted:** 2026-10-09T19:55:57.455Z  

```java
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String>ans=new ArrayList<>();
        remove(s,ans,0,0,'(',')');
        return ans;
    }
    private void remove(String s,List<String>ans,int l_i,int l_j,char open,char close){
        int count=0;
        for(int i=l_i;i<s.length();i++){
            if(s.charAt(i)==open) count++;
            if(s.charAt(i)==close) count--;
            if(count >=0)continue;

            for(int j=l_j;j<=i;j++){
                if(s.charAt(j)==close &&(j==l_j||s.charAt(j-1)!=close)){
                    remove(s.substring(0,j)+s.substring(j+1),ans,i,j,open,close);
                }
            }
            return ;
        }
        String reversed=new StringBuilder(s).reverse().toString();
        if(open=='('){
            remove(reversed,ans,0,0,')','(');
        }
        else{
            ans.add(reversed);
        }
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/remove-invalid-parentheses/)