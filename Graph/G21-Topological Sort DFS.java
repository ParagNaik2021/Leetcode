//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;
  

class Solution
{
     public static void dfs(int node,int[] visited, ArrayList<ArrayList<Integer>> adj,Stack<Integer> st){
        visited[node]=1;
        for(int it:adj.get(node)){
            if(visited[it]==0){
                dfs(it,visited,adj,st);
            }
        }
          st.push(node);
        return;
    
    }

    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {

       int[] ans=new int[V];
        int[] visited=new int[V];

        Stack<Integer> st=new Stack<>();

        //For Graph Components
        for(int i=0;i<V;i++){
            if(visited[i]==0){
                dfs(i,visited,adj,st);
              
            }
        }

// The stack holds the Topological sort order 
        while(!st.isEmpty()){
            int val =st.pop();
            for(int j=0;j<ans.length;j++){
                ans[j]=val;
            }
    }

    return ans;
    }
}
