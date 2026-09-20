class Solution {
    public int reverseDegree(String s) {
        int n=s.length();
        int ans=0 ;
        int i=1;
        for(char ch : s.toCharArray()){
            int rev= 26-(ch-'a');
            ans+=i*rev;
            i++;


        }
        return ans;

        
    }
}