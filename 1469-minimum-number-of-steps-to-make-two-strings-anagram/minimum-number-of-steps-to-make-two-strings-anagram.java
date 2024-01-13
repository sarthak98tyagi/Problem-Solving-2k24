class Solution {
    public int minSteps(String s, String t) {
        int[] sr = new int[26];
        for(Character ch: s.toCharArray())
            sr[ch-'a']++;
        for(Character ch: t.toCharArray())
            sr[ch-'a']--;
        int count=0;
        for(int i=0;i<26;i++){
            if(sr[i]>0)
                count+=sr[i];

        }
        return count;
    }
}