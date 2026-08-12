class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n=nums.length;
        int l=0;
        int len=Integer.MIN_VALUE;

        HashMap<Integer ,Integer> map=new HashMap<>();

        for(int r=0 ;r<n ;r++){
           
                map.put(nums[r],map.getOrDefault(nums[r],0)+1);
            
            while(map.get(nums[r])>k){
                map.put(nums[l],map.get(nums[l])-1);
                l++;
            }
           

            len=Math.max(len , r-l+1);
            
        }
        return len;




        
    }
}