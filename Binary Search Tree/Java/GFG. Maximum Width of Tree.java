*******************************GFG. Maximum Width of Tree*****************************************

class Solution {
    
    // Function to get the maximum width of a binary tree.
    int getMaxWidth(Node root) {
        // Your code here
        if(root==null) return 0;
        Queue<Node> Q=new LinkedList<Node>();
        int width=0;
        Q.offer(root);
        while(!Q.isEmpty())
        {
            int size=Q.size();
            width=Math.max(width,size);

            for(int i=0;i<size;i++)
            {
                Node node=Q.peek();
                Q.poll();
                if(node.left!=null) Q.offer(node.left);
                if(node.right!=null) Q.offer(node.right);
               
            }
            
        }
        return width;
    }
}

