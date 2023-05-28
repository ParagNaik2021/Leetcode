*******************************Construct Binary Tree from Preorder and Inorder Traversal*****************************************


class Solution {
    public TreeNode buildTree(int[] preorder,int preStart,int preEnd,int[] inorder,int inStart,int inEnd,HashMap<Integer,Integer> map)
    {
        if(preStart>preEnd || inStart>inEnd) return null;
        TreeNode root=new TreeNode(preorder[preStart]);//will give root of entire tree
        int inRoot=map.get(root.val);//index of root in inorder
        int numsLeft=inRoot-inStart;

        root.left=buildTree(preorder,preStart+1,preStart+numsLeft,inorder,inStart,inRoot-1,map);
        root.right=buildTree(preorder,preStart+numsLeft+1,preEnd,inorder,inRoot+1,inEnd,map);

        return root;



    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }
        TreeNode root=buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);
        return root;


    }
}
