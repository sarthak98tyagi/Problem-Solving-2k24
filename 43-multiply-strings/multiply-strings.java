class Solution {
    public String multiply(String s1, String s2) {
        if(s1.equals("0") || s2.equals("0"))
            return "0";
        int n1 = s1.length(), n2 = s2.length();
        if(n2>n1)
            return multiply(s2,s1);
        int[] ans = new int[n1+n2];
        int an=-1;
        for(int j=(n2-1);j>=0;j--){
            int x = n2-j-1, c=0;
            for(int i=(n1-1);i>=0;i--){
                int pr = (s1.charAt(i)-'0')*(s2.charAt(j)-'0')+ans[x]+c;
                ans[x] = pr % 10;
                c = pr/10;
                x++;
                an=x;
            }
            if(c>0){
                ans[x] = c;
                x++;
                an=x;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=(an-1);i>=0;i--){
            sb.append((char)(ans[i]+'0')+"");
        }
        return sb.toString();

                                                                   
    }
}
//O(n2*n1)  TC
//O(n1+n2) SC