class Solution {
    public int maxProduct(int n) {
        int p=1;
        List<Integer> l=new ArrayList<>();
        while(n>0){
            l.add(n%10);
            n=n/10;
        }
        Collections.sort(l,Collections.reverseOrder());
        if(l.size()==1){
            return l.get(0);
        }
        for(int i=0 ;i<=1;i++){
            p*=l.get(i);
        }  
        return p;
    }
}