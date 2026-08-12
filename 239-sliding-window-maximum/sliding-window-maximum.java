class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int pref[]=new int[n];
        int suff[]=new int[n];
        pref[0]=nums[0];
        suff[n-1]=nums[n-1];

        for(int i=1 ;i<n ;i++){
            if(i%k==0){
                pref[i]=nums[i];
            }
            else{
                pref[i]=Math.max(nums[i],pref[i-1]);
            }


        }
        for(int i=n-2;i>=0 ;i--){
            if((i+1)%k==0){
                suff[i]=nums[i];
            }
            else{
                suff[i]=Math.max(suff[i+1],nums[i]);
            }
        }
        int ans[]=new int[n-k+1];
        for(int i=0 ;i<n-k+1;i++){
            ans[i]=Math.max(pref[i+k-1],suff[i]);
        }
        return ans;
        
    }
}