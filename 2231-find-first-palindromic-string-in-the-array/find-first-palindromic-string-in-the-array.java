//abcba
class Solution {
    public boolean check(String s){
        int l=0,r=s.length()-1;
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l++;
            r--;
        } 
        return true;
    }
    public String firstPalindrome(String[] str) {
        for(int i=0;i<str.length;i++){
            if(check(str[i])){
                return str[i];
            }
        }
        return "";
    }
}