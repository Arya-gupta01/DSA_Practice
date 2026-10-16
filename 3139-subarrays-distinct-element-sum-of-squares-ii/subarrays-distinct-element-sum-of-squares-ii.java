
class Solution {
    private static final int MOD = 1_000_000_007;

    class SegmentTree {
        long[] sum;
        long[] squareSum;
        long[] lazy;
        int n;

        SegmentTree(int n) {
            this.n = n;
            sum = new long[4 * n];
            squareSum = new long[4 * n];
            lazy = new long[4 * n];
        }

        void apply(int node, int l, int r, long val) {
            long len = r - l + 1L;
            squareSum[node] = (
                squareSum[node] + 2 * val * sum[node]
                + len * val % MOD * val
            ) % MOD;

            sum[node] = (sum[node] + len * val) % MOD;
            lazy[node] = (lazy[node] + val) % MOD;
        }

        void push(int node, int l, int r) {
            if (lazy[node] == 0 || l == r) return;

            int mid = (l + r) / 2;
            apply(node * 2, l, mid, lazy[node]);
            apply(node * 2 + 1, mid + 1, r, lazy[node]);
            lazy[node] = 0;
        }

        void update(int node, int l, int r, int ql, int qr) {
            if (ql > r || qr < l) return;

            if (ql <= l && r <= qr) {
                apply(node, l, r, 1);
                return;
            }

            push(node, l, r);
            int mid = (l + r) / 2;

            update(node * 2, l, mid, ql, qr);
            update(node * 2 + 1, mid + 1, r, ql, qr);

            sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;
            squareSum[node] = (
                squareSum[node * 2] + squareSum[node * 2 + 1]
            ) % MOD;
        }

        long getSquareSum() {
            return squareSum[1];
        }
    }

    public int sumCounts(int[] nums) {
        int n = nums.length;
        int[] last = new int[100001];
        java.util.Arrays.fill(last, -1);

        SegmentTree tree = new SegmentTree(n);
        long answer = 0;

        for (int i = 0; i < n; i++) {
            int left = last[nums[i]] + 1;

            tree.update(1, 0, n - 1, left, i);

            answer = (answer + tree.getSquareSum()) % MOD;
            last[nums[i]] = i;
        }

        return (int) answer;
    }
}
