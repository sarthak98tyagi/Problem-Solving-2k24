class Solution {
    public String addBinary(String a, String b) {
        int n1=a.length(), n2=b.length();
        int i=n1-1, j=n2-1;
        int c=0;
        StringBuilder sb = new StringBuilder();
        while(i>=0 || j>=0){
            int aa = (i>=0)?a.charAt(i)-'0':0;
            int bb = (j>=0)?b.charAt(j)-'0':0;
            int s= aa+bb+c;
            int x=0;
            if(s<2)
                x=s;
            else
                x=(s%2);
            sb.append(x+"");
            c=s/2;
            // System.out.println(s+" "+c);
            i--;
            j--;
        }
        if(c>0)
            sb.append("1");
        return sb.reverse().toString();
    }
}