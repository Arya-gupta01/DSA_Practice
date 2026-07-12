class Solution {
    public int[] arrayRankTransform(int[] arr) {
        
     int[] nums = Arrays.copyOf(arr, arr.length);
     Arrays.sort(nums);
     HashMap<Integer,Integer> map=new HashMap<>();
      int rank=1;
     for(int i=0 ;i< nums.length;i++){
        if(!map.containsKey(nums[i])){
        map.put(nums[i],rank);
        rank++;
     }}
     for(int i=0 ;i< nums.length;i++){
        arr[i]=map.get(arr[i]);
     }
     return arr;
        
    }
}