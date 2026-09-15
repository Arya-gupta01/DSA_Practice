class Solution {
    int[][] dp;
    public int solve(String s, int k , int i , int j){
        int n=s.length();


        if(i>=n || j>=n){
            return 0;
        }
        
         if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if(isPal(s,i,j)){
            int take=1+solve(s,k,j+1,j+k);
            int grow=solve(s,k,i,j+1);
            int slide=solve(s,k,i+1,j+1);

            return dp[i][j]=Math.max(take,Math.max(grow,slide));
        }
        int grow=solve(s,k,i,j+1);
            int slide=solve(s,k,i+1,j+1);

            return dp[i][j]=  Math.max(grow,slide);
        
    }
    public boolean isPal(String s , int l ,int r){

        while(l<r){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    public int maxPalindromes(String s, int k) {
        if(k==1){
            return s.length();
        }
        int n=s.length();
         dp = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            java.util.Arrays.fill(dp[i], -1);
        }

        return solve(s,k,0,k-1);
        
    }

    
}