class Solution {
    static final int MOD = 1_000_000_007;

    class SegmentTree {
        long[] sum, lazy;
        int n;

        SegmentTree(int n) {
            this.n = n;
            sum = new long[4 * n];
            lazy = new long[4 * n];
        }

        void update(int node, int start, int end,
                    int l, int r, long val) {
            if (l > end || r < start) return;

            if (l <= start && end <= r) {
                sum[node] += (end - start + 1) * val;
                lazy[node] += val;
                return;
            }

            int mid = (start + end) / 2;
            push(node, start, end);

            update(node * 2, start, mid, l, r, val);
            update(node * 2 + 1, mid + 1, end, l, r, val);

            sum[node] = sum[node * 2] + sum[node * 2 + 1];
        }

        void push(int node, int start, int end) {
            if (lazy[node] == 0 || start == end) return;

            int mid = (start + end) / 2;
            long val = lazy[node];

            sum[node * 2] += (mid - start + 1) * val;
            sum[node * 2 + 1] += (end - mid) * val;

            lazy[node * 2] += val;
            lazy[node * 2 + 1] += val;

            lazy[node] = 0;
        }

        long query(int node, int start, int end,
                   int l, int r) {
            if (l > end || r < start) return 0;

            if (l <= start && end <= r) return sum[node];

            push(node, start, end);
            int mid = (start + end) / 2;

            return query(node * 2, start, mid, l, r)
                 + query(node * 2 + 1, mid + 1, end, l, r);
        }
    }

    public int sumCounts(int[] nums) {
        int n = nums.length;
        SegmentTree st = new SegmentTree(n);
        java.util.HashMap<Integer, Integer> last = new java.util.HashMap<>();

        long ans = 0;
        long total = 0;

        for (int i = 0; i < n; i++) {
            int prev = last.getOrDefault(nums[i], -1);

            st.update(1, 0, n - 1, prev + 1, i, 1);

            total = (total + 2L * st.query(1, 0, n - 1, 0, i) - (i + 1L)) % MOD;

            ans = (ans + total) % MOD;

            last.put(nums[i], i);
        }

        return (int) ((ans + MOD) % MOD);
    }
}