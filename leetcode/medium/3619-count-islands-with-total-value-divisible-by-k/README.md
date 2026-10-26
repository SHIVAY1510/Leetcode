# Count Islands With Total Value Divisible by K

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given an `m x n` matrix `grid` and a positive integer `k`. An  **island**  is a group of  **positive**  integers (representing land) that are  **4-directionally**  connected (horizontally or vertically).

The  **total value**  of an island is the sum of the values of all cells in the island.

Return the number of islands with a total value  **divisible by**  `k`.

 

 **Example 1:** 

 **Input:**  grid = [[0,2,1,0,0],[0,5,0,0,5],[0,0,1,0,0],[0,1,4,7,0],[0,2,0,0,8]], k = 5

 **Output:**  2

 **Explanation:** 

The grid contains four islands. The islands highlighted in blue have a total value that is divisible by 5, while the islands highlighted in red do not.

 **Example 2:** 

 **Input:**  grid = [[3,0,3,0], [0,3,0,3], [3,0,3,0]], k = 3

 **Output:**  6

 **Explanation:** 

The grid contains six islands, each with a total value that is divisible by 3.

 

 **Constraints:** 

- m == grid.length
- n == grid[i].length
- 1 <= m, n <= 1000
- 1 <= m * n <= 105
- 0 <= grid[i][j] <= 106
- 1 <= k <= 106

## Solution

**Language:** Java  
**Runtime:** 39 ms (beats 9.41%)  
**Memory:** 101.4 MB (beats 96.86%)  
**Submitted:** 2026-10-26T19:03:14.607Z  

```java
class Solution {
public int countIslands(int[][] grid, int k) {
int m = grid.length;
int n = grid[0].length;
    boolean[][] visited = new boolean[m][n];
    int count = 0;
    int[] dr = {1, -1, 0, 0};
    int[] dc = {0, 0, 1, -1};
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (grid[i][j] > 0 && !visited[i][j]) {
                long sum = 0;
                Stack<int[]> stack = new Stack<>();
                stack.push(new int[]{i, j});
                visited[i][j] = true;
                while (!stack.isEmpty()) {
                    int[] cell = stack.pop();
                    int r = cell[0];
                    int c = cell[1];
                    sum += grid[r][c];
                    for (int d = 0; d < 4; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];if (nr >= 0 && nc >= 0 &&nr < m && nc < n &&grid[nr][nc] > 0 &&!visited[nr][nc]) {
                            visited[nr][nc] = true;
                            stack.push(new int[]{nr, nc});
                        }
                    }
                }
                if (sum % k == 0) {
                    count++;
                }
            }
        }
    }
    return count;
}
}
```

---

[View on LeetCode](https://leetcode.com/problems/count-islands-with-total-value-divisible-by-k/)