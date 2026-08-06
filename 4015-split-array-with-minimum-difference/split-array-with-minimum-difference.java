class Solution {
    public long splitArray(int[] nums) {

        int n=nums.length;
        boolean [] inc=new boolean[n];
        boolean []dec=new boolean[n];
        long[] sum=new long[n];
        inc[0]=true;
        dec[n-1]=true;
        sum[0]=nums[0];

        for(int i=1 ;i<n ;i++ ){
            inc[i]=inc[i-1] && (nums[i]>nums[i-1]);
           
            
        }
         for(int i=n-2 ;i>=0 ;i-- ){
           dec[i]=dec[i+1]&& (nums[i]>nums[i+1]);
        }
        for(int i=1 ;i< n ;i++){
            sum[i]=sum[i-1]+nums[i];
        }
        long ans=Long.MAX_VALUE;

        for(int i=0 ;i<n-1;i++){
            if(inc[i] && dec[i+1]){
                ans=Math.min(ans, Math.abs(sum[i]-(sum[n-1]-sum[i])));
            }
        }
        return ans==Long.MAX_VALUE? -1:ans;

        
    }
}