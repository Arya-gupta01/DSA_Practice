class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) 
    {
        Arrays.sort(arr);
        
        for(int i=0 ;i< arr.length ;i++){
            if(arr[0]!=1){
                arr[0]=1;
            }
            if(i!=0){
                if(arr[i]-arr[i-1]>1){
                    arr[i]=arr[i-1]+1;
                }
            }
        }
        int max=1;
        for(int num:arr){
            max=Math.max(num,max);
        }
        return max;
        
    }
}