class Solution {
    public int magicalString(int n) {
    
        if (n <= 0) return 0;
        if (n <= 3) return 1;
      
        int[] magical = new int[n + 1];
        magical[0] = 1;
        magical[1] = 2;
        magical[2] = 2;
        
        int head = 2; 
        int tail = 3; 
        int countOfOnes = 1; 
        int nextNum = 1; 
        while (tail < n) {
            int repeats = magical[head];
            
            for (int i = 0; i < repeats && tail < n; i++) {
                magical[tail] = nextNum;
                
                if (nextNum == 1) {
                    countOfOnes++;
                }
                tail++;
            }
            
          
            nextNum = (nextNum == 1) ? 2 : 1;
            head++;
        }
        
        return countOfOnes;
    }
}