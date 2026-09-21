class Solution {
    public long[] resultArray(int[] nums, int k) {

        long[] resArray = new long[k];

      
        long[] dp = new long[k];

        for (int num : nums) {

            long[] newDp = new long[k];

            int val = num % k;

            newDp[val]++;

           
            for (int r = 0; r < k; r++) {
                if (dp[r] > 0) {
                    int newRemainder = (r * val) % k;
                    newDp[newRemainder] += dp[r];
                }
            }

    
            for (int r = 0; r < k; r++) {
                resArray[r] += newDp[r];
            }

            dp = newDp;
        }

        return resArray;
    }
}
