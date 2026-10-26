# Longest Common Prefix

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string `""`.

 

 **Example 1:** 

```
Input: strs = ["flower","flow","flight"]
Output: "fl"

```

 **Example 2:** 

```
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

```

 

 **Constraints:** 

- 1 <= strs.length <= 200
- 0 <= strs[i].length <= 200
- strs[i] consists of only lowercase English letters if it is non-empty.

## Solution

**Language:** Java  
**Runtime:** 0 ms  
**Memory:** 42.1 MB  
**Submitted:** 2026-10-26T20:24:47.229Z  

```java
class Solution {
    public String longestCommonPrefix(String[] strs) {
        // StringBuilder a=new StringBuilder();
        // for(int i=0;i<strs[0].length();i++){
        //     char ch=strs[0].charAt(i);
        //     for(int j=1;j<strs.length;j++){
        //         if(i>=strs[j].length()||strs[j].charAt(i)!=ch){
        //             return a.toString();
        //         }
        //     }
        //     a.append(ch);
        // }
        // return a.toString();
       String prefix = strs[0];
    for (String s : strs) {
        while (!s.startsWith(prefix)) {
            prefix = prefix.substring(0, prefix.length() - 1);
            if (prefix.isEmpty()) return "";
        }
    }
    return prefix;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/longest-common-prefix/)