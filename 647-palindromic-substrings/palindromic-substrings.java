class Solution {
    public int countSubstrings(String s) {
        int c = 0;
        for(int i=0;i<s.length();i++){
            int l=i,r=i+1;
            c++;
            while(l>=0 && r<s.length()){
                if(s.charAt(l)==s.charAt(r)){
                    c++;
                    l--;
                    r++;
                }
                else
                    break;
            }
            l=i-1;
            r=i+1;
            while(l>=0 && r<s.length()){
                if(s.charAt(l)==s.charAt(r)){
                    c++;
                    l--;
                    r++;
                }
                else
                    break;
            }
        }
        return c;
    }
}