class Solution {
    public void gen(int o, int c, int n, String s,List<String> ans){
        if(o==n && c==n){
            ans.add(s);
            return;
        }
        if(o<n){
            gen(o+1,c,n,s+"(",ans);
        }
        if(o>0 && c<o){
            gen(o,c+1,n,s+")",ans);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        gen(0,0,n,"",ans);
        return ans;
    }
}