class Solution {
    public boolean isPalindrome(String s) {
        int n=s.length(),l=0,r=n-1;
        while(l<=r){
            char ch=s.charAt(l);
            while(l<n && !((s.charAt(l)>=48 && s.charAt(l)<=57)||
                           (s.charAt(l)>=65 && s.charAt(l)<=90)||
                           (s.charAt(l)>=97 && s.charAt(l)<=122))){
                l++;
            }
            while(r>=0 && !((s.charAt(r)>=48 && s.charAt(r)<=57)||
                           (s.charAt(r)>=65 && s.charAt(r)<=90)||
                           (s.charAt(r)>=97 && s.charAt(r)<=122))){
                r--;
            }
            if(r<l)
                break;
            char chl=s.charAt(l),chr=s.charAt(r);
            if(chl>=65 && chl<=90)
                chl=(char)(chl+32);
            if(chr>=65 && chr<=90)
                chr=(char)(chr+32);
            if(chl!=chr)
                return false;
            l++;
            r--;
        }
        return true;
    }
}