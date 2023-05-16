*******************************LevelOrder Traversal-->LeetCode*****************************************

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> Q= new LinkedList<TreeNode>();
        //List<List<Integer>> wrapList=new LinkedList<List<Integer>>();
        List<List<Integer>> wrapList=new LinkedList<>();
        if(root==null) return wrapList;
        Q.offer(root);
        while(!Q.isEmpty())
        {
            int levelNum=Q.size();
            List<Integer> subList= new LinkedList<Integer>();
            for(int i=0;i<levelNum;i++)
            {
                if(Q.peek().left!=null)
                {
                    Q.offer(Q.peek().left);
                }
                if(Q.peek().right!=null)
                {
                    Q.offer(Q.peek().right);
                }
                subList.add(Q.poll().val);
            }
            wrapList.add(subList);
        }
        return wrapList;
    }
}


****************************GFG-Level order traversal*************************************************

class Solution
{
    //Function to return the level order traversal of a tree.
    static ArrayList <Integer> levelOrder(Node root) 
    {
        Queue<Node> Q=new LinkedList<Node>();
       ArrayList<Integer> subList=new ArrayList<Integer>();
        if(root==null) return subList;
        Q.offer(root);
        while(!Q.isEmpty())
        {
            int levelNum=Q.size();
            
        
            for(int i=0;i<levelNum;i++)
            {
                if(Q.peek().left!=null) // the front element using the peek() method
                    Q.offer(Q.peek().left);
                    
                if(Q.peek().right!=null)
                    Q.offer(Q.peek().right);
                subList.add(Q.poll().data);
            }
           
        }
        return subList;
    }
}

Note:-
1. Why to use .offer()? add() method throws an exception if the element cannot be added to the queue, while the offer() method returns false if the element cannot be added. 
2. the remove() method throws an exception if the queue is empty, while the poll() method returns null if the queue is empty.