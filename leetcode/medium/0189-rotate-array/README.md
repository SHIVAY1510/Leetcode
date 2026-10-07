# Rotate Array

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an integer array `nums`, rotate the array to the right by `k` steps, where `k` is non-negative.

 

 **Example 1:** 

```
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]

```

 **Example 2:** 

```
Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]

```

 

 **Constraints:** 

- 1 <= nums.length <= 105
- -231 <= nums[i] <= 231 - 1
- 0 <= k <= 105

 

 **Follow up:** 

- Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
- Could you do it in-place with O(1) extra space?

## Solution

**Language:** Java  
**Runtime:** 5 ms (beats 42.91%)  
**Memory:** 273.5 MB (beats 5.97%)  
**Submitted:** 2026-10-07T04:50:24.312Z  

```java
class Solution {
    public void rotate(int[] nums, int k) {
       int n=nums.length;
       k=k%n;
       int i=n-k;
       int j=0;
       int[] temp = new int[n];
       for(i=n-k;i<n;i++){
        temp[j++]=nums[i];
       }
       for(i=0;i<n-k;i++){
        temp[j++]=nums[i];
       }
       for(i=0;i<n;i++){
        nums[i]=temp[i];
       }
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/rotate-array/)