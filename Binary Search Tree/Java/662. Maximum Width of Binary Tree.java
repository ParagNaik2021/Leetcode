*******************************662. Maximum Width of Binary Tree*****************************************

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode> Q=new LinkedList<TreeNode>();
        int width=0;
        Q.offer(root);
        while(!Q.isEmpty())
        {
            int size=Q.size();
            width=Math.max(width,size);

            for(int i=0;i<size;i++)
            {
                TreeNode node=Q.peek();
                Q.poll();
                if(node.left!=null) Q.offer(node.left);
                if(node.right!=null) Q.offer(node.right);
               
            }
            
        }
        return width;
    }
}
