802. Find Eventual Safe States
Note- In GFG problem the adj list is given but in leetcode problem when need to construct the adj list from adj matrix. The below code is the leetcode version

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adj=new ArrayList<>();
        int m=graph.length;
        int n=graph[0].length;

        //Intialize an empty arraylist
        for(int i=0;i<m;i++){
            adj.add(new ArrayList<>());
        }

        //populate the adj list
        for(int i=0;i<m;i++){
            for(int it:graph[i]){
                adj.get(i).add(it);
            }
        }


        //Reverse the adj list 
        List<List<Integer>> adjReverse=new ArrayList<>();
        for(int i=0;i<m;i++){
            adjReverse.add(new ArrayList<>());
        }


        int[] indegree=new int[m];

        //we reverse the edges of the given graph
        for(int i=0;i<m;i++){
            // For ex-> i--->it
            // it--->i
            for(int it:adj.get(i)){
                adjReverse.get(it).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> Q=new LinkedList<>();
        List<Integer> safeNode=new ArrayList<>();
        for(int i=0;i<m;i++){
            if(indegree[i]==0){
                Q.add(i);
            }
        }
      //  System.out.println(indegree);
        while(!Q.isEmpty()){
            int node=Q.peek();
            Q.remove();
            safeNode.add(node);
            for(int it:adjReverse.get(node)){
                indegree[it]--;
                if(indegree[it]==0) Q.add(it);
            }
        }
        Collections.sort(safeNode);
       // System.out.println(safeNode);
        return safeNode;
    }
}