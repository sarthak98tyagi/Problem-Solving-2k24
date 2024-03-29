//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class GfG {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int w = Integer.parseInt(inputLine[1]);
            Item[] arr = new Item[n];
            inputLine = br.readLine().trim().split(" ");
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Item(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            System.out.println(String.format("%.6f", new Solution().fractionalKnapsack(w, arr, n)));
        }
    }
}
// } Driver Code Ends




/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/

class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int w, Item arr[], int n) 
    {
        // Your code here
        Arrays.sort(arr, new Comparator<Item>(){
            
            @Override
            public int compare(Item a , Item b){
                double ar = (double)a.value/a.weight;
                double br = (double)b.value/b.weight;
                return Double.compare(br,ar);
            }
        });
        double ans = 0;
        for(Item item : arr){
            int value = item.value, weight = item.weight;
            if(w==0)
                return ans;
            int el = weight<=w ? weight : w;
            double cost = ((double)value/ weight)*el;
            w=w-el;
            ans+=cost;
        }
        return ans;
    }
}