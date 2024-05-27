
class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int[] indegree=new int[V];
        //calcluate indegree of each node
        for(int i=0;i<V;i++){
            for(int it:adj.get(i)){
                indegree[it]++;
            }
        }
    // Declaring a Q and only push the node with indegree is
    Queue<Integer> Q=new LinkedList<>();
    for(int i=0;i<V;i++){
        if(indegree[i]==0){
            Q.offer(i);
        }
    }
    
    //Here we are performing BFS 
   int count=0;
    while(!Q.isEmpty()){
        int node=Q.peek();
        Q.poll();
        count++;
        for(int it:adj.get(node)){
            indegree[it]--;
            //if indegree is 0 we will push it in the Q
            if(indegree[it]==0){
                Q.offer(it);
                
            }
        }
    }
    //if there is a cycle the indegree of one node will never beome 0
    if(count==V) return false; 
    return true;
    
    }
}