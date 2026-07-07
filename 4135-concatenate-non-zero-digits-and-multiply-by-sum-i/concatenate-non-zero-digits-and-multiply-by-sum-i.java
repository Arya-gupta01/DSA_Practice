class Solution {
    public long sumAndMultiply(int n) {
        StringBuilder sb=new StringBuilder();
        String num=Integer.toString(n);
        

        for(int i=0 ;i<num.length();i++){
            if(num.charAt(i)!='0'){
                sb.append(num.charAt(i));
            }
        }
        long xnum = (sb.length() == 0) ? 0 : Long.parseLong(sb.toString());
        long sum=0;

        while(n>0){
            sum+=n%10;
            n=n/10;
        }

        return (long)xnum*sum;


        
    }
}