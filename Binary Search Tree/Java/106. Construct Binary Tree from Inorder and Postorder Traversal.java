*******************************106. Construct Binary Tree from Inorder and Postorder Traversal*****************************************

class Solution {
    public TreeNode buildTree(int[] inorder,int inStart,int inEnd, int[] postorder,int postStart,int postEnd,HashMap<Integer,Integer> map)
    {
        if(inStart>inEnd || postStart>postEnd) return null;

        TreeNode root=new TreeNode(postorder[postEnd]);
        int inRoot=map.get(root.val);
        int numLeft=inRoot-inStart;
        //post->Left,right,root
    
        root.left=buildTree(inorder,inStart,inRoot-1,postorder,postStart,postStart+numLeft-1,map);
        root.right=buildTree(inorder,inRoot+1,inEnd,postorder,postStart+numLeft,postEnd-1,map);

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }

        TreeNode root=buildTree(inorder,0,inorder.length-1,postorder,0,postorder.length-1,map);
        return root;

    }
}