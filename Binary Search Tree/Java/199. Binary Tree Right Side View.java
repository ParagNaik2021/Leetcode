*******************************Right View of Binary Tree*****************************************

class Solution {
    public void rightView(TreeNode root,int level,List<Integer> ans)
    {
        if(root==null) return;

        if(level==ans.size()) ans.add(root.val);
        rightView(root.right,level+1,ans);
        rightView(root.left,level+1,ans);

      
    }

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> ans=new ArrayList<Integer>();
        int level=0;
        rightView(root,level,ans);
        return ans;

    }
}