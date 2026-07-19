class Solution {
    public String smallestSubsequence(String s) {
        int count[] = new int[26];
        boolean vis[] = new boolean[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            count[ch - 'a']--;

            if (vis[ch - 'a']) {
                continue;
            }

            while (!st.isEmpty() && st.peek() > ch && count[st.peek() - 'a'] > 0) {
                char popped = st.pop();
                vis[popped - 'a'] = false;
            }

            st.push(ch);
            vis[ch - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : st) {
            sb.append(ch);
        }
        return sb.toString();
    }
}