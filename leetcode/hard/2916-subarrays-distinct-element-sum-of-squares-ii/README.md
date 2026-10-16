# Subarrays Distinct Element Sum of Squares II

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

You are given a  **0-indexed** integer array `nums`.

The  **distinct count**  of a subarray of `nums` is defined as:

- Let nums[i..j] be a subarray of nums consisting of all the indices from i to j such that 0 <= i <= j < nums.length. Then the number of distinct values in nums[i..j] is called the distinct count of nums[i..j].

Return  *the sum of the  **squares**  of  **distinct counts**  of all subarrays of* `nums`.

Since the answer may be very large, return it  **modulo**  `109 + 7`.

A subarray is a contiguous  **non-empty**  sequence of elements within an array.

 

 **Example 1:** 

```
Input: nums = [1,2,1]
Output: 15
Explanation: Six possible subarrays are:
[1]: 1 distinct value
[2]: 1 distinct value
[1]: 1 distinct value
[1,2]: 2 distinct values
[2,1]: 2 distinct values
[1,2,1]: 2 distinct values
The sum of the squares of the distinct counts in all subarrays is equal to 12 + 12 + 12 + 22 + 22 + 22 = 15.

```

 **Example 2:** 

```
Input: nums = [2,2]
Output: 3
Explanation: Three possible subarrays are:
[2]: 1 distinct value
[2]: 1 distinct value
[2,2]: 1 distinct value
The sum of the squares of the distinct counts in all subarrays is equal to 12 + 12 + 12 = 3.
```

 

 **Constraints:** 

- 1 <= nums.length <= 105
- 1 <= nums[i] <= 105

## Solution

**Language:** Java  
**Runtime:** 271 ms (beats 28.57%)  
**Memory:** 126 MB (beats 32.14%)  
**Submitted:** 2026-10-16T18:08:47.800Z  

```java
class Solution {
    static final int MOD = 1_000_000_007;

    class SegmentTree {
        long[] sum, sq, lazy;
        int n;

        SegmentTree(int n) {
            this.n = n;
            sum = new long[4 * n];
            sq = new long[4 * n];
            lazy = new long[4 * n];
        }

        void apply(int node, int start, int end, long val) {
            long len = end - start + 1L;

            sq[node] = (sq[node]
                    + 2L * val * sum[node]
                    + len * val % MOD * val) % MOD;

            sum[node] = (sum[node] + len * val) % MOD;
            lazy[node] = (lazy[node] + val) % MOD;
        }

        void push(int node, int start, int end) {
            if (lazy[node] == 0 || start == end) {
                return;
            }

            int mid = (start + end) / 2;
            long val = lazy[node];

            apply(node * 2, start, mid, val);
            apply(node * 2 + 1, mid + 1, end, val);

            lazy[node] = 0;
        }

        void update(int node, int start, int end,
                    int l, int r, long val) {
            if (start > r || end < l) {
                return;
            }

            if (l <= start && end <= r) {
                apply(node, start, end, val);
                return;
            }

            push(node, start, end);

            int mid = (start + end) / 2;

            update(node * 2, start, mid, l, r, val);
            update(node * 2 + 1, mid + 1, end, l, r, val);

            sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;
            sq[node] = (sq[node * 2] + sq[node * 2 + 1]) % MOD;
        }

        long query(int node, int start, int end, int l, int r) {
            if (start > r || end < l) {
                return 0;
            }

            if (l <= start && end <= r) {
                return sq[node];
            }

            push(node, start, end);

            int mid = (start + end) / 2;

            return (query(node * 2, start, mid, l, r)
                  + query(node * 2 + 1, mid + 1, end, l, r)) % MOD;
        }
    }

    public int sumCounts(int[] nums) {
        int n = nums.length;

        SegmentTree st = new SegmentTree(n);
        java.util.HashMap<Integer, Integer> last = new java.util.HashMap<>();

        long ans = 0;

        for (int i = 0; i < n; i++) {
            int prev = last.getOrDefault(nums[i], -1);

            st.update(1, 0, n - 1, prev + 1, i, 1);

            ans = (ans + st.query(1, 0, n - 1, 0, i)) % MOD;

            last.put(nums[i], i);
        }

        return (int) ans;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/subarrays-distinct-element-sum-of-squares-ii/)