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