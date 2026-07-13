class Solution {
    public double findMaxAverage(int[] nums, int k) {
         Long max=Long.MIN_VALUE;
        Long sum=0L;
         for(int i=0 ;i< k ;i++){
            sum+=nums[i];
         
         }
            max=Math.max(max, sum);
        
        for(int i= k ;i< nums.length;i++){
            sum+=nums[i];
            sum-=nums[i-k];
            max=Math.max(sum,max);
        }
        return (double)max/k;
        
    }
}