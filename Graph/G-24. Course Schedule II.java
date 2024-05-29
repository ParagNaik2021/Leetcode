210. Course Schedule II
Note- N is the number of vertices of the graph i.e numCourses

class Solution {
    public int[] findOrder(int N, int[][] prerequisites) {
          ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<N;i++){
            adj.add(new ArrayList<>());
        }
        int m=prerequisites.length;
          for(int i=0;i<m;i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        
        int[] indegree=new int[N];
        for(int i=0;i<N;i++){
         for(int it:adj.get(i)){
             indegree[it]++;
         }   
        }
        
        Queue<Integer> Q=new LinkedList<>();
        for(int i=0;i<N;i++){
            if(indegree[i]==0){
                Q.offer(i);
            }
        }
        int i=0;
     int[] topo=new int[N];
        while(!Q.isEmpty()){
            int node=Q.peek();
            Q.poll();
            topo[i++]=node;
            
            
            // we will check the visited node and once the indegree becomes 0 we push it on Q
            for(int it:adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0) Q.offer(it);
                
            }
        }
        
        if(i==N) return topo;
        int[] arr={};
        return arr;
    }
}