# Find First and Last Position of Element in Sorted Array

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array of integers `nums` sorted in non-decreasing order, find the starting and ending position of a given `target` value.

If `target` is not found in the array, return `[-1, -1]`.

You must write an algorithm with `O(log n)` runtime complexity.

 

 **Example 1:** 

```
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

```

 **Example 2:** 

```
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

```

 **Example 3:** 

```
Input: nums = [], target = 0
Output: [-1,-1]

```

 

 **Constraints:** 

- 0 <= nums.length <= 105
- -109 <= nums[i] <= 109
- nums is a non-decreasing array.
- -109 <= target <= 109

## Solution

**Language:** C++  
**Runtime:** 0 ms (beats 100.00%)  
**Memory:** 17.6 MB (beats 16.85%)  
**Submitted:** 2026-10-07T04:38:26.526Z  

```cpp
class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
            int start = 0,end = nums.size()-1;
        int mid,str = -1,last = -1;
        
        while(start <= end){
            mid = start + (end-start)/2;          
            
            if(nums[mid] == target){
                str = mid;                      
                end = mid-1;                    
            }
            
            else if(nums[mid] < target){
                start = mid+1;
            }
            else end = mid-1;
        }
		

        start = 0,end = nums.size()-1;
        last = -1;
        
        while(start <= end){
            mid = start + (end-start)/2;
            
            if(nums[mid] == target){
                last = mid;                    
                start = mid+1;                 
            }
            
            else if(nums[mid] < target){
                start = mid+1;
            }
            else end = mid-1;
        }
        
        return {str,last}; 
    }
};
```

---

[View on LeetCode](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)