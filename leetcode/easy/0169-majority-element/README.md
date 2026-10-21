# Majority Element

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given an array `nums` of size `n`, return  *the majority element*.

The majority element is the element that appears more than `⌊n / 2⌋` times. You may assume that the majority element always exists in the array.

 

 **Example 1:** 

```
Input: nums = [3,2,3]
Output: 3

```

 **Example 2:** 

```
Input: nums = [2,2,1,1,1,2,2]
Output: 2

```

 

 **Constraints:** 

- n == nums.length
- 1 <= n <= 5 * 104
- -109 <= nums[i] <= 109
- The input is generated such that a majority element will exist in the array.

 

 **Follow-up:**  Could you solve the problem in linear time and in `O(1)` space?

## Solution

**Language:** Java  
**Runtime:** 2 ms (beats 80.24%)  
**Memory:** 62.8 MB (beats 40.13%)  
**Submitted:** 2026-10-21T05:50:17.563Z  

```java
class Solution {
    public int majorityElement(int[] nums) {
        // int n=nums.length;
        // for(int i=0;i<n;i++){
        //     int c=0;
        //     for(int j=0;j<n;j++){
        //         if(nums[i]==nums[j]){
        //             c++;
        //         }
        //     }
        //         if(c> n/2){
        //             return nums[i];
        //         }
        // }
        // return -1;
        int n=nums.length;
        int c=0;
        int candidate=0;
        for(int num:nums){
            if(c==0){
            candidate=num;
        }
            if(candidate==num){
                c++;
            }
            else{
                c--;
            }
        }
        return candidate;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/majority-element/)