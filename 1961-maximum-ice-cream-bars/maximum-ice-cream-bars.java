class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int c =0 ;
        Arrays.sort(costs);
        
        int coin=coins;
        int i=0 ;
        while(coin<=coins && i< costs.length){
            if(costs[i]<=coin){
                c++;
                coin-=costs[i];

            }
            i++;
        }
        return c;
        
    }
}