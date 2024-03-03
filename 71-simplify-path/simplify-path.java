class Solution {
    public String simplifyPath(String path) {
        String[] arr = path.split("/");
        Stack<String> st = new Stack<>();
        for(String s: arr){
            if(s.length()==0 || s.equals("."))
                continue;
            if(s.equals("..")){
                if(!st.isEmpty())
                st.pop();
            }
            else
                st.push(s);
        }
        StringBuilder ans = new StringBuilder("");
        while(!st.isEmpty()){
            ans.insert(0,"/"+st.pop());
        }
        String ot = ans.toString();
        if(ot.length()==0)
            return "/";
        return ot;
    }
}