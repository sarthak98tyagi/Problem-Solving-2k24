class Solution {
    public int numberOfBeams(String[] bank) {
        int pr = 0,ans=0;
        for(String s : bank){
            int a = 0;
            for(Character ch : s.toCharArray()){
                if(ch=='1'){
                    a++;
                }
            }
            ans=ans+(pr*a);
            if(a!=0)
                pr=a;
        }
        return ans;
    }
}