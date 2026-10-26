class Solution {
    public int countIslands(int[][] grid, int k) {
        int ans=0;
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] vis=new boolean[n][m];


        for(int i=0;i< n ;i++){
            for(int j=0;j<m ;j++){
                if(vis[i][j]==true)continue;
                if(grid[i][j]!=0){
                long sum=dfs(grid , i , j, vis);
                if(sum %k==0){
                    ans++;
                }
            }}
        }
        return ans;

        
    }
    public long dfs(int[][]grid, int i , int j , boolean[][] vis){
        int n=grid.length;
        int m =grid[0].length;
        
       
         if(i<0 || i>=n || j<0 ||j>=m)return 0;
         if(vis[i][j]==true)return 0;
         if(grid[i][j]==0)return 0;

        vis[i][j]=true;
         long sum= grid[i][j];

        
      

         sum+=dfs(grid, i+1 , j , vis);
         sum+=dfs(grid, i-1, j ,vis);
         sum+=dfs(grid, i,j+1 ,vis);
         sum+=dfs(grid, i, j-1 , vis);
      

         return sum;





    }
}