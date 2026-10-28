class Solution {
    public int maxSubArray(int[] nums) {
        int maxsum=Integer.MIN_VALUE;

        int left=0;
        int n=nums.length;
        int sum=0;
        
        for(int right=0; right<n ;right++){
           
            while(sum<0){
                sum-=nums[left];
                left++;
            }
            sum+=nums[right];
            maxsum=Math.max(sum,maxsum);
          
           

        

            

        }
        return maxsum;

        
    }
}