class Solution {
    public int smallestIndex(int[] nums) {
        int ans=-1;
        for(int i=0 ;i< nums.length ;i++){
            if(sum(nums[i])==i){
                return i;
            }
        }
        return ans;
        
    }
    public static int sum(int n){
        int s=0 ;
        while(n>0){
            s+=n%10;
            n=n/10;
        }
        return s;
    }

}