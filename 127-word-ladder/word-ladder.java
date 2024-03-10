
class Solution {
    public int ladderLength(String a, String b, List<String> li) {
        Set<String> st = new HashSet<>(li);
        Set<String> vis = new HashSet<>();
        vis.add(a);
        Queue<String> q = new LinkedList<>();
        q.add(a);
        int c=0,mn=0;
        while(!q.isEmpty()){
            int ll=q.size();
            for(int p=0;p<ll;p++){
                String s = q.poll();
                // System.out.println(s+" "+b);
                if(s.equals(b))
                    return c+1;
                for(int i=0;i<s.length();i++){
                    String x= s.substring(0,i),y=s.substring(i+1);
                    for(int j=0;j<26;j++){
                        char ch = (char)(j+'a');
                        if(ch!=s.charAt(i)){
                            String w = x+ch+y;
                            if(!vis.contains(w) && st.contains(w)){
                                q.add(w);
                                vis.add(w);
                            }
                        }
                    }
                }
            }
            c++;
        }
        return 0;
    }
}