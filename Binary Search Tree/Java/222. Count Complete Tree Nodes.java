*******************************222. Count complete TreeNode *****************************************

class Solution {
    public int getHeightLeft(TreeNode root)
    {
        int height=0;
        TreeNode curr=root;
        while(curr!=null)
        {
            height++;
            curr=curr.left;
        }
     return height;
    }


    public int getHeightRight(TreeNode root)
    {
        int height=0;
        TreeNode curr=root;
        while(curr!=null)
        {
            height++;
            curr=curr.right;
        }
        return height;
    }


    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        
        int left=getHeightLeft(root);
        int right=getHeightRight(root);

        if(left==right)
        {
            return((2<<left)-1);
        }

        else{
            return 1+countNodes(root.left)+countNodes(root.right);
        }
    }
}
