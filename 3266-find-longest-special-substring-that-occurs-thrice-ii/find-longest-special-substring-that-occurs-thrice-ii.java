class Solution {
    public int maximumLength(String s) {
        Map<String,Integer> mp = new HashMap<>();
        Character pr = '!';
        StringBuilder sb = new StringBuilder();
        for(Character ch : s.toCharArray()){
            if(pr=='!' || ch==pr){
                sb.append(ch);
            }
            else{
                mp.put(sb.toString(),mp.getOrDefault(sb.toString(),0)+1);
                sb = new StringBuilder();
                sb.append(ch);
            }
            pr=ch;
        }
        mp.put(sb.toString(),mp.getOrDefault(sb.toString(),0)+1);
        int mx = -1;
        for(String key: mp.keySet()){
            int x = key.length();
                String b = key.substring(0,x-1);          
                int f = mp.get(key);
                if(f>=3){
                    mx = Math.max(mx,x);
                }
                else if(x>=2 && (f==2 || mp.containsKey(b))){
                    mx = Math.max(mx,x-1);
                }
                else if(x>2){
                    mx = Math.max(mx,x-2);
                }
        }
        return mx;
    }
}