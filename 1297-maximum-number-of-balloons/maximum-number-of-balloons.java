class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character , Integer> map=new HashMap<>();
      HashSet<Character> set = new HashSet<>(
    Arrays.asList('b', 'a', 'l', 'o', 'n')
);
        
        for(int i=0 ;i<text.length(); i++){
            char c=text.charAt(i);
            if(set.contains(c)){
               
                    map.put(c,map.getOrDefault(c,0)+1);

                
               
            }

        }
        if(map.size() < 5){
    return 0;
}
        int min=Integer.MAX_VALUE;
        
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
           
            if(entry.getKey()=='l' || entry.getKey()=='o'){
                int val=entry.getValue();
                val=val/2;
                min=Math.min(val,min);

            }
            else{
                int val=entry.getValue();
                min=Math.min(val,min);


            }
        }
        return min;

    


        
    }
}