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