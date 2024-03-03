class Solution {
    public List<String> fullJustify(String[] str, int k) {
        List<String> ll = new ArrayList<>();
        int i=0;
        int n = str.length;
        while(i<n){
            int c=0,l=0,wl=0;
            List<String> li = new ArrayList<>();
            while(i<n && (l+str[i].length()+c)<=k){
                l=l+str[i].length()+c;
                li.add(str[i]);
                c=1;
                wl+=str[i].length();
                i++;
           }
           if(li.isEmpty())
            continue;
           int totalSpaces = k-wl;
           int evenSpaces = 0;
           int overhead = 0;
           if(li.size()>1){
                evenSpaces = totalSpaces/(li.size()-1);
                overhead = totalSpaces%(li.size()-1);
           }
           StringBuilder sb = new StringBuilder();
           if(i==n){
               evenSpaces = 1;
               overhead = 0;
           }
           for(int p=0;p<li.size();p++){
               String el = li.get(p);
               sb.append(el);
               if(p==li.size()-1)
                    continue;
               for(int j=0;j<evenSpaces;j++){
                   sb.append(" ");
               }
               if(overhead>0){
                   overhead--;
                   sb.append(" ");
               }
           }
           while(sb.length()<k){
               sb.append(" ");
           }
           ll.add(sb.toString());
        }
        return ll;
    }
}