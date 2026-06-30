class Solution {
    public int numberOfSubstrings(String s) {
        int arr[]=new int[3];
        int left=0 ;
        int c=0 ;

        for(int right=0 ;right< s.length();right++){
            char ch=s.charAt(right);
            arr[ch-'a']++;
            while(arr[0]>0 && arr[1]>0 && arr[2]>0){
                c+=s.length()-right;
                arr[s.charAt(left)-'a']--;
                left++;
            }
            
        }
        return c;
        
    }
}