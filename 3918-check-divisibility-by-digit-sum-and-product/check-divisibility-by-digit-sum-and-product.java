class Solution {
    public boolean checkDivisibility(int n) {
        int org=n;
        int sum=0 ;
        int pro=1;

        while(n>0){
            int d=n%10;
            sum+=d;
            pro*=d;
            n=n/10;
        }
      int s=pro+sum;
      if(org%s==0)return true;
        return false;
        
    }
}