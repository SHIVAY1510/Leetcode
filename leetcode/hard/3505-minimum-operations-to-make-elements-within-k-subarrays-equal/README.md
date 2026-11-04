# Minimum Operations to Make Elements Within K Subarrays Equal

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

You are given an integer array `nums` and two integers, `x` and `k`. You can perform the following operation any number of times (**including zero**):

- Increase or decrease any element of nums by 1.

Return the  **minimum**  number of operations needed to have  **at least**  `k`  *non-overlapping subarrays*  of size  **exactly**  `x` in `nums`, where all elements within each subarray are equal.

 

 **Example 1:** 

 **Input:**  nums = [5,-2,1,3,7,3,6,4,-1], x = 3, k = 2

 **Output:**  8

 **Explanation:** 

- Use 3 operations to add 3 to nums[1] and use 2 operations to subtract 2 from nums[3]. The resulting array is [5, 1, 1, 1, 7, 3, 6, 4, -1].
- Use 1 operation to add 1 to nums[5] and use 2 operations to subtract 2 from nums[6]. The resulting array is [5, 1, 1, 1, 7, 4, 4, 4, -1].
- Now, all elements within each subarray [1, 1, 1] (from indices 1 to 3) and [4, 4, 4] (from indices 5 to 7) are equal. Since 8 total operations were used, 8 is the output.

 **Example 2:** 

 **Input:**  nums = [9,-2,-2,-2,1,5], x = 2, k = 2

 **Output:**  3

 **Explanation:** 

- Use 3 operations to subtract 3 from nums[4]. The resulting array is [9, -2, -2, -2, -2, 5].
- Now, all elements within each subarray [-2, -2] (from indices 1 to 2) and [-2, -2] (from indices 3 to 4) are equal. Since 3 operations were used, 3 is the output.

 

 **Constraints:** 

- 2 <= nums.length <= 105
- -106 <= nums[i] <= 106
- 2 <= x <= nums.length
- 1 <= k <= 15
- 2 <= k * x <= nums.length

## Solution

**Language:** Java  
**Runtime:** 979 ms (beats 18.92%)  
**Memory:** 177.9 MB (beats 62.16%)  
**Submitted:** 2026-11-04T19:47:00.891Z  

```java
import java.util.*;
class Solution {
    TreeMap<Integer, Integer> left = new TreeMap<>();
    TreeMap<Integer, Integer> right = new TreeMap<>();
    long leftSum = 0, rightSum = 0;
    int leftSize = 0, rightSize = 0;
    void addLeft(int v) {
        left.put(v, left.getOrDefault(v, 0) + 1);
        leftSum += v;
        leftSize++;
    }
    void addRight(int v) {
        right.put(v, right.getOrDefault(v, 0) + 1);
        rightSum += v;
        rightSize++;
    }
    void removeLeft(int v) {
        int c = left.get(v);
        if (c == 1) left.remove(v);
        else left.put(v, c - 1);
        leftSum -= v;
        leftSize--;
    }
    void removeRight(int v) {
        int c = right.get(v);
        if (c == 1) right.remove(v);
        else right.put(v, c - 1);
        rightSum -= v;
        rightSize--;
    }
    void balance(int x) {
     int target = Math.min((x + 1) / 2, leftSize + rightSize);
     while (leftSize > target) {
         int v = left.lastKey();
         removeLeft(v);
         addRight(v);
        }
      while (leftSize < target) {
         int v = right.firstKey();
         removeRight(v);
         addLeft(v);
        }
        while (leftSize < target) {
         int v = right.firstKey();
         removeRight(v);
         addLeft(v);
        } 
    }
    void add(int v, int x) {
        if (left.isEmpty() || v <= left.lastKey())
            addLeft(v);
        else
            addRight(v);
        balance(x);
    }
    void remove(int v, int x) {
        if (left.containsKey(v))
            removeLeft(v);
        else
            removeRight(v);
        balance(x);
    }
    long getCost() {
        long median = left.lastKey();
        return median * leftSize - leftSum+ rightSum - median * rightSize;
    }
    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;
        long[] cost = new long[n - x + 1];
        for (int i = 0; i < x; i++)
            add(nums[i], x);
        cost[0] = getCost();
        for (int i = x; i < n; i++) {
            remove(nums[i - x], x);
            add(nums[i], x);
            cost[i - x + 1] = getCost();
        }
        long INF = Long.MAX_VALUE / 4;
        long[][] dp = new long[k + 1][n + 1];
        for (int i = 0; i <= k; i++)
            Arrays.fill(dp[i], INF);
        Arrays.fill(dp[0], 0);
        for (int j = 1; j <= k; j++) {
            for (int i = 1; i <= n; i++) {
                dp[j][i] = dp[j][i - 1];
                if (i >= x && dp[j - 1][i - x] != INF) {
                    dp[j][i] = Math.min(
                        dp[j][i],
                        dp[j - 1][i - x] + cost[i - x]
                    );
                }
            }
        }
       return dp[k][n];
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/minimum-operations-to-make-elements-within-k-subarrays-equal/)