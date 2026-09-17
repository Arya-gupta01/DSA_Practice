class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n=arr.length;
        int i=0 ;
        int j=0 ;

        int currsum=0;
        int[] minlen=new int[n];
        int bestminlen=Integer.MAX_VALUE;
        Arrays.fill(minlen , Integer.MAX_VALUE);
        int res=Integer.MAX_VALUE;

        while(j<n){

            currsum+=arr[j];

            while(currsum>target){
                currsum-=arr[i];
                i++;
            }
            if(currsum==target){
                int len=j-i+1;
                if(i>0 && minlen[i-1]!=Integer.MAX_VALUE){
                    res=Math.min(res, len+minlen[i-1]);

                }
                bestminlen=Math.min(bestminlen , len);
                

            }
            minlen[j]=bestminlen;
            j++;
        }
        return res==Integer.MAX_VALUE ? -1 : res;
      
    }
}