class Solution {
    public List<List<Integer>> findMatrix(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        int i = 0;
        while(i<arr.length){
                if(arr[i]==0){
                    i++;
                    continue;
                }
                Set<Integer> st = new HashSet<>();
                st.add(arr[i]);
                arr[i]=0;
                int j =i+1;
                boolean first = true;
                while(j<arr.length){
                    if(arr[j]!=0 && !st.contains(arr[j])){
                        st.add(arr[j]);
                        arr[j]=0;
                    }
                    else if(arr[j]!=0 && st.contains(arr[j]) && first){
                        first = false;
                        i=j;
                    }
                    j++;
                }
                ans.add(new ArrayList<>(st));
        }
        return ans;
    }
}