//Using indegree method

class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        int[] indegree=new int[V];
        //We calcluate indegree of each node i.e  incoming edges to a node
        for(int i=0;i<V;i++){
            for(int it:adj.get(i)){
                indegree[it]++; // i.e indegree[0]++ i.e indegree[0]=3
            }
        }
        
        //we only push the node with indegree 0 in the Q first
        Queue<Integer> Q=new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                Q.offer(i);
            }
        }
        int i=0; // i is to increment pointer in ans array
        int[] ans=new int[V];
        //Now we perform BFS and we reduce the indegree as per the visited node
        while(!Q.isEmpty()){
            int node=Q.peek();
            Q.poll();
            ans[i++]=node;
            // Here we reduce the indegree
            for(int it:adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0) {
                    Q.offer(it);
                }
            }
        }
        
        return ans;
        
    }
}
