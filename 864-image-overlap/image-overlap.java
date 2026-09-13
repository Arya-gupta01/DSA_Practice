class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        List<int[]> a=new ArrayList<>();
        List<int[]> b=new ArrayList<>();

        for(int i=0 ;i<img1.length;i++){
            for(int j=0;j<img1[0].length;j++){
                if(img1[i][j]==1){
                    a.add(new int[]{i,j});
                }
                if(img2[i][j]==1){
                    b.add(new int[]{i,j});
                }
            }
        }
        Map<String, Integer> map = new HashMap<>();
        int ans = 0;

        for (int[] p1 : a) {
            for (int[] p2 : b) {
                int dx = p1[0] - p2[0];
                int dy = p1[1] - p2[1];

                String key = dx + "," + dy;

                int count = map.getOrDefault(key, 0) + 1;
                map.put(key, count);

                ans = Math.max(ans, count);
            }
        }

        return ans;

        
    }
}