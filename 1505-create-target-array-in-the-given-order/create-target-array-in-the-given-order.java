class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {

        ArrayList<Integer> target=new ArrayList<>();

        int n=nums.length;

        for(int i=0 ;i< n ;i++){
            target.add(index[i],nums[i]);
        }
        
        int size=target.size();

        int[]ans=new int[size];
        for(int i=0 ;i<size;i++){
            ans[i]=target.get(i);
        }
        return ans;


        
    }
}