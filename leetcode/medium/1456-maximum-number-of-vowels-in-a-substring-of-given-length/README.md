# Maximum Number of Vowels in a Substring of Given Length

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a string `s` and an integer `k`, return  *the maximum number of vowel letters in any substring of* `s` *with length* `k`.

 **Vowel letters**  in English are `'a'`, `'e'`, `'i'`, `'o'`, and `'u'`.

 

 **Example 1:** 

```
Input: s = "abciiidef", k = 3
Output: 3
Explanation: The substring "iii" contains 3 vowel letters.

```

 **Example 2:** 

```
Input: s = "aeiou", k = 2
Output: 2
Explanation: Any substring of length 2 contains 2 vowels.

```

 **Example 3:** 

```
Input: s = "leetcode", k = 3
Output: 2
Explanation: "lee", "eet" and "ode" contain 2 vowels.

```

 

 **Constraints:** 

- 1 <= s.length <= 105
- s consists of lowercase English letters.
- 1 <= k <= s.length

## Solution

**Language:** Java  
**Runtime:** 11 ms (beats 92.33%)  
**Memory:** 45.9 MB (beats 93.27%)  
**Submitted:** 2026-10-30T14:12:39.988Z  

```java
class Solution {
    public int maxVowels(String s, int k) {
        // int n=s.length();
        // int maxCount=0;
        // for(int i=0;i<=n-k;i++){
        //     int Count=0;
        //     for(int j=i;j<i+k;j++){
        //         char ch=s.charAt(j);
        //         if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
        //             Count++;
        //         }
        //     }
        //     maxCount=Math.max(maxCount,Count);
        // }
        // return maxCount;
        int n=s.length();
        int maxcount=0;
        int start=0;
        int count=0;
        for(int e=0;e<n;e++){
            char ch=s.charAt(e);
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
                count++;
            }
            if(e>=k-1){
                maxcount=Math.max(maxcount,count);
                char f=s.charAt(start);
                if(f=='a'||f=='e'||f=='i'||f=='o'||f=='u'){
                    count--;
                }
                 start++;
            }
        }
        return maxcount;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/)