# Palindromic Path Queries in a Tree

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

You are given an undirected tree with `n` nodes labeled 0 to `n - 1`. This is represented by a 2D array `edges` of length `n - 1`, where `edges[i] = [ui, vi]` indicates an undirected edge between nodes `ui` and `vi`.

You are also given a string `s` of length `n` consisting of lowercase English letters, where `s[i]` represents the character assigned to node `i`.

You are also given a string array `queries`, where each `queries[i]` is either:

- "update ui c": Change the character at node ui to c. Formally, update s[ui] = c.
- "query ui vi": Determine whether the string formed by the characters on the unique path from ui to vi (inclusive) can be rearranged into a palindrome.

Return a boolean array `answer`, where `answer[j]` is `true` if the `jth` query of type `"query ui vi"​​​​​​​` can be rearranged into a  **palindrome**, and `false` otherwise.

 

 **Example 1:** 

 **Input:**  n = 3, edges = [[0,1],[1,2]], s = "aac", queries = ["query 0 2","update 1 b","query 0 2"]

 **Output:**  [true,false]

 **Explanation:** 

- "query 0 2": Path 0 → 1 → 2 gives "aac", which can be rearranged to form "aca", a palindrome. Thus, answer[0] = true.
- "update 1 b": Update node 1 to 'b', now s = "abc".
- "query 0 2": Path characters are "abc", which cannot be rearranged to form a palindrome. Thus, answer[1] = false.

Thus, `answer = [true, false]`.

 **Example 2:** 

 **Input:**  n = 4, edges = [[0,1],[0,2],[0,3]], s = "abca", queries = ["query 1 2","update 0 b","query 2 3","update 3 a","query 1 3"]

 **Output:**  [false,false,true]

 **Explanation:** 

- "query 1 2": Path 1 → 0 → 2 gives "bac", which cannot be rearranged to form a palindrome. Thus, answer[0] = false.
- "update 0 b": Update node 0 to 'b', now s = "bbca".
- "query 2 3": Path 2 → 0 → 3 gives "cba", which cannot be rearranged to form a palindrome. Thus, answer[1] = false.
- "update 3 a": Update node 3 to 'a', s = "bbca".
- "query 1 3": Path 1 → 0 → 3 gives "bba", which can be rearranged to form "bab", a palindrome. Thus, answer[2] = true.

Thus, `answer = [false, false, true]`.

 

 **Constraints:** 

- 1 <= n == s.length <= 5 * 104
- edges.length == n - 1
- edges[i] = [ui, vi]
- 0 <= ui, vi <= n - 1
- s consists of lowercase English letters.
- The input is generated such that edges represents a valid tree.
- 1 <= queries.length <= 5 * 104​​​​​​​queries[i] = "update ui c" or queries[i] = "query ui vi" 0 <= ui, vi <= n - 1 c is a lowercase English letter.

## Solution

**Language:** Java  
**Runtime:** 133 ms (beats 91.30%)  
**Memory:** 220.2 MB (beats 56.52%)  
**Submitted:** 2026-10-29T19:36:37.987Z  

```java
class Solution {
    private List<Integer>[] graph;
    private int[] tin, tout, depth, parent;
    private int[][] up;
    private int[] bit, mask;
    private int timer, LOG, n;
    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
    //   List<Integer>[] graph = new ArrayList[n];
    //     for (int i = 0; i < n; i++) {
    //         graph[i] = new ArrayList<>();
    //     }
    //     for (int[] edge : edges) {
    //         graph[edge[0]].add(edge[1]);
    //         graph[edge[1]].add(edge[0]);
    //     }
    //     char[] chars = s.toCharArray();
    //     List<Boolean> result = new ArrayList<>();
    //     for (String query : queries) {
    //         String[] parts = query.split(" ");
    //         if (parts[0].equals("update")) {
    //             int u = Integer.parseInt(parts[1]);
    //             char c = parts[2].charAt(0);
    //             chars[u] = c;
    //         } else {
    //             int u = Integer.parseInt(parts[1]);
    //             int v = Integer.parseInt(parts[2]);
    //             int[] parent = new int[n];
    //             Arrays.fill(parent, -1);
    //             Queue<Integer> queue = new LinkedList<>();
    //             queue.offer(u);
    //             parent[u] = u;
    //             while (!queue.isEmpty()) {
    //                 int node = queue.poll();
    //                 if (node == v) {
    //                     break;
    //                 }
    //                 for (int next : graph[node]) {
    //                     if (parent[next] == -1) {
    //                         parent[next] = node;
    //                         queue.offer(next);
    //                     }
    //                 }
    //             }
    //             int[] freq = new int[26];
    //             int node = v;
    //             while (node != u) {
    //                 freq[chars[node] - 'a']++;
    //                 node = parent[node];
    //             }
    //             freq[chars[u] - 'a']++;
    //             int odd = 0;
    //             for (int count : freq) {
    //                 if (count % 2 != 0) {
    //                     odd++;
    //                 }
    //             }
    //             result.add(odd <= 1);
    //         }
    //     }
    //     boolean[] answer = new boolean[result.size()];
    //     for (int i = 0; i < result.size(); i++) {
    //         answer[i] = result.get(i);
    //     }
    //     return result;

        this.n = n;

        graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        LOG = 1;

        while ((1L << LOG) <= n) {
            LOG++;
        }

        tin = new int[n];
        tout = new int[n];
        depth = new int[n];
        parent = new int[n];

        up = new int[LOG][n];
        bit = new int[n + 2];
        mask = new int[n];

        char[] chars = s.toCharArray();

        for (int i = 0; i < n; i++) {
            mask[i] = 1 << (chars[i] - 'a');
        }

        buildTree();

        for (int i = 0; i < n; i++) {
            updateRange(tin[i], tout[i], mask[i]);
        }

        List<Boolean> result = new ArrayList<>();

        for (String query : queries) {
            String[] p = query.split(" ");

            if (p[0].equals("update")) {
                int u = Integer.parseInt(p[1]);
                char c = p[2].charAt(0);

                int newMask = 1 << (c - 'a');
                int diff = mask[u] ^ newMask;

                updateRange(tin[u], tout[u], diff);

                mask[u] = newMask;
                chars[u] = c;

            } else {
                int u = Integer.parseInt(p[1]);
                int v = Integer.parseInt(p[2]);

                int lca = getLCA(u, v);

                int pathMask =
                        getPrefix(tin[u])
                        ^ getPrefix(tin[v])
                        ^ mask[lca];

                result.add(
                        (pathMask & (pathMask - 1)) == 0
                );
            }
        }

        boolean[] answer = new boolean[result.size()];

        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return result;
    }

    private void buildTree() {
        timer = 0;

        int[] order = new int[n];
        int[] iter = new int[n];

        Arrays.fill(parent, -1);

        int top = 0;
        order[top++] = 0;
        parent[0] = 0;

        while (top > 0) {
            int u = order[top - 1];

            if (iter[u] == 0) {
                tin[u] = ++timer;

                up[0][u] = parent[u];

                for (int j = 1; j < LOG; j++) {
                    up[j][u] =
                            up[j - 1][up[j - 1][u]];
                }
            }

            if (iter[u] < graph[u].size()) {
                int v = graph[u].get(iter[u]++);

                if (v == parent[u]) {
                    continue;
                }

                parent[v] = u;
                depth[v] = depth[u] + 1;

                order[top++] = v;

            } else {
                tout[u] = timer;
                top--;
            }
        }
    }

    private void add(int i, int value) {
        while (i <= n) {
            bit[i] ^= value;
            i += i & -i;
        }
    }

    private int getPrefix(int i) {
        int result = 0;

        while (i > 0) {
            result ^= bit[i];
            i -= i & -i;
        }

        return result;
    }

    private void updateRange(int l, int r, int value) {
        add(l, value);
        add(r + 1, value);
    }

    private int getLCA(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int diff = depth[u] - depth[v];

        for (int j = 0; j < LOG; j++) {
            if ((diff & (1 << j)) != 0) {
                u = up[j][u];
            }
        }

        if (u == v) {
            return u;
        }

        for (int j = LOG - 1; j >= 0; j--) {
            if (up[j][u] != up[j][v]) {
                u = up[j][u];
                v = up[j][v];
            }
        }

        return parent[u];
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/palindromic-path-queries-in-a-tree/)