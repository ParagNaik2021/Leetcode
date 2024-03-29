*******************************236. Lowest Common Ancestor*****************************************

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        	if(root==null) return null;
		if(root==p || root==q) return root;
		
		
		TreeNode left=lowestCommonAncestor(root.left,p,q);
		TreeNode right=lowestCommonAncestor(root.right,p,q);
		
		
		if(left==null) return right;
		
		else if(right==null) return left;
		//if both are not null then this is our LCA
	
    else{
		    return root;
    }   
    }
}
