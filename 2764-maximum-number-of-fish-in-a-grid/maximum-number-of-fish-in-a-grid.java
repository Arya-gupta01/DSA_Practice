class Solution {
    public int findMaxFish(int[][] grid) {
        int n=grid.length;
        int m =grid[0].length;

        int ans=0;

        boolean[][]vis=new boolean[n][m];

        for(int i=0 ;i< n ;i++){
            for(int j=0 ;j<m ;j++){
                 if(grid[i][j]==0 || vis[i][j]==true){
                    continue;
                 }
                 
                    int sum=dfs(grid,i , j , vis);
                    ans=Math.max(ans, sum);
            }}
            return ans;}
        

   
    public int dfs(int[][]grid,int i , int j , boolean[][]vis ){
        
        int n=grid.length;
        int m =grid[0].length;


        if(i<0 || j<0 ||i>=n ||j>=m)return 0;
        if(vis[i][j]==true)return 0;
        if(grid[i][j]==0)return 0;

        int sum=grid[i][j];
        vis[i][j]=true;

        sum+=dfs(grid, i+1 , j , vis);
        sum+=dfs(grid, i, j+1, vis);
        sum+=dfs(grid, i-1 ,j ,vis);
        sum+=dfs(grid, i, j-1 , vis);


        return sum;





    }
}