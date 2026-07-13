class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxlen=0;
        int l=0 ;
        HashSet<Character> set=new HashSet<>();

        for(int r=0 ;r<s.length();r++){
            char ch=s.charAt(r);
            if(set.contains(ch)){
                while(set.contains(ch)){
                    set.remove(s.charAt(l));
                    l++;
                }
            }
            set.add(ch);
            maxlen=Math.max(maxlen,r-l+1);
        }
        return maxlen;
        
    }
}