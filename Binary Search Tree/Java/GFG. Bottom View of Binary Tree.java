*******************************Bottom View of Binary Tree*****************************************

class Solution
{
    
    static class Pair{
        Node node;
        int col;
        Pair(Node _node,int _col)
        {
            node=_node;
            col=_col;
        }
        
    }
    
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        // Code here
        TreeMap<Integer,Integer> map=new TreeMap<>();
        Queue<Pair> Q=new LinkedList<Pair>();
        ArrayList<Integer> list=new ArrayList<>();
        Q.offer(new Pair(root,0));
        while(!Q.isEmpty())
        {
            Pair pair=Q.poll();
            Node curr=pair.node;
            int col=pair.col;
            
            map.put(col,curr.data);
            if(curr.left!=null) Q.offer(new Pair(curr.left,col-1));
               
            if(curr.right!=null) Q.offer(new Pair(curr.right,col+1));
            
        
        
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet())
        {
            list.add(entry.getValue());
        }
        
        return list;
        
    }
}