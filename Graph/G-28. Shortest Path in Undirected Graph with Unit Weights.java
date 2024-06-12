class Pair{
    int first, second;
    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public void topoSort(int node,ArrayList<ArrayList<Pair>> adj,int[] visited,Stack<Integer> st){
        visited[node]=1;
        for(int i=0;i<adj.get(node).size();i++){
            int v=adj.get(node).get(i).first;
            if(visited[v]==0){
                topoSort(v,adj,visited,st);
            }
        }
        st.add(node);
    }

	public int[] shortestPath(int N,int M, int[][] edges) {
		//Code here
		ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
		// we are createing a graph which also hold the weights along with it
		for(int i=0;i<N;i++){
		    ArrayList<Pair> temp=new ArrayList<>();
		    adj.add(temp);
		}
		//populated the graph
		for(int i=0;i<M;i++){
		    int u=edges[i][0];
		    int v=edges[i][1];
		    int wt=edges[i][2];
		    adj.get(u).add(new Pair(v,wt));
		}
//Step 1- to find topo sort
		int[] visited=new int[N];
		Stack<Integer> st=new Stack<>();
		// we will perform topo sort and we will also check for component graph
		for(int i=0;i<N;i++){
		    if(visited[i]==0){
		        topoSort(i,adj,visited,st);
		    }
		}
		
		//Step 2- Distance
		int[] distance=new int[N];
		for(int i=0;i<N;i++){
		    distance[i]=(int) 1e9;
		}
		//mark the src i.e 0 has 0 because the distance to itself is 0
		distance[0]=0;
		while(!st.isEmpty()){
		    int node=st.peek();
		    st.pop();
		    //the for loop is to access the element in adj list for a specific node
		    for(int i=0;i<adj.get(node).size();i++){
		        int v=adj.get(node).get(i).first;
		        int wt=adj.get(node).get(i).second;
		        
		        if(distance[node]+wt<distance[v]){
		            distance[v]=wt+distance[node];
		        }
		    }
		}
 		for(int i=0;i<N;i++){
 		    if(distance[i]==1e9)  distance[i]= -1;
		}
		
		return distance;
		
	}
}