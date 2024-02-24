class Solution {
    public void fun(int i, String s, String sb, List<String> ans, Map<Integer,String> mp){
        if(i==s.length()){
            if(sb.length()>0)
            ans.add(sb);
            return;
        }
        String t = mp.get(s.charAt(i)-'0');
        for(char ch: t.toCharArray()){
            fun(i+1,s,sb+""+ch,ans,mp);
        }
    }
    public List<String> letterCombinations(String s) {
        Map<Integer,String> mp = new HashMap<>();
        mp.put(2,"abc");
        mp.put(3,"def");
        mp.put(4,"ghi");
        mp.put(5,"jkl");
        mp.put(6,"mno");
        mp.put(7,"pqrs");
        mp.put(8,"tuv");
        mp.put(9,"wxyz");
        List<String> ans = new ArrayList<>();
        fun(0,s,"",ans,mp);
        return ans;
    }
}