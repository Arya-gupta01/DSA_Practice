// class Solution {
//     public int minimumPushes(String word) {
//         int n=word.length();
//         if(n<=8)return n;
//         if(n<=16){
//             return 8+ 2*(n-8);
//         }
//         if(n<=24){
//             return 24+3*(n-16);
//         }
        
//             return 48 +4*(n-24);
        
        
//     }
// }

class Solution {
    public int minimumPushes(String word) {
        int ans = 0;

        for (int i = 0; i < word.length(); i++) {
            ans += i / 8 + 1;
        }

        return ans;
    }
}