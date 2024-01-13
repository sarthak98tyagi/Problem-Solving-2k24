class Solution {
    public int minSteps(String s, String t) {
        int n = s.length();
        int[] sr = new int[26];
        int[] tr = new int[26];
        for(Character ch: s.toCharArray())
            sr[ch-'a']++;
        for(Character ch: t.toCharArray())
            tr[ch-'a']++;
        int a=0,b=0;
        for(int i=0;i<26;i++){
            if(sr[i]>tr[i])
                a=a+(sr[i]-tr[i]);
            else if(sr[i]<tr[i])
                b=b+(tr[i]-sr[i]);
        }
        return a;
    }
}