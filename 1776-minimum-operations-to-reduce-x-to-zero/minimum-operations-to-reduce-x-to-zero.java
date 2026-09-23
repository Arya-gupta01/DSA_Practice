class Solution {
    public int minOperations(int[] nums, int x) {
        int total=0;
        for(int num :nums){
            total+=num;

        }
        int sum=total-x;
        int maxlen=0;
        int l=0;
        int currsum=0;
        if (sum == 0) return nums.length;

        for(int r=0 ;r<nums.length;r++){
            currsum+=nums[r];
            while(l<=r && currsum>sum){
                currsum-=nums[l];
                l++;}
            if(currsum==sum){
                    maxlen=Math.max(maxlen , r-l+1);
                }
            }
            

        
        return maxlen!=0 ?nums.length-maxlen:-1;

        
    }
}