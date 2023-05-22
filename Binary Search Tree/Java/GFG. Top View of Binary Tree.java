*******************************Top View of a Binary Tree*****************************************

class Solution
{
    static class Tuple{
        Node node;
        int col;
        
         Tuple(Node _node,int _col)
        {
            node=_node;
            col=_col;
        }
        
    }
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        // add your code
        TreeMap<Integer,Integer> map=new TreeMap<>();
        Queue<Tuple> q=new LinkedList<Tuple>();
        ArrayList<Integer> list=new ArrayList<>();
         if(root==null) return list;
        q.offer(new Tuple(root,0));
        while(!q.isEmpty())
        {
            Tuple tuple=q.poll();
            Node node=tuple.node;
            int col=tuple.col;
           
            if(map.get(col)==null) map.put(col,node.data);
           
            if(node.left!=null) q.offer(new Tuple(node.left,col-1));
           
            if(node.right!=null) q.offer(new Tuple(node.right,col+1));
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet())
        {
            list.add(entry.getValue());
        }
        
        return list;
    }
}

