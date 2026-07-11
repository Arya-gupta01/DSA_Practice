class Solution {

    public void dfs(int node, List<Integer>[] adj, boolean[] vis, int[] count) {
        vis[node] = true;

        count[0]++; 
        count[1] += adj[node].size(); 

        for (int nei : adj[node]) {
            if (!vis[nei]) {
                dfs(nei, adj, vis, count);
            }
        }
    }

    public int countCompleteComponents(int n, int[][] edges) {

        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        boolean[] vis = new boolean[n];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {

                int[] count = new int[2];
              

                dfs(i, adj, vis, count);

                int nodes = count[0];
                int edgeCount = count[1] / 2;

                if (edgeCount == nodes * (nodes - 1) / 2) {
                    ans++;
                }
            }
        }

        return ans;
    }
}