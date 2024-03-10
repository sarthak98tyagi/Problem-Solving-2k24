class Solution {
    public void palPar(int x,List<List<String>> ans,List<String> li, String s){
        if(x==s.length()){
            ans.add(new ArrayList<>(li));
            return;
        }
        for(int i=x;i<s.length();i++){
            String sub = s.substring(x,i+1);
            if(isPal(sub)){
                li.add(sub);
                palPar(i+1,ans,li,s);
                li.remove(li.size()-1);
            }
        }
    }
    public boolean isPal(String s){
        int l=0,r=s.length()-1;
        while(l<r){
            if(s.charAt(l)!=s.charAt(r))
                    return false;
            l++;
            r--;
        }
        return true;
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> li = new ArrayList<>();
        palPar(0,ans,li,s);
        return ans;
    }
}