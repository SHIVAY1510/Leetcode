# Minimum Moves to Equal Array Elements II

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an integer array `nums` of size `n`, return  *the minimum number of moves required to make all array elements equal*.

In one move, you can increment or decrement an element of the array by `1`.

Test cases are designed so that the answer will fit in a  **32-bit**  integer.

 

 **Example 1:** 

```
Input: nums = [1,2,3]
Output: 2
Explanation:
Only two moves are needed (remember each move increments or decrements one element):
[1,2,3]  =>  [2,2,3]  =>  [2,2,2]

```

 **Example 2:** 

```
Input: nums = [1,10,2,9]
Output: 16

```

 

 **Constraints:** 

- n == nums.length
- 1 <= nums.length <= 105
- -109 <= nums[i] <= 109

## Solution

**Language:** Java  
**Runtime:** 10 ms (beats 85.23%)  
**Memory:** 46.8 MB (beats 68.55%)  
**Submitted:** 2026-11-03T18:37:09.801Z  

```java
class Solution {
    public int minMoves2(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int m=nums[n/2];
        int c=0;
        for(int i=0;i<n;i++){
            c+=Math.abs(nums[i]-m);
        }
        return c;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/)