class Solution {
    public int minMoves2(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int med=nums[n/2];

        int move=0;

        for(int i=0;i<n;i++){
            move+=Math.abs(nums[i]-med);
        }

        return move;
        
    }
}