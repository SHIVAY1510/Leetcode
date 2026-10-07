# Trapping Rain Water

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Given `n` non-negative integers representing an elevation map where the width of each bar is `1`, compute how much water it can trap after raining.

 

 **Example 1:** 

```
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

```

 **Example 2:** 

```
Input: height = [4,2,0,3,2,5]
Output: 9

```

 

 **Constraints:** 

- n == height.length
- 1 <= n <= 2 * 104
- 0 <= height[i] <= 105

## Solution

**Language:** Java  
**Runtime:** 0 ms (beats 100.00%)  
**Memory:** 47.7 MB (beats 64.23%)  
**Submitted:** 2026-10-07T04:43:38.002Z  

```java
class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int l=0;
        int r=n-1;
        int lMax=0;
        int rMax=0;
        int w=0;
        while(l<r){
            if(height[l]<=height[r]){
                if(height[l]>=lMax){
                    lMax=height[l];
                }
                else{
                    w+=lMax-height[l];
                }
                l++;
            }
            else{
                if(height[r]>=rMax){
                    rMax=height[r];
                }
                else{
                    w+=rMax-height[r];
                }
                r--;
            }
        }
        return w;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/trapping-rain-water/)