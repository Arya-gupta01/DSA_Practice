class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        HashSet<Integer> setA=new HashSet<>();
          HashSet<Integer> setB=new HashSet<>();
          int c=0;
        int[]ans=new int[A.length];

        for(int i=0;i< A.length ;i++){
            setA.add(A[i]);
            setB.add(B[i]);
            if(A[i]==B[i])c++;
            else {
            if(setA.contains(B[i]))c++;
             if(setB.contains(A[i]))c++;
            }

            ans[i]=c;
        }
        return ans;
        
    }
}