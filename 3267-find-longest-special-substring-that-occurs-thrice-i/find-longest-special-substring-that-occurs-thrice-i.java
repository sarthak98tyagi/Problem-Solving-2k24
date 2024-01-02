class Solution {
    public int maximumLength(String s) {
        Map<String,Integer> mp = new HashMap<>();
        StringBuilder sb=null;
        HashSet<Character> st=null;
        for(int i=0;i<s.length();i++){
            sb = new StringBuilder(String.valueOf(s.charAt(i)));
            mp.put(sb.toString(),mp.getOrDefault(sb.toString(),0)+1);
            st = new HashSet<>();
            st.add(s.charAt(i));
            for(int j=i+1;j<s.length();j++){
                st.add(s.charAt(j));
                if(st.size()==1){
                    sb.append(String.valueOf(s.charAt(j)));
                    mp.put(sb.toString(),mp.getOrDefault(sb.toString(),0)+1);
                }
                else
                    break;               
            }
        }
        String ans = "";
        for(String str : mp.keySet()){
            int f = mp.get(str);
            if(f>=3 && ans.length()<str.length()){
                ans=str;
            }
        }
        if(ans.length()==0)
                return -1;
        return ans.length();
    }
}