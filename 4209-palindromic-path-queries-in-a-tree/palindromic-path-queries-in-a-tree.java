
import java.util.*;

class Solution {

    int n;

    ArrayList<Integer>[] adj;

    int[] parent, depth;
    int[] size, heavy;
    int[] head, pos, flat;
    int timer;
    static class SegmentTree {
        int n;
        int[] tree;

        SegmentTree(int[] arr) {
            n = arr.length;
            tree = new int[4 * n];
            build(1, 0, n - 1, arr);
        }

        void build(int node, int l, int r, int[] arr) {
            if (l == r) {
                tree[node] = arr[l];
                return;
            }

            int mid = (l + r) / 2;

            build(node * 2, l, mid, arr);
            build(node * 2 + 1, mid + 1, r, arr);

            tree[node] =
                tree[node * 2] ^ tree[node * 2 + 1];
        }

        void update(int node, int l, int r,
                    int idx, int value) {
            if (l == r) {
                tree[node] = value;
                return;
            }

            int mid = (l + r) / 2;

            if (idx <= mid) {
                update(node * 2, l, mid, idx, value);
            } else {
                update(node * 2 + 1, mid + 1, r,
                       idx, value);
            }

            tree[node] =
                tree[node * 2] ^ tree[node * 2 + 1];
        }

        int query(int node, int l, int r,
                  int ql, int qr) {
            if (qr < l || r < ql) {
                 return 0;

            }

            if (ql <= l && r <= qr) {
                return tree[node];
            }

            int mid = (l + r) / 2;

            int left = query(
                node * 2, l, mid, ql, qr
            );

            int right = query(
                node * 2 + 1, mid + 1, r, ql, qr
            );

            return left ^ right;
        }

        void update(int idx, int value) {
            update(1, 0, n - 1, idx, value);
        }

        int query(int l, int r) {
            return query(1, 0, n - 1, l, r);
        }
    }

    public List<Boolean> palindromePath(
            int n, int[][] edges, String s,
            String[] queries) {

        this.n = n;

        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj[u].add(v);
            adj[v].add(u);
        }

        parent = new int[n];
        depth = new int[n];
        size = new int[n];
        heavy = new int[n];
        head = new int[n];
        pos = new int[n];
        flat = new int[n];

    
        int[] order = new int[n];
        int[] stack = new int[n];
        int top = 0;
        int count = 0;

        Arrays.fill(parent, -2);

        stack[top++] = 0;
        parent[0] = -1;

        while (top > 0) {
            int u = stack[--top];
            order[count++] = u;

            for (int v : adj[u]) {
                if (v == parent[u]) {
                    continue;
                }

                parent[v] = u;
                depth[v] = depth[u] + 1;
                stack[top++] = v;
            }
        }
        Arrays.fill(heavy, -1);

        for (int i = n - 1; i >= 0; i--) {
            int u = order[i];
            size[u] = 1;

            int maxSize = 0;

            for (int v : adj[u]) {
                if (parent[v] == u) {
                    size[u] += size[v];

                    if (size[v] > maxSize) {
                        maxSize = size[v];
                        heavy[u] = v;
                    }
                }
            }
        }
        int[] chainNodes = new int[n];
        int[] chainHeads = new int[n];
        top = 0;
        timer = 0;

        chainNodes[top] = 0;
        chainHeads[top++] = 0;

        while (top > 0) {
            int start = chainNodes[--top];
            int chainHead = chainHeads[top];

            int u = start;

            while (u != -1) {
                head[u] = chainHead;
                pos[u] = timer++;
                for (int v : adj[u]) {
                    if (parent[v] == u && v != heavy[u]) {
                        chainNodes[top] = v;
                        chainHeads[top++] = v;
                    }
                }

                u = heavy[u];
            }
        }


        char[] chars = s.toCharArray();

        for (int u = 0; u < n; u++) {
            flat[pos[u]] = 1 << (chars[u] - 'a');
        }

        SegmentTree seg = new SegmentTree(flat);

        List<Boolean> answer = new ArrayList<>();

        for (String q : queries) {
            String[] parts = q.split(" ");

            if (parts[0].equals("update")) {
                int u = Integer.parseInt(parts[1]);
                char c = parts[2].charAt(0);

                chars[u] = c;

                int newMask = 1 << (c - 'a');

                seg.update(pos[u], newMask);

            } else {
                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);

                int mask = 0;

            
                while (head[u] != head[v]) {
                    if (depth[head[u]] < depth[head[v]]) {
                        int temp = u;
                        u = v;
                        v = temp;
                    }

                    mask ^= seg.query(
                        pos[head[u]], pos[u]
                    );

                    u = parent[head[u]];
                }

                if (depth[u] > depth[v]) {
                    int temp = u;
                    u = v;
                    v = temp;
                }

                mask^= seg.query(pos[u], pos[v]);
                answer.add((mask & (mask - 1)) == 0);
            }
        }

        return answer;
    }
}
