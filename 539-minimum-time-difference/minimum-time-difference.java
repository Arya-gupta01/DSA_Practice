class Solution {
    public int findMinDifference(List<String> timePoints) {
       List<Integer> minutes=new ArrayList<>();

       for(String time :timePoints){
        int h=Integer.parseInt(time.substring(0,2));
        int m=Integer.parseInt(time.substring(3,5));

        minutes.add(h*60 +m);
       }

       Collections.sort(minutes);

       int minDiff=Integer.MAX_VALUE;
       int n=minutes.size();

       for(int i=1 ;i<n ;i++){
        minDiff=Math.min(minDiff ,minutes.get(i)-minutes.get(i-1));
       }

       int circularDiff=1440 -minutes.get(n-1)+ minutes.get(0);

       minDiff=Math.min(minDiff,circularDiff);
       return minDiff;











        

        
    }
}